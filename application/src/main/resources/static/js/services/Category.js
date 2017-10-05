(function(angular) {
	angular.module('openDoor').factory('Category', function($http) {

		var get = function() {
			return $http.get('/categories').then(function(response) {
				return response.data;
			});
		};

		return {
			get: get
		}

	});
})(this.angular, this._);