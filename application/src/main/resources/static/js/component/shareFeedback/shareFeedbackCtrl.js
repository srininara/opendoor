(function(angular) {
	angular.module('openDoor').controller('shareFeedbackCtrl', ['Location', 'Feedback', function(Location, Feedback) {
		var ctrl = this;
		Location.get().then(function(locations) {
			ctrl.locations = locations;
			ctrl.location = locations[0] && locations[0].id.toString();
		});

		var clearForm = function() {
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
			return ctrl.feedback.trim() === '' || ctrl.location.trim() === '' || ctrl.rating === '';
		};

		ctrl.submit = function() {
			if (ctrl.isFormNotValid()) {
				return false;
			}
			var feedbackDetails = {
				respondent: ctrl.name,
				message: ctrl.feedback,
				locationId: ctrl.location,
				bliss: ctrl.rating

			};
			ctrl.isSaving = true;
			Feedback.save(feedbackDetails).then(function() {
				clearForm();
			}).finally(function() {
				ctrl.isSaving = false;
			});
		};
	}]);
})(this.angular);