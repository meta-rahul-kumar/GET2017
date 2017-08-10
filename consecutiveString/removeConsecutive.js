/*
	Function removes the consecutive Sub-string from a string
*/
function removeConsecutive(string) {
	var isConsecutive = false;
	var marker = 0;
	for (var i=0; i< string.length; i++) {
		if (string.charAt(i) == string.charAt(i+1)) {
			marker++;
		} else if(marker > 0) {
			string = string.substr(0, i-marker) + string.substr(i+1, string.length); // remove consecutive string and make new string
			isConsecutive = true;
			return removeConsecutive(string);  // recursive calling
		}
	}

	if (!isConsecutive) { // exit condition of Recursion
		return string;
	}
}