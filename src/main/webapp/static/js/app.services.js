var app = angular.module('configApp.services', []);

app.service('UserService', function($http) {
	var url = 'api/user';

	this.save = function(id, user) {
		return $http.put(url + '/' + id, user);
	}

	this.findOne = function(id) {
		return $http.get(url + '/' + id);
	}
	this.configurationHisory = function(id) {
		return $http.get(url + '/' + id + "/configuration");
	}
});

app.service('ComponentService', function($http) {

	var url = 'api/component';

	this.get = function(pageNumber, filter_query) {
		return $http.get(url, {
			params : {
				'pageNumber' : pageNumber,
				'filter_query' : filter_query
			}
		});
	}

});

app.service('ConfigurationService', function($http) {

	var url = 'api/order';
	var urlComponent = 'api/component';

	this.save = function(lista) {
		return $http.post(url, lista);
	}
	
	this.get = function(pageNumber) {
		return $http.get(urlComponent, {
			params : {
				'pageNumber' : pageNumber,
			}
		});
	}

});
