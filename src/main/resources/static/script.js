
var app = angular.module("app", [ "ngRoute" ]);
var lgNam = '';
var ifLoggedIn = false;


app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/home', {
		templateUrl : 'home.html',
		controller : 'homeCtrl'
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
	$routeProvider.when('/signup', {
		templateUrl : 'signup.html',
		controller : 'signupCtrl'
	});
	$routeProvider.otherwise({
		redirectTo : '/home'
	});
} ]);
 
app.controller("homeCtrl", function($scope, $http) {
	$scope.login = function(){
		window.location = '/#/login'
	};
	$scope.signUp = function(){
		window.location = '/#/signup'
	};
});



app.controller("restaurantCtrl", function($scope, $http) {
	$scope.init = function(){
		$scope.disp = 'none';
	};


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
	
	$scope.resturantByName = function(){
		console.log($scope.r2);
		$http({
			method : 'GET',
			url : 'http://localhost:9080/restaurant/getByName?id=' + $scope.r2
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.disp = 'block';
			$scope.restaurants = [data];
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	
	$scope.resturantByCity = function(){
		console.log($scope.r1);
		$http({
			method : 'GET',
			url : 'http://localhost:9080/restaurant/getByCity?name=' + $scope.r1
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.disp = 'block';
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
			$scope.restaurants= data;
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};

});

app.controller("itemsCtrl", function($scope, $http) {
	$scope.init = function(){
		if(!ifLoggedIn){
			window.location = "/#/login"
		}
		$scope.lgName = lgNam;
		$scope.visb1='none'
		$scope.visb2='none'
		$scope.visb3='none'
		
	};
	$scope.item1itr = function(){
		console.log($scope.s1);
		$http({
			method : 'GET',
			url : 'http://localhost:9080/restaurant/listItems?id=' + $scope.s1
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.test=data;
			$scope.visb1='block'
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	$scope.item2itr = function(){
		$http({
			method : 'GET',
			url : 'http://localhost:9080/restaurant/ItemsById?id=' + $scope.s2,
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.test = [data];
			$scope.visb1='inline'
		}).error(function(data, status) {
			$scope.status = status;
			$scope.data = "Request failed";
		});
	};
	$scope.item3itr = function(){
		$http({
			method : 'GET',
			url : 'http://localhost:9080/restaurant/ItemsByName?name=' + $scope.s3,
			data:$scope.s3
		}).success(function(data, status) {
			console.log(data);
			$scope.status = status;
			$scope.test = data;
			$scope.visb1='block'
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
				$scope.message = "Welcome Back:  " + data.name;
				console.log($scope.lgText);
				lgNam =  "Welcome Back: " + data.name;
				console.log(lgNam);
				ifLoggedIn = true;
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
	$scope.signUp = function(){
		window.location = "/#/signup"
	};

});
 
app.controller("signupCtrl", function($scope, $http){
	$scope.signUp = function(){
		console.log($scope.user);
		$http({
			method : 'POST',
			url : 'http://localhost:9080/user/add',
			headers: { 'Content-Type': 'application/json' },
			data:$scope.user
		}).success(function(data, status) {
			$scope.message = "Hey " + data.name + ". You are in!!"
		}).error(function(data, status) {
			$scope.status = status;
			console.log(data);
			$scope.message = "Hey you got something wrong. Check";
		});
	};

	$scope.reset = function(){
		$scope.user = angular.copy($scope.initial);
	};

	$scope.cancel = function(){
		window.location = "/#/home";
	};
});
