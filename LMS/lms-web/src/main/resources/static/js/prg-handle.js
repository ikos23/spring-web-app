$(function() {
	
  var statusBar = $(".successAlertDiv");
  var errorsBar = $(".errorsBar");
	
  statusBar.hide();
  errorsBar.hide();
  
  // load programs for phase form
  getActivePrograms(populateProgramsForPhaseForm);
	
  $("#submitCreateBtnId").click(event => { createProgram(); });
  
  $("#createPhaseSubmitBtn").click(event => { createPhase(); });
  
  $(".delPhase").click(event => { deletePhase(event); });

  /*
   * Create new mentorship program. 
   */
  function createProgram() {
    var program = {
      'name' :      $("#nameId").val(),
	  'office' :    $("#officeId").val(),
	  'startDate' : $("#startDateId").val(),
      'endDate' :   $("#endDateId").val()		
    };
    
    callPOSTService('/lms-web/mtprograms/create', program, 
    		createProgramHandleSuccessRes, showErrors, ajaxFailHandler);
  }
  
  function createPhase() {
    var phase = {
	  'name' :      $("#pnameId").val(),
	  'programID' : $("#prgpId").val(),
	  'startDate' : $("#pstartDateId").val(),
	  'endDate' :   $("#pendDateId").val()		
    };
    
    callPOSTService('/lms-web/mphase/create', phase, 
    		createProgramHandleSuccessRes, showErrors, ajaxFailHandler);
  }
  
  function deletePhase(event) {
    var elemID = event.currentTarget.id.split("_")[1];
    var path = '/lms-web/del/phase/' + elemID;

    var deleted = false;
    callDELETEService(path, data => { console.log(data); alert(data.message);
                deletePhaseUpdateDOM(event.currentTarget.id);}, (x,s,e) => {
        alert('AJAX Fail : error ' + x + ' , status ' + s);
    });

  }
  
  function getActivePrograms(resultsHandler) {
	  callGETService('/lms-web/get/active/programs/json', resultsHandler, ajaxFailHandler);  
  }
  
  function populateProgramsForPhaseForm(data) {
	  var programSelect = $("#prgpId");
	  programSelect.empty();
	  data.sort((first, second) => {
		  return new Date(second.creationDate).getTime() - new Date(first.creationDate).getTime();
	  });
	  data.forEach(el => { programSelect.append('<option value="'+ el.id + '">' + el.name + '</option>'); });
  }
  
	
  function createProgramHandleSuccessRes(data) {
    statusBar.empty();
	statusBar.append('<div class="alert alert-success" role="alert" style="padding: 10px; margin-bottom: 10px;">' + data.message + '</div>');
	errorsBar.empty();
	statusBar.show();
	
	getActivePrograms(populateProgramsForPhaseForm);
  }
	
  function showErrors(data) {
	statusBar.hide();
	errorsBar.empty();
	data.errors.forEach(function (el) {
		errorsBar.append('<div class="alert alert-danger" role="alert" style="padding: 10px; margin-bottom: 10px;">' 
				+  el.description + '</div>');
	});
	errorsBar.show();
  }
	
  function ajaxFailHandler(xhr, status, error) {
    statusBar.hide();
    errorsBar.empty();
    errorsBar.append('<div class="alert alert-danger" role="alert" style="padding: 10px; margin-bottom: 10px;"> Error :' 
	    +  xhr + ', status ' + status  + '</div>');
    errorsBar.show();
  }
  
  function deletePhaseUpdateDOM(phaseID) {
	  var pid = '#' + phaseID;
	  $(pid).parent().remove();
  }

});