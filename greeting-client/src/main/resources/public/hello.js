$(document).ready(function() {
	$.ajax({
		url : "http://localhost:8080/greeting"
	}).then(function(data, status, jqxhr) {
		$('.greeting-id').append(data.id);
		$('.greeting-content').append(data.content);
		console.log("status : " + status);
	});
});

/*
 * This script uses jQuery to consume the REST service at
 * http://localhost:8080/greeting. It is loaded by index.html
 */

/*
 * The ajax() method is used to perform an AJAX (asynchronous HTTP) request.
 * Syntax: $.ajax({name:value, name:value, ... }) The parameters specifies one
 * or more name/value pairs for the AJAX request. Possible names/values are :
 * -url : Specifies the URL to send the request to. Default is the current page,
 * -type : Specifies the type of request. (GET or POST), Default is GET -xhr : A
 * function used for creating the XMLHttpRequest object
 */

/*
 * The service will handle GET requests for /greeting, optionally with a name
 * parameter in the query string. The GET request should return a 200 OK
 * response with JSON in the body that represents a greeting. The id field is a
 * unique identifier for the greeting, and content is the textual representation
 * of the greeting.
 * 
 */