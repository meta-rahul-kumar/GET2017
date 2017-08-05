function check() {
	document.getElementById("err-msg").style.display = "none";
	document.getElementById("blurness-exisiting").style.display = "none";
}

function selectLogin(id) {
	var text = document.getElementById("textbox");
	var pass = document.getElementById("password");
	var errmsg = document.getElementById("err-msg");

	text.value = id.id;

	errmsg.innerHTML = "<img src='images/warning.png' class='old-usr-img' /> Please Enter Login Password";
	errmsg.style.display = "block";
	document.getElementById("old-logins").style.display = "none";
	backToMain();
}

function deleteLogin(id) {
	var i = 0;
	var data = JSON.parse(localStorage.getItem("logins")).logins;
	var hold_data = JSON.parse(localStorage.getItem("logins")).logins;

	for (i in data)
	{
	     if (data[i].email == id.id){
	     	break;
	     }
	}

	data.splice(i, 1);   // remove one JSON array Element on position i
	var newObj = {"logins"  : data}; // creates new object using data JSON array
	var errmsg = document.getElementById("err-msg");
	localStorage.setItem("logins",JSON.stringify(newObj)); 
	alert("Removed login with email "+ id.id);
	location.reload();
}

function backToMain() {
	document.getElementById("blurness-exisiting").style.display = "none";
	document.getElementById("blurness-exisiting").innerHTML = "";
}

function getStore() {
	if ( JSON.parse(localStorage.getItem("logins")) != null ) {
		var text = document.getElementById("textbox");
		var errmsg = document.getElementById("err-msg");
		var data = JSON.parse(localStorage.getItem("logins")).logins;
	
		document.getElementById("blurness-exisiting").style.display = "block";
		document.getElementById("blurness-exisiting").innerHTML = "<div id='old-logins-head'>" + document.getElementById("old-logins-head").innerHTML + " <button class='back-button' onclick='backToMain();'>Back</button></div>";
		document.getElementById("old-logins-head").style.display = "block";
		
		for (var i in data) {
		    var eid = data[i].email;
		    document.getElementById("blurness-exisiting").innerHTML += '<div class="grey" id="'+ eid +'" onclick="selectLogin(this);" ><img class="old-usr-img" src="images/user.png" /> ' + eid +'</div>'; 
		}
	} else {
		alert("There is no Login");
	}

}

function liveCheck() {
	var text = document.getElementById("textbox");
	var pass = document.getElementById("password");
	var flag = 0;

		if (JSON.parse(localStorage.getItem("logins")) != null) {
			var data = JSON.parse(localStorage.getItem("logins")).logins;

			for (var i in data)
			{
			     var eid = data[i].email;
			     var epass = data[i].pass;
			     if (eid == text.value && epass == pass.value) {
			     	flag = 1;
			     	break;
			     }
			}

			if (flag == 1){
				document.getElementById('save').innerHTML = "Login";
			} else {
				document.getElementById('save').innerHTML = "Save and Login";
			}
		}
}

function saveStore() {
	var text = document.getElementById("textbox");
	var pass = document.getElementById("password");
	var atpos = text.value.indexOf("@");
	var dotpos = text.value.lastIndexOf(".");
	var flag = 0;

		if (JSON.parse(localStorage.getItem("logins")) != null) {
			var data = JSON.parse(localStorage.getItem("logins")).logins;

			for (var i in data) {
			     var eid = data[i].email;
			     var epass = data[i].pass;
			     if (eid == text.value && epass == pass.value) {
			     	var msg = document.getElementById("msg");
					msg.innerHTML = "Hello "+ eid + " !!";
			     	flag = 1;
			     	break;
			     } else if (eid == text.value && epass != pass.value) {
			     	document.getElementById("err-msg").style.display="block";
					document.getElementById("err-msg").innerHTML = "<img src='images/warning.png' class='old-usr-img' />  Please check your password !!";
					flag = 1;
			     }

			     if (flag == 1) {
			     	text.value = "";
					 pass.value = "";
			     }
			}
		}

			if (flag != 1) {
				if (atpos<1 || dotpos<atpos+2 || dotpos+2>=text.value.length) {
		    	document.getElementById("err-msg").style.display="block";
				document.getElementById("err-msg").innerHTML = "<img src='images/warning.png' class='old-usr-img' />  Please enter a valid email !!";
				} else if (text.value === "") {
					document.getElementById("err-msg").style.display="block";
					document.getElementById("err-msg").innerHTML = "<img src='images/warning.png' class='old-usr-img' />  Login field can't be empty !!";
				} else if (pass.value === "") {
					document.getElementById("err-msg").style.display="block";
					document.getElementById("err-msg").innerHTML = "<img src='images/warning.png' class='old-usr-img' />  Password field can't be empty !!";
				} else {
					if (JSON.parse(localStorage.getItem("logins")) != null) {
						var login = JSON.parse(localStorage.getItem("logins"));
						login.logins.push({"email": text.value,"pass": pass.value});
					} else {
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

 }

function removeLogin() {
	var data = JSON.parse(localStorage.getItem("logins")).logins;

	document.getElementById("blurness-exisiting").style.display = "block";
	document.getElementById("blurness-exisiting").innerHTML = "<div id='cancel-old-logins-head'>" + document.getElementById("cancel-old-logins-head").innerHTML + "<button class='back-button' onclick='backToMain();'>Back</button> </div>";
	document.getElementById("cancel-old-logins-head").style.display = "block";

	for (var i in data) {
	     var eid = data[i].email;
	 	document.getElementById("blurness-exisiting").innerHTML += '<div class="grey" ><img class="old-usr-img" src="images/user.png"> ' + eid +' <div class="close-box" id="'+ eid +'" onclick="deleteLogin(this);">X</div></div>'; 
	}
}
