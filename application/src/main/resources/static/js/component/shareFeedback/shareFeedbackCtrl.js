(function(angular) {
	angular.module('openDoor').controller('shareFeedbackCtrl', ['Location', 'Feedback', '$location',
		function(Location, Feedback, $location) {
		var ctrl = this;
		var categoryId = $location.search().category;
		ctrl.categoryId = categoryId;

		Location.get().then(function(locations) {
			ctrl.locations = locations;
			ctrl.location = locations[0] && locations[0].id.toString();
		});

		var clearForm = function() {
			ctrl.title = '';
			ctrl.name = '';
			ctrl.feedback = '';
			ctrl.rating = '';
			ctrl.location = ctrl.locations && ctrl.locations[0] && ctrl.locations[0].id.toString();
		}

		clearForm();

		ctrl.setRating = function(rating) {
			if (!ctrl.isSaving) {
				ctrl.rating = rating;
			}
		};

		ctrl.isFormNotValid = function() {
            var isTitleNFeedbackValid = ctrl.title.trim() === '' || ctrl.feedback.trim() === '';

			if (categoryId !== '1') {
				return isTitleNFeedbackValid || ctrl.rating === '';
			}

			return isTitleNFeedbackValid;
		};

		ctrl.submit = function() {
			if (ctrl.isFormNotValid()) {
				return false;
			}
			var feedbackDetails = {
				title: ctrl.title,
				respondent: ctrl.name,
				message: ctrl.feedback,
				location: {
					id: ctrl.location
				},
				bliss: ctrl.rating,
				category: {
					id: categoryId
				}

			};
			ctrl.isSaving = true;
			Feedback.save(feedbackDetails).then(function() {
				clearForm();
				$location.path("/");
			}).finally(function() {
				ctrl.isSaving = false;
			});
		};
	}]);
})(this.angular);