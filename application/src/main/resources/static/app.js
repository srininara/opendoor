(function(angular) {
	var app = angular.module("openDoor", ["ngRoute"]);

	app.config(function($routeProvider) {
		$routeProvider
			.when("/", {
				template: "<feedbacks></feedbacks>"
			})
			.when("/category", {
				template: "<category></category>"
			})
	});
})(this.angular);