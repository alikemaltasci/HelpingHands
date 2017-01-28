'use strict';

angular.module('helpingHandsApp').factory('startProjectService',
		[ '$http', '$q', function($http, $q) {

			var REST_SERVICE_URI = '/project/';

			var factory = {
			    createProject: createProject,
				listProjects : listProjects
			};

			return factory;
			
			function createProject(project) {
				var deferred = $q.defer();
				$http.post(REST_SERVICE_URI, project).then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error('Error while creating project in service');
					deferred.reject(errResponse);
				});
				return deferred.promise;
			}

			function listProjects() {
				var deferred = $q.defer();
				$http.get(REST_SERVICE_URI).then(function(response) {
					deferred.resolve(response.data);
				}, function(errResponse) {
					console.error('Error while logging User in service');
					deferred.reject(errResponse);
				});
				return deferred.promise;
			}

		} ]);