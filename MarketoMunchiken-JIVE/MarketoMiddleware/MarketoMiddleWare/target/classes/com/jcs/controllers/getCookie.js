<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

<script>
	
	//Function to read value of a cookie
	function readCookie(name) {
	    var cookiename = name + "=";
	    var ca = document.cookie.split(';');
	    for(var i=0;i < ca.length;i++) {
	        var c = ca[i];
	        while (c.charAt(0)==' ') c = c.substring(1,c.length);
	        if (c.indexOf(cookiename) == 0) return c.substring(cookiename.length,c.length);
	    }
	    return null;
	}
	
	
	$(document).ready(function() {
	
		//Call readCookie function to get value of user's Marketo cookie
	
		var value = readCookie('_mkto_trk');
	
		console.log(value);
		
		var request_url = "https://652f7991.ngrok.io/MarketoMiddleWare/api/jive/cookie";
		
		var jsonData ={
				"cookie": {
					"cookieId": "id of the cookie here ",
					"jiveUserId": "user ID"
					}
					};

	
						
		$.ajax({
	        type:"POST",
	        contentType:"application/json",
	        url : request_url,
	        data : JSON.stringify(jsonData),
	    
	        complete: function(data) {
	    
				console.log("Posted " + jsonData);
				
	    
	        }
	    });
	    

         // to get JIve user ID

      console.log(window.parent._jive_current_user.ID);
		
	});



</script>
