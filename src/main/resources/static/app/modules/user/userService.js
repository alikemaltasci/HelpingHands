'use strict';

angular
		.module('helpingHandsApp')
		.factory(
				'userService',
				[
						'$http',
						'$q',
						function($http, $q) {

							var REST_SERVICE_URI = '/user';

							var factory = {
								getUserInfo : getUserInfo,
								update : update
							};

							return factory;

							function getUserInfo(userId) {
								var deferred = $q.defer();
								$http
										.get(REST_SERVICE_URI + "/"+ userId)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating User in service');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

							function update(user) {
								var deferred = $q.defer();
								$http
										.post(REST_SERVICE_URI, user)
										.then(
												function(response) {
													deferred
															.resolve(response.data);
												},
												function(errResponse) {
													console
															.error('Error while updating User in service');
													deferred
															.reject(errResponse);
												});
								return deferred.promise;
							}

						} ]);