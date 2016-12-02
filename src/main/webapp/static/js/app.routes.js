var app = angular.module('configApp.routes', ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'static/html/components.html',
            controller: 'ComponentController'
        })
        .when('/AddEditComponent', {
            templateUrl : 'static/html/AddEditComponent.html',
            controller: 'ComponentController'
        })
        .when('/component/edit/:id', {
        	templateUrl : 'static/html/AddEditComponent.html',
        	controller: 'ComponentController'
        }).when('/profile/:id', {
        	templateUrl : 'static/html/Profile.html',
        	controller: 'ProfileController'
        })
        .when('/configuration', {
        	templateUrl : 'static/html/configuration.html',
        	controller: 'ConfigurationController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);