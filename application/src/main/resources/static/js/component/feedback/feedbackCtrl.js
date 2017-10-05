(function(angular) {
	angular.module('openDoor').controller('feedbackCtrl', ['Feedback', function(Feedback) {
		var ctrl = this;
		Feedback.getAll().then(function(feedback) {
			ctrl.feedback = feedback;
		});

		ctrl.upVote = function(currentFeedback) {
			Feedback.vote(currentFeedback.id, {
				upvotes: 1
			}).then(function(feedback) {
				currentFeedback = feedback
			});
			currentFeedback.rating.upvotes += 1;
		};

		ctrl.downVote = function(currentFeedback) {
			Feedback.vote(currentFeedback.id, {
				downvotes: 1
			}).then(function(feedback) {
				currentFeedback = feedback
			});
			currentFeedback.rating.downvotes += 1;
		};

		ctrl.isMinimal = function() {
			if (typeof ctrl.minimal !== 'undefined') return ctrl.minimal;

			return false;
		};
	}]);
})(this.angular);