function check(){
	document.getElementById("err-msg").style.display="none";
	//localStorage.removeItem("logins");
}
function selectLogin(id){
	var text = document.getElementById("textbox");
	var pass = document.getElementById("password");
	var errmsg = document.getElementById("err-msg");
	text.value = id.innerHTML;
	errmsg.innerHTML = "Please Enter Login Password";
	errmsg.style.display = "block";
	document.getElementById("old-logins").style.display = "none";
}

function deleteLogin(id){
	alert(id.id);
	var i = 0;
	var data = JSON.parse(localStorage.getItem("logins")).logins;
	var vata = localStorage.getItem("logins");
	for(i in data)
	{
	     if(data.email == id.id){
	     	break;
	     }
	}
	alert(i);

	data.splice(i, 1);
	var errmsg = document.getElementById("err-msg");
	errmsg.innerHTML = vata;
	localStorage.removeItem("logins");
	localStorage.setItem("logins",JSON.stringify(vata));
}

function getStore(){
	if( JSON.parse(localStorage.getItem("logins")) != null ) {
		var text = document.getElementById("textbox");
		var errmsg = document.getElementById("err-msg");

		var data = JSON.parse(localStorage.getItem("logins")).logins;

		document.getElementById("old-logins").style.display = "block";
		document.getElementById("old-logins").innerHTML = "<div id='old-logins-head'>" + document.getElementById("old-logins-head").innerHTML + "</div>";
		document.getElementById("old-logins-head").style.display = "block";

		for(var i in data)
		{
		     var eid = data[i].email;
		     document.getElementById("old-logins").innerHTML += '<div class="grey" id="'+ eid +'" onclick="selectLogin(this);" >' + eid +'</div>'; 
		}
	}else{
		alert("There is no Login");
	}
	
	//errmsg.innerHTML = localStorage.getItem("logins");
}

function saveStore(){
	var text = document.getElementById("textbox");
	var pass = document.getElementById("password");
	var atpos = text.value.indexOf("@");
	var dotpos = text.value.lastIndexOf(".");
	var flag = 0;

		if(JSON.parse(localStorage.getItem("logins")) != null){
			var data = JSON.parse(localStorage.getItem("logins")).logins;

			for(var i in data)
			{
			     var eid = data[i].email;
			     var epass = data[i].pass;
			     if(eid == text.value && epass == pass.value){
			     	var msg = document.getElementById("msg");
					msg.innerHTML = "Hello "+ localStorage.getItem("login") + " !!";
			     	flag = 1;
			     	break;
			     }
			}

			if(flag != 1){
				if (atpos<1 || dotpos<atpos+2 || dotpos+2>=text.value.length) {
		    	document.getElementById("err-msg").style.display="block";
				document.getElementById("err-msg").innerHTML = "Please enter a valid email !!";
				}else if(text.value === ""){
					document.getElementById("err-msg").style.display="block";
					document.getElementById("err-msg").innerHTML = "Login field can't be empty !!";
				}else{
					if(JSON.parse(localStorage.getItem("logins")) != null){
						var login = JSON.parse(localStorage.getItem("logins"));
						login.logins.push({"email": text.value,"pass": pass.value});
					}else{
						var login = {"logins" : [{"email": text.value,"pass": pass.value}]};
					}
					loginString  = JSON.stringify(login);
					localStorage.setItem("logins", loginString);
					text.value = "";
					pass.value = "";
					document.getElementById("get").style.display="inline-block";
					document.getElementById("remove").style.display="inline-block";
					document.getElementById("err-msg").style.display="none";
				}
			}
		}else{
			if (atpos<1 || dotpos<atpos+2 || dotpos+2>=text.value.length) {
		    	document.getElementById("err-msg").style.display="block";
				document.getElementById("err-msg").innerHTML = "Please enter a valid email !!";
				}else if(text.value === ""){
					document.getElementById("err-msg").style.display="block";
					document.getElementById("err-msg").innerHTML = "Login field can't be empty !!";
				}else{
					var login = {"logins" : [{"email": text.value,"pass": pass.value}]};
					loginString  = JSON.stringify(login);
					localStorage.setItem("logins", loginString);
					text.value = "";
					pass.value = "";
					document.getElementById("get").style.display="inline-block";
					document.getElementById("remove").style.display="inline-block";
					document.getElementById("err-msg").style.display="none";
				}
		}
		// }
 }


function removeLogin(){
	var data = JSON.parse(localStorage.getItem("logins")).logins;

	document.getElementById("cancel-old-logins").style.display = "block";
	document.getElementById("cancel-old-logins").innerHTML = "<div id='cancel-old-logins-head'>" + document.getElementById("cancel-old-logins-head").innerHTML + "</div>";
	document.getElementById("cancel-old-logins-head").style.display = "block";

	for(var i in data)
	{
	     var eid = data[i].email;
	     document.getElementById("cancel-old-logins").innerHTML += '<div class="grey" >' + eid +' <div class="close-box" id="'+ eid +'" onclick="deleteLogin(this);">X</div></div>'; 
	}
}
