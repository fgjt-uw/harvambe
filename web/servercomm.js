var http;

function init(){
}

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
        var tst = responseXML.getElementsByTagName("p")[0];
        alert(tst.childNodes[0].nodeValue);
        return true;
    }
}


