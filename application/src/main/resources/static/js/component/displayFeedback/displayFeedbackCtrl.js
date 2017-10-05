(function(angular) {
	angular.module('openDoor').controller('displayFeedbackCtrl', ['Feedback', '$location', function(Feedback, $location) {
		var ctrl = this;
        var id = $location.search().id;
        Feedback.getById(id).then(function (feedback) {
            ctrl.feedback = feedback;
        });
	}]);
})(this.angular);