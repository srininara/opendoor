(function(angular) {
	angular.module('openDoor').controller('feedbackCtrl', ['Feedback', function(Feedback) {
		var ctrl = this;
		Feedback.getAll().then(function(feedback) {
			ctrl.feedback = feedback;
		});

		ctrl.upVote = function(currentFeedback) {
			// TODO: Save the up vote
			currentFeedback.upVote = currentFeedback.upVote || 0;
			currentFeedback.upVote += 1;
		};

		ctrl.downVote = function(currentFeedback) {
			// TODO: Save the up vote
			currentFeedback.downVote = currentFeedback.downVote || 0;
			currentFeedback.downVote += 1;
		};
	}]);
})(this.angular);