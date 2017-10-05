(function(angular) {
	var app = angular.module("openDoor", ["ngRoute"]);

	app.config(function($routeProvider) {
		$routeProvider
			.when("/", {
				template: "<feedback></feedback>"
			})
			.when("/category", {
				template: "<category></category>"
			})
			.when("/shareFeedback", {
				template: "<share-feedback></share-feedback>"
			})
	});
})(this.angular);