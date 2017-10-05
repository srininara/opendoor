(function(angular) {
	angular.module('openDoor').controller('displayFeedbackCtrl', ['Feedback', 'Comment', '$location', function(Feedback, Comment, $location) {
		var ctrl = this;
        var id = $location.search().id;
        Feedback.getById(id).then(function (feedback) {
            ctrl.feedback = feedback;
        });

        Comment.getAll(id).then(function (comments) {
            ctrl.comments = comments;
        });
	}]);
})(this.angular);