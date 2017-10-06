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

		var getAll = function(page, pageSize) {
			return $http.get('/feedback', {
				params: {
                    page: page,
                    size: pageSize,
				}
			}).then(function(response) {
				return response.data;
			});
		}

        var getById = function(id) {
            return $http.get('/feedback/'+id).then(function(response) {
                return response.data;
            });
        }

        var vote = function(id, data) {
        	return $http({
				method: 'PUT',
				url: '/feedback/' + id + '/ratings',
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
			save: save,
			getAll: getAll,
			getById: getById,
			vote: vote
		}

	});
})(this.angular, this._);