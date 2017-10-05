(function(angular) {
	angular.module('openDoor').controller('feedbackCtrl', ['Feedback', function(Feedback) {
		var ctrl = this;
		Feedback.getAll().then(function (feedback) {
			ctrl.feedback = feedback;
		});
	}]);
})(this.angular);