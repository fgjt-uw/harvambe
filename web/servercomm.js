var http;

function init(){
    test();
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

function test(){
    http = initRequest();
    http.open("GET", "ItineraryServlet", true);
    http.onreadystatechange = callback;
    http.send(null);
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
        document.getElementById("test").innerHTML = tst.childNodes[0].nodeValue;
        return true;
    }
}


