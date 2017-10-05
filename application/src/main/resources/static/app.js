(function(angular) {
	var app = angular.module("openDoor", ["ngRoute"]);

	app.config(function($routeProvider) {
		$routeProvider
			.when("/", {
				template: "<feedbacks></feedbacks>"
			})
			.when("/shareFeedback", {
				template: "<share-feedback></share-feedback>"
			})
	});
})(this.angular);