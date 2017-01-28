'use strict';

angular.module('helpingHandsApp').controller('userController',
		[ '$rootScope','$scope', 'userService', function($rootScope, $scope, userService) {

			
			$scope.refreshUserInfo = function(userId) {

				userService.getUserInfo(userId).then(function(data) {
					$rootScope.user = data;
					$scope.user = $rootScope.user;
				}, function(errResponse) {
					console.error('Error while getting user info in controller');
				});
			}

			$scope.update = function() {

				userService.update($scope.user).then(function(data) {
					$rootScope.user = $scope.user;
					$rootScope.go("/");
					return;
				}, function(errResponse) {
					console.error('Error while updating User in controller');
				});
			}
			
			$scope.showProjectDetail = function(projectId){
				alert(projectId);
			}
			
			
			if (!$rootScope.user) {
				$rootScope.go('/login');
				return;
			}else{
				$scope.refreshUserInfo($rootScope.user.id);
			}

		} ]);