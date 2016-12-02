var app = angular.module('configApp.services', []);

app.service('UserService', function($http){
	var url = 'api/user';
	this.findOne = function(id){
		return $http.get(url+'/'+id);
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
	
	this.save = function(lista){
		return $http.post(url, lista);
	}
	
});
