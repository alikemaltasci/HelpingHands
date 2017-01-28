'use strict';

angular.module('helpingHandsApp').factory('loginService',
		[ '$http', '$q', function($http, $q) {

			var REST_SERVICE_URI = '/login/';

			var factory = {
				login : login
			};

			return factory;

			function login(user) {
				var deferred = $q.defer();
				$http.post(REST_SERVICE_URI, user).then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error('Error while logging User in service');
					deferred.reject(errResponse);
				});
				return deferred.promise;
			}

		} ]);