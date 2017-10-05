(function(angular) {
    angular.module('openDoor').controller('displayFeedbackCtrl', ['Feedback', 'Comment', '$location', function(Feedback, Comment, $location) {
        var ctrl = this;
        var id = $location.search().id;
        Feedback.getById(id).then(function(feedback) {
            ctrl.feedback = feedback;
        });

        ctrl.addComment = false;

        Comment.getAll(id).then(function(comments) {
            ctrl.comments = comments;
        });

        var vote = function(id, data) {
            Feedback.vote(id, data);
        };

        ctrl.upVote = function(currentFeedback) {
            vote(currentFeedback.id, {
                upvotes: 1
            });
            currentFeedback.rating.upvotes += 1;
        };

        ctrl.downVote = function(currentFeedback) {
            vote(currentFeedback.id, {
                downvotes: 1
            });
            currentFeedback.rating.downvotes += 1;
        };

        ctrl.toggleAddComment = function() {
            ctrl.addComment = !ctrl.addComment;
        };

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
                ctrl.addComment = false;
            });
        };
    }]);
})(this.angular);