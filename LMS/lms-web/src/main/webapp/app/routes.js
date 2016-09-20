(function () {
	
	angular.module("LmsApp")
		.config(function($routeProvider) {
			$routeProvider.when('/', {
				template: '<home-component></home-component>'
			})
			.when('/mtprogram', {
				template: '<mtprogram></mtprogram>'
			})
		});
	
})();