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

        var clearForm = function() {
            ctrl.comment = '';
        }

        clearForm();

        ctrl.isFormNotValid = function() {
            return ctrl.comment.trim() === '';
        };

        ctrl.submit = function() {
            if (ctrl.isFormNotValid()) {
                return false;
            }

            var commentDetails = {
                feedbackId: id,
                comment: ctrl.comment
            }
            ctrl.isSaving = true;
            Comment.save(commentDetails).then(function(data) {
                clearForm();
                ctrl.comments.push(data);
            }).finally(function() {
                ctrl.isSaving = false;
            });
        };
	}]);
})(this.angular);