function MtProgramController($http) {
	
	var refToThisCtrl = this;
	
	// create new phase form uses this model
	this.program = {
			selectedPrg : null,
			existing : []
	};
	
	this.errors = [];
	
	this.wasSuccessful = false;
	
	this.changeSuccAlertState = function(val) {
		refToThisCtrl.wasSuccessful = val;
	};
	
	function getPrograms() {
		 
		$http.get('/lms-web/mtprograms/all/json').then(function success(resp) {
			refToThisCtrl.program.existing = resp.data;
		}, function fail(resp) {
			alert('Programs Not Found !');
			program.existing = [];
		})
	};
	
	// get if any when page has been loaded.
	getPrograms();
	
	// create new program handler
	this.create = function(program) {
		
		$http.post('/lms-web/mtprograms/create', {
			'name' : program.name,
			'office' : program.office,
			'startDate' : program.startDate,
			'endDate' : program.endDate
		}).then(function (resp) {
			if (resp.data.httpStatusCode == 200) {
				refToThisCtrl.changeSuccAlertState(true);
				refToThisCtrl.errors = [];
				refToThisCtrl.program.existing = getPrograms();
			}
			
			if (resp.data.httpStatusCode == 400) { // show errors
				refToThisCtrl.errors = resp.data.errors;
				refToThisCtrl.changeSuccAlertState(false);
			}
			
		}, function(resp) {
			alert('Fail: Program is not created.');
			refToThisCtrl.changeSuccAlertState(false);
		});
	};
	
	this.createPhase = function(phase) {

		$http.post('/lms-web/mphase/create', {
			'name' : phase.name,
			'mentorshipProgramID' : refToThisCtrl.program.selectedPrg,
			'startDate' : phase.startDate,
			'endDate' : phase.endDate
		}).then(function (resp) {
			if (resp.data.httpStatusCode == 200) { // ok
				refToThisCtrl.changeSuccAlertState(true);
				refToThisCtrl.errors = [];
			}
			
			if (resp.data.httpStatusCode == 400) { // show errors
				refToThisCtrl.errors = resp.data.errors;
				refToThisCtrl.changeSuccAlertState(false);
			}
			
		}, function(resp) {
			alert('Fail: Phase is not added .');
			refToThisCtrl.changeSuccAlertState(false);
		});
		
	};
	
}

angular.module('LmsApp').component('mtprogram', {
	templateUrl : 'app/mtprogram/mtprogram.html',
	controller : MtProgramController,
});