<%-- 
    Document   : mostrarUsuarios
    Created on : 12 dic. 2025, 20:11:19
    Author     : gonza
--%>

<%@page import="logica.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Usuarios</h1>
        
        <% List <Usuario> listaUsuario = (List) request.getSession().getAttribute("listausuarios");
            int cont = 1;
            for (Usuario usu : listaUsuario) {
            %>
            
            <p><b>Usuario N°<%=cont%></b></p>
            
            <p>DNI: <%= usu.getDni() %></p>
            <p>Nombre: <%= usu.getNombre() %></p>
            <p>Apellido: <%= usu.getApellido()%></p>
            <p>Telefono: <%= usu.getTelefono()%></p>
            <<p>--------------------------------------------</p>
            <%cont+=1;%>
            
            
        <%}%>
    </body>
</html>
