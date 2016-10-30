var EMPL_ID;

function editPhaseEmployeeAutoCompleteSelect(event, ui) {
  $( "#lastNameAutoComplete" ).val( ui.item.firstName + ' ' +  ui.item.lastName );
  EMPL_ID = ui.item.id;
  console.log(ui.item);	
}

function editPhaseEmployeeAutoCompleteFocus(event, ui) {
  $( "#lastNameAutoComplete" ).val( ui.item.firstName + ' ' +  ui.item.lastName );
}

$( function() {
		  
var PHASE_ID = $("phaseSelectId").val();
var ROLE_ID = $("roleSelectId").val();

var selectedMenteeID;

function loadMentors() {
	$.ajax({
        type: "POST",
        url: "/lms-web/loadAvailableMentors",
        dataType: "json",
        success: function (msg) {
        	$("#availableMentorsSelect").empty();
        	$.each(msg, function (i, el) {
        		$("#availableMentorsSelect").append('<option value="' + el.id + '">' + el.firstName + ' ' + el.lastName + '</option>');
        	});
        },
        error: function (errormessage) {
        	console.log(errormessage);
        }
    });	
}

function addToTable(data) {
	
	var btnId = "uid" + data.employee.id;
	var addMentorOpertion = '<td>' +
  	  '<button type="button" ' + 'id="' + btnId + '" ' +
  	  'class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">' +
      'Add mentor</button></td>';
      
	
	var newRow = '<tr>' + 
		'<td>' + data.id + '</td>' +
		'<td>' + data.employee.firstName + '</td>' +
		'<td>' + data.employee.lastName + '</td>' +
		'<td>' + data.phase.name + '</td>' +
		'<td>' + data.role.name + '</td>' +
		((data.role.id == 2) ? addMentorOpertion : '<td></td>') +
	'</tr>';
	
	$("tbody", $("#addedEmplList")).append(newRow);
	
	$("#" + btnId).click(function(e) {
		selectedMenteeID = data.employee.id;
		console.log('Mentee ' + data.employee.id);
		loadMentors();
	});
}

function saveParticip() {
	$.ajax({
        type: "POST",
        url: "/lms-web/assignEmployee",
        data: { roleID : $("#roleSelectId").val(),
        	    employeeID : EMPL_ID,
        	    phaseID : $("#phaseSelectId").val()	  
        },
        dataType: "json",
        success: function (msg) {
        	console.log(msg);
        	addToTable(msg);
        },
        error: function (errormessage) {
        	console.log(errormessage);
        }
    });
}

$("#addParticipantBtnId").click(function (e) {
	e.preventDefault();
	saveParticip();
	
	$("#lastNameAutoComplete").val("");
});

$("#addMentorBtnId").click(event => {
  var payload = {
    menteeId : new String(selectedMenteeID),
    mentorId : $("#availableMentorsSelect").val(),
    plannedStart : $("#plannedStartDateID").val(),
    plannedEnd : $("#plannedEndDateID").val()
  };
  
  console.log(payload);
  
  callPOSTService("/lms-web/createGroup", payload, d => {
	alert('OK : ' + d.message);
  	console.log('Created Group : ' + d.msg);
  	$('#myModal').modal('hide');
  }, e => {}, (x, s, e) => {
	  alert('AJAX Request Failed : ' + x + ', status ' + s);
  });
});
	    
});