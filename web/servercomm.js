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
    http.onreadystatechange = serverCallback;
    http.send(null);
    document.getElementById("comm_input").value = "";
}

function serverCallback() {
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
        var tst = responseXML.getElementsByTagName("p");
        if(tst!=null){
           tst = tst[0]; 
            if(tst!=null){
                tst = tst.firstChild;
                if(tst!=null){
                    tst = tst.nodeValue;
                }
            }
        }
        alert(tst);
        return true;
    }
}


