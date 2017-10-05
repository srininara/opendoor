(function(angular) {
	var app = angular.module("openDoor", ["ngRoute"]);

	app.config(function($routeProvider) {
		$routeProvider
			.when("/", {
				template: "<category></category>"
			})
			.when("/shareFeedback", {
				template: "<share-feedback></share-feedback>"
			})
            .when("/displayFeedback", {
                template: "<display-feedback></display-feedback>"
            })
	});
})(this.angular);