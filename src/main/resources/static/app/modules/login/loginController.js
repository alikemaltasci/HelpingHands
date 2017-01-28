'use strict';

angular
		.module('helpingHandsApp')
		.controller(
				'loginController',
				[
						'$rootScope',
						'$scope',
						'loginService',
						function($rootScope, $scope, loginService) {

							$scope.user = {
								name : null,
								surname : null,
								email : '',
								password : '',
								phone : null
							};

							$scope.login = function login() {

								loginService
										.login($scope.user)
										.then(
												function(data) {
													if (data) {
														$scope.user = data;
														$rootScope.user = $scope.user;
														$rootScope.go("/user");
														return;
													}
												},
												function(errResponse) {
													console
															.error('Error while loggin User in controller');
												});
							}

						} ]);