(function(angular) {
	angular.module('openDoor').factory('Location', function($http) {

		var get = function() {
			return $http.get('/locations').then(function(response) {
				return response.data;
			});
		};

		return {
			get: get
		}

	});
})(this.angular, this._);