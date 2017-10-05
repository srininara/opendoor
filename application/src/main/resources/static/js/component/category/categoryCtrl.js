(function(angular) {
	angular.module('openDoor').controller('categoryCtrl', ['Category', function(Category) {
		var ctrl = this;
		Category.get().then(function(categories) {
			ctrl.categories = categories;
		});

		ctrl.getFeedbackUrl = function(id) {
			return '#!shareFeedback?category=' + id;
		}
	}]);
})(this.angular);