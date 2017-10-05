(function(angular) {
	angular.module('openDoor').controller('feedbackCtrl', ['Feedback', function(Feedback) {
		var ctrl = this;
		Feedback.getAll().then(function(feedback) {
			ctrl.feedback = feedback;
		});

		var vote = function(id, data) {
			Feedback.vote(id, data);
		};

		ctrl.upVote = function(currentFeedback) {
			vote(currentFeedback.id, {upvotes: 1} );
			currentFeedback.rating.upvotes += 1;
		};

		ctrl.downVote = function(currentFeedback) {
			vote(currentFeedback.id, { downvotes: 1 } );
			currentFeedback.rating.downvotes += 1;
		};

		ctrl.isMinimal = function() {
			if (typeof ctrl.minimal !== 'undefined') return ctrl.minimal;

			return false;
		};
	}]);
})(this.angular);