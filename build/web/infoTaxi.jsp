
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    String idTaxi = (String)request.getParameter("id");
    String direccion = (String)request.getParameter("direccion");
%>

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Informaci&oacute;n Taxi</title>
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
        <script type="text/javascript"
                src="http://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyDhFJI3JhFGCKkzw_96TcyyUXqMvkfDDmA&sensor=false">
        </script>
        <script src="funciones.js"></script>
    </head>
    <body onload="generarMapa('<%= direccion %>')">
        <div id="encabezado">
            <h1>Despacho de Taxis</h1>
            <div id="enlaces">
                <ul>
                    <li><a href="index.jsp">Inicio</a></li>
                    <li> | </li>
                    <li><a href="generarSolicitud.jsp">Crear Solicitud</a></li>
                </ul>
            </div>
        </div>
        <div id="infotaxi">
            <h1>Taxi: <%= idTaxi%></h1>
            <h1>Estado: Libre</h1>
            <h1>Ubicación Actual: <%= direccion%></h1>
        </div>
        <div id="map_canvas">
        </div>
    </body>
</html>
