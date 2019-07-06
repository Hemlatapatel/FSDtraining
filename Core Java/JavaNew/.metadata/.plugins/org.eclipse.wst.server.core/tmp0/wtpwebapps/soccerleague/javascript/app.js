/**
 * 
 */

function validateForm() {
	var x=document.forms['form1']['year'].value;
	var y = document.forms['form1']['season'].value;
	var z = document.forms['form1']['title'].value;

	if(y=='UNKNOWN') {
     alert("Season required");
     return false;
		}

	if(x=="") {
	     alert("year field required");
	     return false;
		}
	if(z=="") {
	     alert("title field required");
	   return false;
		}

}

function onCancel() {
	location.href = "index.html";
}