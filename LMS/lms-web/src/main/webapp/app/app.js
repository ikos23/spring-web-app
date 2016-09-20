(function () {
	
	angular.module("LmsApp", ['ngRoute']);
	
})();


//(function () {
//	var xhttp;
//	if (window.XMLHttpRequest) {
//	    xhttp = new XMLHttpRequest();
//	    } else {
//	    // code for IE6, IE5
//	    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
//	}
//	
//	xhttp.onreadystatechange = function() {
//        if (this.readyState == 4 && this.status == 200) {
//            var empl = JSON.parse(this.responseText);
//            var text = "<ul>";
//            for (i = 0; i < empl.length; i++) {
//                text += ("<li>" + empl[i].firstName + " " 
//                	+ empl[i].lastName + " : " 
//                		+ empl[i].primarySkill + "</li>");
//            }
//            text += "</ul>";
//            document.getElementById("demo").innerHTML = text;
//        }
//    };
//	
//	
//	xhttp.open("GET", "/lms-web/employees/json", true);
//	xhttp.send();
//	
//})();