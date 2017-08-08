/*
	Method return the length of a field.
*/
function getLength(value){
	return value.length;
}

/*
	Method returns the value of a specific id.
*/
function getValue(id){
	return document.getElementById(id).value;
}

/*
	Method changes the border for a specific div id.
*/
function changeBorder(id, Bordertype){
	document.getElementById(id).style.border = Bordertype;
}

/*
	Method changes the content of a specific div id.
*/
function setInnerHTML(id, content){
	document.getElementById(id).innerHTML = content;
}

/*
	Method sets the value of a field.
*/
function setValue(id,value){
	document.getElementById(id).value = value;
}

/*
	Method changes the display type of a specific div.
*/
function changeStyle(id,styleType){
	document.getElementById(id).style.display = styleType;
}

/*
	Method checks for the right username Format
	Format : username must be less than 20 chars.
*/
function checkUsername(id){
	if (id === "username") {
		var nameLength = getLength(getValue(id));
		if(nameLength > 20){
			changeBorder(id, "1px solid red");
			changeStyle("name-warning", "inline-block");
			setInnerHTML("name-warning", "Name length must be less than 20 chars.");
		}
	}
}

/*
	Method checks for the right email format
*/
function checkEmail(id){
	if (id === "useremail") {
		var atPos = getValue(id).indexOf("@");
		var dotPos = getValue(id).lastIndexOf(".");

		if (atPos < 1 || dotPos < atPos + 2 || dotPos + 2 >= getLength(getValue(id))) {
			changeStyle("email-warning", "inline-block");
			setInnerHTML("email-warning", "Please enter a valid email.");
			changeBorder(id, "1px solid red");
		} else {
			changeStyle("email-warning", "none");
			changeBorder(id, "1px solid #a9a9a9");
		}
	}
}

/*
	Method checks for the user city
	Format : city must be selected.
*/
function checkUserCity(id) {
	if (id === "usercity" && getValue(id) != "") {
		changeStyle("city-warning", "none");
		setValue('citymsg', "You have selected city : " + getValue(id));
	} else if (id === "usercity" && getValue(id) == "") {
		changeStyle("city-warning", "inline-block");
		setInnerHTML("city-warning", "Please choose a city");
		setValue('citymsg',"");
	}
}

/*
	Method checks for the user organisation format.
	Format : user organisation must only have chars.
*/
function checkUserOrganisation(id) {
	if (id === "userorg" && (getValue(id).match(/\d+/g) != null || getValue(id).match(/[ !@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/) != null)) {
		changeStyle("org-warning", "inline-block");
		setInnerHTML("org-warning", "Organisation must contain only chars.");
	} else {
		changeStyle("org-warning", "none");
	}
}

/*
	Method checks for the user phone number format.
	Format : Phone number must be start from 7/8/9 and then followed by 9 numbers.
*/
function checkUserPhone(id) {
	if (id === "userphone" && getValue(id).length) {
		var pattern = /^[789]\d{9}$/
			if (pattern.test(getValue(id))) {
				changeBorder(id, "1px solid #a9a9a9");
				changeStyle("contact-warning", "none");
			} else {
				changeBorder(id, "1px solid red");
				changeStyle("contact-warning", "inline-block");
				setInnerHTML("contact-warning", "Please Enter a valid Number.");
			}
	}
}

/*
	Method checks for the user message format.
	Format : message must have length less than 250 chars.
*/
function checkUserMessage(id) {
	if (id === "usermessage") {
		messageLength = getLength(getValue(id));
		if (messageLength > 250) {
			changeStyle("message-warning", "inline-block");
			setInnerHTML("message-warning", "Message length should be less than 250 chars.");
		} else {
			changeStyle("message-warning", "none");
		}
	}
}

/*
	Method calls all the validator methods
*/
function validateOnKeyPress(id, e) {
	checkUsername(id); // checks username for right format
	checkEmail(id);		// checks user email for right format
	checkUserCity(id);	// checks user city 
	checkUserOrganisation(id);	// checks user organisation 
	checkUserPhone(id);	// checks user phone number
	checkUserMessage(id);	// checks user message
}