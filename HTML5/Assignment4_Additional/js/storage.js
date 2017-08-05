var score = 0 ;
var run = 0;
var congrats = 0;

function check() {
	localStorage.removeItem("login");
	document.getElementById("cricket-scorecard-body").innerHTML = 0;

	if (localStorage.getItem("login") === null) {
		document.getElementById("remove").style.display="none";
		document.getElementById("err-msg").style.display="none";
		document.getElementById("cricket-counter").style.display="none";
		document.getElementById("cricket-scorecard").style.display="none";
	}

	if (localStorage.getItem("HighUserName") === null) {
		var newS = "No One Played Yet!!";
		localStorage.setItem("HighUserName", newS);
	}

	if (localStorage.getItem("HighScore") === null) {
		var newS = 0;
		localStorage.setItem("HighScore", newS);
	}

	document.getElementById("err-msg").style.display="none";
	document.getElementById("ball-to-ball").style.display="none";
	document.getElementById("cricket-ball-head").style.display="none";
	document.getElementById("notification").style.display="none";
	highScore();
}

function highScore() {
	document.getElementById("high-user").innerHTML = localStorage.getItem("HighUserName");
	document.getElementById("cricket-highscore-body").innerHTML = localStorage.getItem("HighScore");
}

function saveStore() {
	var text = document.getElementById("textbox");

	if (text.value === "") {
		document.getElementById("err-msg").style.display="block";
		document.getElementById("err-msg").innerHTML = "Name field can't be empty !!";
	} else {
		localStorage.setItem("login", text.value);
		text.value = "";
		document.getElementById("remove").style.display="inline-block";
		document.getElementById("err-msg").style.display="none";
		document.getElementById("save").style.display="none";
		document.getElementById("textbox").style.display="none";
		document.getElementById("msg").innerHTML = "Hello "+ localStorage.getItem("login") + " !!";
		document.getElementById("cricket-counter").style.display="block";
		document.getElementById("cricket-scorecard").style.display="block";
		document.getElementById("cricket-highscore").style.display="none";
		document.getElementById("ball-to-ball").style.display="block";
		document.getElementById("cricket-ball-head").style.display="block";
		play();
	}
}

function removeLogin() {
	if (localStorage.getItem("login") != null) {
		localStorage.removeItem("login");
		document.getElementById("remove").style.display="none";
		var msg = document.getElementById("msg");
		document.getElementById("cricket-counter").style.display="none";
		document.getElementById("cricket-scorecard").style.display="none";
		document.getElementById("save").style.display="block";
		document.getElementById("textbox").style.display="block";
		document.getElementById("cricket-scorecard-body").innerHTML = "0";
		document.getElementById("cricket-highscore").style.display="block";
		document.getElementById("ball-to-ball").style.display="none";
		document.getElementById("ball-to-ball").innerHTML = "";
		document.getElementById("cricket-ball-head").style.display="none";
		document.getElementById("notification").style.display="none";
		score = 0;
		msg.innerHTML = "Hello Guest !!";
	}
}

function play() {
	var counter = 0;

	run = setInterval(function(){ 
		document.getElementById("cricket-counter-body").innerHTML = counter;
		counter += 2;
		if (counter == 10) {
			counter = 0;
		}
	 }, 200);
}

function getHit() {
	if ( parseInt(document.getElementById("cricket-counter-body").innerHTML) == 8 ) {
		score += 1;
	} else if(parseInt(document.getElementById("cricket-counter-body").innerHTML) == 0 ) {
		clearInterval(run);
		document.getElementById("notification").style.display = "block";
		document.getElementById("notification").innerHTML = "You are Out !!";
		if (score > parseInt(localStorage.getItem("HighScore"))) {
			localStorage.setItem("HighScore", score);
			localStorage.setItem("HighUserName", localStorage.getItem("login"));
			highScore();
		}
	} else {
		score += parseInt(document.getElementById("cricket-counter-body").innerHTML);
	}

	document.getElementById("cricket-scorecard-body").innerHTML = score;

	if (parseInt(document.getElementById("cricket-counter-body").innerHTML) != 0 && parseInt(document.getElementById("cricket-counter-body").innerHTML) != 8) {
		document.getElementById("ball-to-ball").innerHTML += " " +parseInt(document.getElementById("cricket-counter-body").innerHTML);
	} else if (parseInt(document.getElementById("cricket-counter-body").innerHTML) == 8) {
		document.getElementById("ball-to-ball").innerHTML += " <font color='red'>NB</font>";
	}

	if (score % 100 == 0 && score > 0) {
		document.getElementById("notification").style.display = "block";
		document.getElementById("notification").innerHTML = "Congrats on century !! You are Pro of Cricket.";
		
	} else if(score % 50 == 0 && score > 0) {
		document.getElementById("notification").style.display = "block";
		document.getElementById("notification").innerHTML = "Congrats on half century !! You are master of Cricket.";
	}

}

function hideFunction() {
	document.getElementById("notification").style.display = "none";
	clearInterval(congrats);
}
