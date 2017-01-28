'use strict';

angular
		.module('helpingHandsApp')
		.controller(
				'exploreController',
				[
						'$rootScope',
						'$scope',
						'exploreService',
						function($rootScope, $scope, exploreService) {

							$scope.projects = [];
							$scope.selectedProject = null;

							$scope.listProjects = function() {

								exploreService
										.listProjects($scope.user)
										.then(
												function(data) {
													if (data) {
														$scope.projects = data;
													}
												},
												function(errResponse) {
													alert(errResponse.statusText
															+ " "
															+ errResponse.statusText);
													console
															.error('Error while signup User in controller');
												});
							}

							$scope.openProjectDetail = function(project) {
								$scope.selectedProject = project;
							}

							$scope.giveSupport = function(neededSupport) {

								if (!$rootScope.user) {
									$('#projectDetailModal').modal("hide");
									$('body').removeClass('modal-open');
									$('.modal-backdrop').remove();
									$rootScope.go('/login');
								} else {
									neededSupport.supporting.userId = $rootScope.user.id;
									neededSupport.supporting.neededSupportId = neededSupport.id;
									exploreService
											.giveSupporting(
													neededSupport.supporting)
											.then(
													function(data) {
														
													},
													function(errResponse) {
														alert(errResponse.statusText
																+ " "
																+ errResponse.statusText);
														console
																.error('Error while signup User in controller');
													});
								}

							}

							$scope.listProjects();

						} ]);