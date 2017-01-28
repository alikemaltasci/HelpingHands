'use strict';

angular
		.module('helpingHandsApp')
		.controller(
				'signupController',
				[
						'$rootScope',
						'$scope',
						'signupService',
						function($rootScope, $scope, signupService) {

							$scope.user = null;

							resetModel();

							function resetModel() {
								$scope.user = {
									name : '',
									surname : '',
									email : '',
									password : '',
									phone : ''
								};
							}

							$scope.signUp = function() {

								signupService
										.signup($scope.user)
										.then(
												function(data) {

													$scope.user = data;
													$rootScope.user = $scope.user;
													$rootScope.go("/user");
													return;

												},
												function(errResponse) {

													console
															.error('Error while signup User in controller');
												});
							}

						} ]);