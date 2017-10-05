(function(angular) {
	angular.module('openDoor').factory('Feedback', function($http) {

		var save = function(data) {
			return $http({
				method: 'POST',
				url: '/feedback',
				data: data,
				headers: {
					'Content-Type': 'application/json',
					'Accept': 'application/json'
				}
			}).then(function(response) {
				return response.data;
			});
		};

		return {
			save: save
		}

	});
})(this.angular, this._);