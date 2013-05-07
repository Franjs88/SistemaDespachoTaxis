<%@page import="modelo.logicanegocio.InfoTaxi"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.accesodatos.Taxi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    List<Integer> taxis = (List<Integer>) request.getAttribute("taxis");
    //ArrayList<InfoTaxi> listaInfoTaxis = (ArrayList<InfoTaxi>)request.getAttribute("infoTaxis");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SDT</title>
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="funciones.js"></script>
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
        
    </head>
    <body>
        <div id="encabezado">
            <h1>Despacho de Taxis</h1>
            <div id="enlaces">
                <ul>
                    <li><a href="generarSolicitud.jsp">Crear Solicitud</a></li>
                </ul>
            </div>
        </div>
        <div id="listataxis">
            <table border="1px">
                <tr>
                    <th>Imagen</th>
                    <th>ID</th>
                </tr>
                <%
                    for (int i = 0; i < taxis.size(); i++) {
                %>
                <tr id="<%=taxis.get(i)%>" onclick="mostrarInformacion(this.id, 'Avenida de Oporto 5, Madrid');">
                    <td><img src="http://static6.depositphotos.com/1070259/561/v/950/depositphotos_5613932-Button-taxi.jpg" height="150px" width="150px"/></td>
                    <td><%=taxis.get(i)%></td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
