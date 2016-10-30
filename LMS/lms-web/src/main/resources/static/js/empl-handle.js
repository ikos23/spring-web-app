function loadEmployeeData() {
  console.log('Load Employess Data');
  callGETService('/lms-web/employees/json', handleSuccessResponse, ajaxFailHandler);	  
}
  
function handleSuccessResponse(data) {
  var tbody = $("#emplTabBodyID");
  var index = 0;
  tbody.empty();
  data.forEach(el => {
    tbody.append(emplRow(++index, el.firstName, el.lastName, 
      el.birthDate, el.primarySkill, el.level, el.manager));	
  });
}
  
function ajaxFailHandler(xhr, status, error) {
  alert('error ' + status + ', ' + error);
}

function emplRow(index, firstName, lastName, birthDate, primarySkill, level, manager) {
  return '<tr><td>' + index + '</td><td>'
      + firstName + '</td><td>'
      + lastName + '</td><td>'
      + new Date(birthDate) + '</td><td>'
      + primarySkill + '</td><td>'
      + level + '</td><td>'
      + manager + '</td></tr>';
}


function handleEmployeeSearchAutocompleteSelect(event, ui) {
	$( "#lastNameAutoComplete" ).val( ui.item.lastName );
	
	var updateEmplForm = $("#updateEmpFormID");
	$("#firstName", updateEmplForm).val(ui.item.firstName);
	$("#lastName", updateEmplForm).val(ui.item.lastName);
	$("#eID", updateEmplForm).val(ui.item.id);
	$("#birthDate", updateEmplForm).val(new Date(ui.item.birthDate));
	$("#level", updateEmplForm).val(ui.item.level);
	$("#primarySkill", updateEmplForm).val(ui.item.primarySkill);
	$("#manager", updateEmplForm).val(ui.item.manager);
	
	updateEmplForm.show();
    console.log(ui.item);
}

function handleEmployeeSearchAutocompleteFocus(event, ui) {
	$( "#lastNameAutoComplete" ).val( ui.item.lastName );
    $("#updateEmpFormID").hide();
}

