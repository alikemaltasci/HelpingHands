'use strict';

angular
		.module('helpingHandsApp')
		.controller(
				'startProjectController',
				[
						'$rootScope',
						'$scope',
						'startProjectService',
						function($rootScope, $scope, startProjectService) {

							$scope.project = {
								id : null,
								userId : null,
								name : '',
								description : '',
								createdDate : null
							};

							$scope.numberOfNeededSupports = '';
							$scope.minNumberOfNeededSupports = 1;
							$scope.maxNumberOfNeededSupports = 5;

							$scope.createProject = function() {

								startProjectService
										.createProject($scope.project)
										.then(
												function(data) {
													$rootScope.go("/user");
													return;
												},
												function(errResponse) {
													console
															.error('Error while creating Project in controller');
												});
							}

							$scope.refreshNeededSupports = function() {
								$scope.project.neededSupports = [];
								for (var i = 0; i < $scope.numberOfNeededSupports; i++) {
									$scope.project.neededSupports.push({
										id : null,
										projectId : null,
										name : '',
										description : '',
										amount : '',
										unit : ''
									});
								}
							}

							if (!$rootScope.user) {
								$rootScope.go('/login');
								return;
							} else {
								$scope.project.userId = $rootScope.user.id;
							}

							// Watches
							$scope
									.$watch(
											'numberOfNeededSupports',
											function() {
												if ($scope.numberOfNeededSupports) {

													if (isNaN($scope.numberOfNeededSupports)) {
														$scope.numberOfNeededSupports = $scope.minNumberOfNeededSupports;
													} else if (Number($scope.numberOfNeededSupports) > $scope.maxNumberOfNeededSupports) {
														$scope.numberOfNeededSupports = $scope.maxNumberOfNeededSupports;
													} else if (Number($scope.numberOfNeededSupports) < $scope.minNumberOfNeededSupports) {
														$scope.numberOfNeededSupports = $scope.minNumberOfNeededSupports;
													}

													$scope
															.refreshNeededSupports();
												}

											});

						} ]);