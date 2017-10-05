(function(angular) {
	angular.module("openDoor", [])
		.controller('OpenDoorCtrl', ['$scope', 'Location', 'Feedback', function($scope, Location, Feedback) {
			Location.get().then(function(locations) {
				$scope.locations = locations;
				$scope.location = locations[0] && locations[0].id.toString();
			});

			var clearForm = function() {
				$scope.name = '';
				$scope.title = '';
				$scope.feedback = '';
				$scope.rating = '';
				$scope.location = $scope.locations && $scope.locations[0] && $scope.locations[0].id.toString();
			}

			clearForm();

			$scope.setRating = function(rating) {
				if (!$scope.isSaving) {
					$scope.rating = rating;
				}
			};

			$scope.isFormNotValid = function() {
				return $scope.feedback.trim() === '' || $scope.location.trim() === '' || $scope.rating === '';
			};

			$scope.submit = function() {
				if ($scope.isFormNotValid()) {
					return false;
				}
				var feedbackDetails = {
					respondent: $scope.name,
					title: $scope.title,
					message: $scope.feedback,
					locationId: $scope.location,
					bliss: $scope.rating

				};
				$scope.isSaving = true;
				Feedback.save(feedbackDetails).then(function() {
					clearForm();
				}).finally(function() {
					$scope.isSaving = false;
				});
			};
		}]);
})(this.angular);