'use strict';

angular.module('helpingHandsApp').factory('exploreService',
		[ '$http', '$q', function($http, $q) {

			var REST_SERVICE_URI = '/project/';

			var factory = {
				listProjects : listProjects,
				giveSupporting : giveSupporting
			};

			return factory;

			function listProjects() {
				var deferred = $q.defer();
				$http.get(REST_SERVICE_URI).then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error('Error while listing projects in service');
					deferred.reject(errResponse);
				});
				return deferred.promise;
			}
			
			function giveSupporting(supporting) {
				var deferred = $q.defer();
				$http.post("/supporting/",supporting).then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error('Error while giving supporting in service');
					deferred.reject(errResponse);
				});
				return deferred.promise;
			}


		} ]);