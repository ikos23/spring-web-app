function HomeController($http) {
	
	var refToThisCtrl = this;
	
	this.activePrograms = {
			plist : []
	};
	
	this.employees = [];
	
	function getEmployees() {
		$http.get('/lms-web/employees/json').then(function success(resp) {
			refToThisCtrl.employees = resp.data;
		}, function fail(resp) {
			alert('Service Error');
			refToThisCtrl.employees = [];
		})
	}
	
	function getActivePrograms() {
		 
		$http.get('/lms-web/mtprograms/active/json').then(function success(resp) {
			refToThisCtrl.activePrograms.plist = resp.data;
		}, function fail(resp) {
			alert('Service Error');
			refToThisCtrl.activePrograms.plist = [];
		})
	};
	
	getActivePrograms();
	getEmployees();
	
	console.log(refToThisCtrl.activePrograms.plist);
	
	this.deletePhase = function(programId, phaseId) {
		var path = '/lms-web/del/phase/' + phaseId;
		
		$http.delete(path).then(function success(resp) {
			
			alert('Phase deleted successfully !');
			
			var progs = refToThisCtrl.activePrograms.plist;
			for (var i=0; i < progs.length; i++) {
				if (progs[i].id == programId) {
					for (var j=0; j < progs[i].phases.length; j++) {
						if (progs[i].phases[j].id == phaseId) {
							progs[i].phases.splice(j, 1);
							break;
						}
					}
					break;
				}
			}
			
			
		}, function fail(resp) {
			alert('Delete phase error. Not deleted !');
			console.log(resp);
		})
	};
	
}

angular.module('LmsApp').component('homeComponent', {
	templateUrl : 'app/home/home.html',
	controller : HomeController
});