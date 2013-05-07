<%-- 
    Document   : taxiOptimo
    Created on : May 4, 2013, 11:00:18 AM
    Author     : andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" import="java.util.*, modelo.accesodatos.Taxi, modelo.accesodatos.Solicitud" %>
<%
    Taxi taxi = (Taxi) request.getAttribute("taxi");
    Solicitud solicitud = (Solicitud) request.getAttribute("solicitud");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Taxi &Oacute;ptimo</title>
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
        <script type="text/javascript"
                src="http://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyDhFJI3JhFGCKkzw_96TcyyUXqMvkfDDmA&sensor=false">
        </script>
        <script src="funciones.js"></script>
    </head>
    <body onload="generarMapa('<%=taxi.getUbicacion()%>')">
        <div id="encabezado">
            <h1>Despacho de Taxis</h1>
            <div id="enlaces">
                <ul>
                    <li><a href="index.jsp">Inicio</a></li>
                </ul>
            </div>
        </div>

        <form action="ControladorServlet">
            <input type="hidden" name="nombreCliente" value="<%=solicitud.getNombreCliente()%>"/>
            <input type="hidden" name="destino" value="<%=solicitud.getDireccionDestino()%>"/>
            <input type="hidden" name="telefono" value="<%=solicitud.getTelefono()%>"/>
            <input type="hidden" name="solicitud" value="mostrarMensaje">
        </form>

        <div id="taxiOptimo">
            <h1>Taxi &Oacute;ptimo</h1>
            <h1><a onclick="document.forms[0].submit();" style="color:black; text-decoration: underline;">N&uacute;mero bastidor: <%=taxi.getNumBastidor()%></a></h1>
            <h1>Ubicaci&oacute;n Actual: <%=taxi.getUbicacion()%></h1>
        </div>

        <div id="map_canvas">
        </div>
    </body>
</html>
