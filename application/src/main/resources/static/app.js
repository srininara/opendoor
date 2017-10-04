(function(angular) {
	angular.module("openDoor", [])
		.controller('OpenDoorCtrl', ['$scope', 'Location', function($scope, Location) {
			Location.get().then(function (locations) {
				$scope.locations = locations;
				$scope.location = locations[0] && locations[0].id.toString();
			});

			$scope.submit = function() {
				$scope.feedbackDetails = {
					name: $scope.name,
					feedback: $scope.feedback,
					location: $scope.location,
					rating: $scope.rating

				};
				$scope.name = '';
				$scope.feedback = '';
				$scope.location = '1';
				$scope.rating = '';

				window.console.log($scope.feedbackDetails);
			};
		}]);
})(this.angular);