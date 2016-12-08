var app = angular.module('configApp.controllers', ['ui.bootstrap']);

	app.controller('ProfileController',function($scope,$http,$routeParams,$location, UserService){
		
		
		$scope.init = function(){
			$scope.user = {};
			if($routeParams.id){
				UserService.findOne($routeParams.id)
				.success(function(data){
					$scope.user = data;
				})
				.error(function(){
					alert('Error in finding data');
				});
			}
		}
		
		$scope.saveChanges = function(){
			UserService.save($routeParams.id, $scope.user)
			.success(function(data){
				alert('You have succesfuly change your details.');
			})
			.error(function(){
				alert('Error in finding data');
			});
		}
		
		$scope.configurationHistory = function(){
			UserService.configurationHisory($routeParams.id)
			.success(function(data){
				$scope.configurations = data;
			})
			.error(function(){
				alert('Error in finding data');
			});
		}
	});

	app.controller('ComponentController', function($scope,$http,$routeParams,$location, ComponentService){
		
		  $scope.totalItems = 12;
		  $scope.currentPage = 1;
		  $scope.itemsPerPage = 4;

		  $scope.pageChanged = function() {
			  $scope.pageNumber = $scope.currentPage-1;
		  };
		  
		  $scope.setPageNumber = function(pageNo){
			  $scope.pageNumber = pageNo;
		  };

		  $scope.maxSize = 3;
		  $scope.bigTotalItems = 3;
		  $scope.bigCurrentPage = 1;
		
		$scope.init = function(){
			$scope.pageNumber=0;
		}
		
		$scope.getComponents = function(){
			ComponentService.get($scope.pageNumber, $scope.filter_query)
				.success(function(data,status, headers) {
					$scope.components = data;
				    itemsPerPage = headers('ukupno-elemnata');
				    $scope.firstname = headers('username');
				    $scope.id = headers('id');
				    $scope.userRole = headers('role');
				})	
				.error(function() {
					alert('Oops, something went wrong!');
				});
			
		$scope.resetFilter = function(){
		
		}			
		};
		
		$scope.deleteComponent = function(id) {
			$http.delete('api/component/' + id)
					.success(function(data,status) {
						$scope.deleted = data;
						$scope.blueAlert = true;
						$scope.getComponents();

					})
					.error(function() {
						$scope.redAlert = true;


					});
		};
		

		
		$scope.hideAlerts = function() {
			$scope.redAlert = false;
			$scope.blueAlert = false;
		};
		
		
		$scope.initComponent = function() {
			$scope.component = {};
			
			if ($routeParams && $routeParams.id) {
				// ovo je edit stranica
				$http.get('api/component/' + $routeParams.id)
						.success(function(data) {
							$scope.component = data;
						})
						.error(function() {
							
						});
			}
		};
		
		
		$scope.saveComponent = function() {
			if ($scope.component.id) {
				// edit stranica
				$http.put('api/component/' + $scope.component.id, $scope.component)
					.success(function() {
						$location.path('/component');
					})
					.error(function() {
						
					});
			} else {
				// add stranica
				$http.post('api/component', $scope.component)
					.success(function() {
						$location.path('/component');
					})
					.error(function() {
						
					});
			}
		};
		
	});
	
	app.controller('ConfigurationController', function($scope,$http,$routeParams,$location, ConfigurationService){
		
		$scope.init = function(){
			$scope.quantity = 0;
			$scope.dis = false;
			$scope.components1 = [];
			$scope.pageNumber=0;
		}
		
 	    	$scope.totalItems = 12;
		  $scope.currentPage = 1;
		  $scope.itemsPerPage = 4;

		  $scope.pageChanged = function() {
			  $scope.pageNumber = $scope.currentPage-1;
		  };
		  
		  $scope.setPageNumber = function(pageNo){
			  $scope.pageNumber = pageNo;
		  };

		  $scope.maxSize = 3;
		  $scope.bigTotalItems = 3;
		  $scope.bigCurrentPage = 1;
		
		$scope.getComponents = function(){
			
			ConfigurationService.get( $scope.pageNumber)
				.success(function(data,status) {
				 $scope.components = data;
			
				})	
				.error(function() {
					alert('Oops, something went wrong!');
				});	
		};

 $scope.saveConfiguration = function(quantity) {
	 
	 ConfigurationService.save($scope.components)
	 .success(function(data,status) {
		 $scope.getComponents();
	
		})	
		.error(function(data, status) {
			if(status == 400){
				 alert('We dont have that much in store sorry');
			 }
			
			else if (status == 406){
				alert('Type and qunatity dont match');
			}
			else{
			alert('Oops, something went wrong!');
			}
		});	
	 
 };
		
		
// $scope.conf = {};
// $scope.conf.components = [];
// $scope.saveConfiguration = function() {
//
// $scope.conf.components = $scope.components;
// angular.forEach($scope.conf.components, function(value,key) {
// if(value.quantity == 0) {
// $scope.conf.components.splice(key, 1);
// }
// });
// $http.post('/api/configuration', $scope.conf)
// .success(function(data) {
// $location.path('/configuration')
// })
// .error(function() {
//				
// });
//
// };

		
// $scope.test = function() {
// $http.get('/api/component/1')
// .success(function(data) {
// $scope.configuration = {};
// $scope.configuration.id = 2;
// $scope.configuration.components = data;
// $http.post('/api/configuration', $scope.configuration)
// .success(function(data) {
//			       
// })
// .error(function() {
//			       
// });
// })
// .error(function() {
//			     
// });
// };

		
		
		
	});

