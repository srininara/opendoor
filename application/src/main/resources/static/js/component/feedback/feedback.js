(function(angular) {
	angular.module('openDoor').component('feedback', {
		templateUrl: 'js/component/feedback/feedback.html',
		controller: 'feedbackCtrl as feedback',
		bindings: {
			minimal: '<'
		}
	});
})(this.angular);