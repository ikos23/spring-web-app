/*
 * This function can be used to send pre-configured POST AJAX request
 * to the backend and handle the results. This function send data
 * in JSON to the server and expects the server to reply with JSON.
 * 
 * @param  serviceURL      - service to be called.
 * @param  reqData         - data to be sent with AJAX (JS Object).
 * @param  successHandler  - callback to process successful results.
 * @param  errorHandler    - callback to process errors returned in response.
 * @param  ajaxFailHandler - callback to handle AJAX failure. Function will be take 3 params
 *                           xhr, status, errorThrown.
 * 
 */
function callPOSTService(serviceURL, reqData, successHandler, errorHandler, ajaxFailHandler) {
  $.ajax({
    url : serviceURL,
    method : 'POST',
	data : JSON.stringify(reqData),
	contentType: "application/json; charset=utf-8",
	dataType: "json",
	beforeSend: function(xhr) {
	  xhr.setRequestHeader("Accept", "application/json");
      xhr.setRequestHeader("Content-Type", "application/json");
    },
    success : function(data) {
      if (typeof data.httpStatusCode == 'undefined') {
    	  alert('callPOSTService function can not be used to call '
    			  + serviceURL + ' :(');
      }	
      if (data.httpStatusCode == 200) {
        successHandler(data);
	  } else {
		errorHandler(data);    
	  }
    },
	fail : function( xhr, status, errorThrown ) {
	    console.log( "Error: " + errorThrown );
	    console.log( "Status: " + status );
		console.dir( xhr );
		if (typeof ajaxFailHandler != 'undefined') {
		  ajaxFailHandler(xhr, status, errorThrown);
		}
	  }
    });	
}

/*
 * This function can be used to send pre-configured GET AJAX request
 * to the backend and handle the results. This function 
 * expects the server to reply with JSON.
 * 
 * @param  serviceURL      - service to be called.
 * @param  successHandler  - callback to process successful results.
 * @param  ajaxFailHandler - callback to handle AJAX failure. Function will be take 3 params
 *                           xhr, status, errorThrown.
 */
function callGETService(serviceURL, successHandler, ajaxFailHandler) {
  $.get(serviceURL, {})
    .done(function (data) {
      successHandler(data);
	})
	.fail(function( xhr, status, errorThrown ) {
	  console.log( "Error: " + errorThrown );
	  console.log( "Status: " + status );
	  console.dir( xhr );
	  ajaxFailHandler(xhr, status, errorThrown);
	});	
}

function callDELETEService(serviceURL, successHandler, ajaxFailHandler) {
  $.ajax({
    url : serviceURL,
    method : 'DELETE',
	contentType: "application/json; charset=utf-8",
	dataType: "json",
	beforeSend: function(xhr) {
	  xhr.setRequestHeader("Accept", "application/json");
      xhr.setRequestHeader("Content-Type", "application/json");
    },
    success : function(data) {
      successHandler(data);
    },
	fail : function( xhr, status, errorThrown ) {
	  console.log( "Error: " + errorThrown );
	  console.log( "Status: " + status );
	  console.dir( xhr );
	  if (typeof ajaxFailHandler != 'undefined') {
	    ajaxFailHandler(xhr, status, errorThrown);
	  }
	}
  });		
}