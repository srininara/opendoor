(function(angular) {
	angular.module('openDoor').factory('Comment', function($http, $q) {

        var save = function(data) {
            var deferred = $q.defer();
			var feedbackId = data.feedbackId;
			return $http({
				method: 'POST',
				url: '/feedback/'+feedbackId+'/comments',
				data: {comment: data.comment},
				headers: {
					'Content-Type': 'application/json',
					'Accept': 'application/json'
				}
			}).then(function(response) {
				deferred.resolve(response.data);
				return deferred.promise;
			});
		};

		var getAll = function(feedbackId) {
			return $http.get('/feedback/'+feedbackId+'/comments').then(function(response) {
				return response.data;
			});
		}

		return {
			save: save,
			getAll: getAll
		}

	});
})(this.angular, this._);