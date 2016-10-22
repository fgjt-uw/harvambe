var http;

function initRequest() {
    if (window.XMLHttpRequest) {
        if (navigator.userAgent.indexOf('MSIE') != -1) {
            isIE = true;
        }
        return new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        isIE = true;
        return new ActiveXObject("Microsoft.XMLHTTP");
    }
}

function submitCommand(){
    var command = document.getElementById("comm_input").value;
    if(command == "") return;
    http = initRequest();
    http.open("GET", "ItineraryServlet?action=submit&id=" + escape(command), true);
    http.onreadystatechange = callback;
    http.send(null);
    document.getElementById("comm_input").value = "";
}

function callback() {
    if (http.readyState == 4) {
        if (http.status == 200) {
            parseMessages(http.responseXML);
        }
    }
}

function parseMessages(responseXML){
    if(responseXML == null){
        return false;
    } else {
        var tst = responseXML.getElementsByTagName("p")[0].firstChild.nodeValue;
        alert(tst);
        return true;
    }
}


