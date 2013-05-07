<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Solicitud</title>
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
    </head>
    <body>
        <div id="encabezado">
            <h1>Despacho de Taxis</h1>
            <div id="enlaces">
                <ul>
                    <li><a href="index.jsp">Inicio</a></li>
                    <li> | </li>
                    <li><a href="#">Crear Solicitud</a></li>
                </ul>
            </div>
        </div>
        <div id="forma">
            <form action="ControladorServlet">
                Nombre: <input type="text" name="Nombre" value="" /><br />
                Destino: <input type="text" name="Direccion" value="" /><br />
                Telefono: <input type="text" name="Telefono" value="" /><br />
                <input type="submit" value="crearSolicitud" name="solicitud"/>
            </form>
        </div>
    </body>
</html>
