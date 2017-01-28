'use strict';

var App = angular.module('helpingHandsApp', ['ngRoute','ngResource']);

App.run(function($rootScope,$location) {
    $rootScope.user = null;
    
    
    $rootScope.go = function ( path ) {
    	  $location.path( path );
    	};
    
    $rootScope.logout = function(){
    	$rootScope.user = null;
    	$rootScope.go("/");
    }
    
   
})

App.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/explore', {
		templateUrl : 'app/modules/explore/explore.html',
		controller : "exploreController"
	}).when('/startProject', {
		templateUrl : 'app/modules/startProject/startProject.html',
		controller : "startProjectController"
	}).when('/about', {
		templateUrl : 'app/modules/about/about.html'
	}).when('/login', {
		templateUrl : 'app/modules/login/login.html',
		controller : "loginController"
	}).when('/signup', {
		templateUrl : 'app/modules/signup/signup.html',
		controller : "signupController"
	}).when('/user', {
		templateUrl : 'app/modules/user/user.html',
		controller : "userController"
	}).otherwise({
		templateUrl : 'app/modules/main/main.html'
	});
} ]);