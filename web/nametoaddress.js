
function sendName(map){
    var str = document.getElementById("name_input").value;
    document.getElementById("name_input").value = "";
    return nameToAddress(str, map);
}

function nameToAddress(name, map){
    var request = {
        query: name
    };
    var service = new google.maps.places.PlacesService(map);
    service.textSearch(request, locationsCallback);
}

function locationsCallback(results, status){
    if(status == google.maps.places.PlacesServiceStatus.OK){
        alert(JSON.stringify(results[0]));
    } else {
        alert("No results were found!");
    }
}
