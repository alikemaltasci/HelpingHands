'use strict';

angular.module('helpingHandsApp').factory('signupService',
		[ '$http', '$q', function($http, $q) {

			var REST_SERVICE_URI = '/user/';

			var factory = {
				signup : signup
			};

			return factory;

			function signup(user) {
				var deferred = $q.defer();
				$http.post(REST_SERVICE_URI, user).then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error('Error while signup User in service');
					deferred.reject(errResponse);
				});
				return deferred.promise;
			}

		} ]);