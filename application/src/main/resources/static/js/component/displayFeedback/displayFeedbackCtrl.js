(function(angular) {
	angular.module('openDoor').controller('displayFeedbackCtrl', ['Feedback', function(Feedback) {
		var ctrl = this;
		Feedback.getAll().then(function (feedback) {
			ctrl.feedback = feedback;
		});

	}]);
})(this.angular);