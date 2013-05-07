<%-- 
    Document   : mensaje
    Created on : May 4, 2013, 2:52:29 PM
    Author     : andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" import="java.util.*, modelo.accesodatos.Taxi, modelo.accesodatos.Solicitud" %>
<%
    //Taxi taxi = (Taxi) request.getAttribute("taxi");
    Solicitud solicitud = (Solicitud) request.getAttribute("solicitud");
    String nombreCliente = solicitud.getNombreCliente();
    String destino = solicitud.getDireccionDestino();
    String telefono = solicitud.getTelefono();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enviar Mensaje</title>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="funciones.js"></script>
        <script type="text/javascript"
        src="http://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyDhFJI3JhFGCKkzw_96TcyyUXqMvkfDDmA&sensor=false"></script>
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
    </head>
    <body onload="generarMapa('<%= destino%>')">
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
        <div id="mensaje">
            <h1>Cliente: <%=nombreCliente%></h1>
            <h1>Tel&eacute;fono: <%=telefono%></h1>
            <h1>Destino: <%=destino%></h1>

            <form action="ControladorServlet">
                <input type="submit" onclick="alert('Envio el mensaje');" name="solicitud" value="enviarMensaje"/>
            </form>
        </div>
        <div id="map_canvas">
        </div>
    </body>
</html>
