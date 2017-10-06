(function(angular) {
	angular.module('openDoor').controller('feedbackCtrl', ['Feedback', function(Feedback) {
		var ctrl = this;
		var page = 0;
		var pageSize = 10;

		ctrl.feedback = [];
		ctrl.hasMorePagesLeft = false;

		var getFeedbacks = function() {
            Feedback.getAll(page, pageSize).then(function(feedback) {
                if (feedback && feedback.length) {
                    ctrl.feedback.push.apply(ctrl.feedback, feedback);
                    ctrl.hasMorePagesLeft = feedback.length === pageSize;
                    return;
                }

                ctrl.hasMorePagesLeft = false;
            });
		};

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

		ctrl.$onInit = function () {
            getFeedbacks();
		};

		ctrl.loadMore = function() {
			page++;
            getFeedbacks();
		};
	}]);
})(this.angular);