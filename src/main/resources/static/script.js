
var app = angular.module("app", [ "ngRoute" ]);
var lgNam = '';
app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'home.html'
	});
	$routeProvider.when('/restaurants', {
		templateUrl : 'restaurant.html',
		controller : 'restaurantCtrl'
	});
	$routeProvider.when('/items', {
		templateUrl : 'items.html',
		controller : 'itemsCtrl'
	});
	$routeProvider.when('/login', {
		templateUrl : 'login.html',
		controller : 'loginCtrl'
	});
	$routeProvider.otherwise({
		redirectTo : '/home'
	});
} ]);
 



app.controller("restaurantCtrl", function($scope, $http) {

	$scope.fetchRestaurant = function() {
		$http({
			method : 'GET',
			url : 'http://localhost:9080/restaurant/getAll'
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.restaurants = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
	
	$scope.saveRestaurant = function() {

		$http({
			method : 'POST',
			url : 'http://localhost:9080/restaurant/add',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.restaurant
		}).success(function(data, status) {
			console.log(data);
			$scope.fetchRestaurant();
			$scope.restaurants = data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};

});

app.controller("itemsCtrl", function($scope, $http) {
	$scope.init = function(){
		$scope.lgName = lgNam;
		$scope.visb1='none'
		$scope.visb2='none'
		$scope.visb3='none'
	};
	$scope.item1itr = function(){
		console.log($scope.s1);
		$http({
			method : 'GET',
			url : 'http://localhost:9080/restaurant/ItemsById?id=' + $scope.s1,
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.item1 = data;
			$scope.visb1='block'
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	$scope.item2itr = function(){
		$http({
			method : 'GET',
			url : 'http://localhost:9080/restaurant/getByCity',
			data:$scope.s2
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.item2 = data;
			$scope.visb2='block'
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	$scope.item3itr = function(){
		$http({
			method : 'GET',
			url : 'http://localhost:9080/restaurant/getByName',
			data:$scope.s3
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.item3 = data;
			$scope.visb3='block'
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
});

app.controller("loginCtrl", function($scope, $http){
	
	$scope.loginUser = function(){
	
		$http({
			method : 'POST',
			url : 'http://localhost:9080/user/login',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.user
		}).success(function(data, status) {
			console.log(data);
			if(data){
				$scope.message = "Welcome Back:" + data.name;
				console.log($scope.lgText);
				lgNam =  "Welcome Back:" + data.name;
				console.log(lgNam);
				window.location = "/#/items"
			}else{
				$scope.message = "Login Failed";
			}
		}).error(function(data, status) {
			$scope.status = status;
			console.log(data);
			$scope.message = "Request failed";
		});
	};

});
 
