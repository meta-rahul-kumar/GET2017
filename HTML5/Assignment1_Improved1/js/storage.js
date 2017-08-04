function check(){
	document.getElementById("err-msg").style.display="none";

	if(localStorage.getItem("instruction") != null){
		document.getElementById("Instruction-layer").style.display="none";
	}
	document.getElementById("err-msg").style.display="none";
}
function getStore(){
	var text = document.getElementById("textbox");
	text.value = localStorage.getItem("login");
	var errmsg = document.getElementById("err-msg");
	if (localStorage.getItem("login") == null){
		errmsg.innerHTML = "Please Enter Login Email and Password";
	}else{
		errmsg.innerHTML = "Please Enter Login Password";
	}
	errmsg.style.display = "block";
}
function saveStore(){
	var text = document.getElementById("textbox");
	var pass = document.getElementById("password");
	var atpos = text.value.indexOf("@");
	var dotpos = text.value.lastIndexOf(".");

	if(text.value == localStorage.getItem('login') && pass.value == localStorage.getItem('pass')){
		var msg = document.getElementById("msg");
		msg.innerHTML = "Hello "+ localStorage.getItem("login") + " !!";
	}else if(text.value == localStorage.getItem('login') && pass.value != localStorage.getItem('pass')){
		var errmsg = document.getElementById("err-msg");
		errmsg.innerHTML = "Password Wrong !!";
	}else{
		if (atpos<1 || dotpos<atpos+2 || dotpos+2>=text.value.length) {
    	document.getElementById("err-msg").style.display="block";
		document.getElementById("err-msg").innerHTML = "Please enter a valid email !!";
		}else if(text.value === ""){
			document.getElementById("err-msg").style.display="block";
			document.getElementById("err-msg").innerHTML = "Login field can't be empty !!";
		}else{
			localStorage.setItem("login", text.value);
			localStorage.setItem("pass", pass.value);
			text.value = "";
			pass.value = "";
			document.getElementById("get").style.display="inline-block";
			document.getElementById("remove").style.display="inline-block";
			document.getElementById("err-msg").style.display="none";
		}
	}
}

function removeLogin(){
	if(localStorage.getItem("login") != null){
		localStorage.removeItem("login");
		localStorage.removeItem("pass");
		document.getElementById("get").style.display="none";
		document.getElementById("remove").style.display="none";
		var msg = document.getElementById("msg");
		msg.innerHTML = "Hello Guest !!";
	}
}

function gotInstruction(){
	localStorage.setItem("instruction","1");
	document.getElementById("Instruction-layer").style.display="none";
}
