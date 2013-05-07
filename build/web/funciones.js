
function mostrarInformacion(id, direccion) {
    
    window.location.href = "ControladorServlet?solicitud=infoTaxi&id=" + id + "&direccion=" + direccion;
}
function hover(id) {
    alert("(hover) Mi id es: " + id);
}
function obtenerTaxis(){
    window.location.href = "ControladorServlet?solicitud=obtenerTaxis";
}

function generarMapa(dir) {
    var geocoder;
    var map;
    geocoder = new google.maps.Geocoder();
    var latlng = new google.maps.LatLng(40.41049, -3.707199);
    var mapOptions = {
        zoom: 15,
        center: latlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
    var address = dir;
    geocoder.geocode({'address': address}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location
            });

        } else {
            alert("Geocode was not successful for the following reason: " + status);
        }
    });
}