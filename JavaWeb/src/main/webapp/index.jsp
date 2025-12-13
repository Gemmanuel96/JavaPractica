<%-- 
    Document   : index
    Created on : 12 dic. 2025, 20:05:14
    Author     : gonza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Principal</title>
    </head>
    <body>
        <h1>Ingrese los datos</h1>
        <form action="SvUsuarios" method="POST">
            <p><label >DNI:</label> <input name =" dni"> </p>
            <p><label >Nombre:</label> <input name ="nombre"> </p>
            <p><label >Apellido:</label> <input name ="apellido"> </p>
            <p><label >Telefono:</label> <input name ="telefono"> </p>
            
            <button action="submit"> Agregar Usuario </button>
            
        </form>
        
        <h1>Mostrar Lista de Usuarios</h1>
        <form action="SvUsuarios" method="GET">
            <button action ="submit"> Mostrar Usuarios </button>
            
        </form>
    </body>
</html>
