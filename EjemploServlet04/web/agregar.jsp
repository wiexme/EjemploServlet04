<%-- 
    Document   : agregar
    Created on : 22/06/2015, 02:22:18 PM
    Author     : WIEXME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
        <a href="<%=request.getContextPath()%>"><h1>Agregar Persona</h1></a>
        <form action="crud" method="post"> 
            <input type="hidden" name="action" value="insertar">
            <table>
                <tr>
                    <td><label>ID</label></td>
                    <td><input type="text" name="idpersona" value=""></td>
                </tr>
                <tr>
                    <td><label>Nombre</label></td>
                    <td><input type="text" name="nombre" value=""></td>
                </tr>
                <tr>
                    <td><label>Apellido Paterno</label></td>
                    <td><input type="text" name="apellido_pat" value=""></td>
                </tr>
                <tr>
                    <td><label>Apellido Materno</label></td>
                    <td><input type="text" name="apellido_mat" value=""></td>
                </tr>
                <tr>
                    <td><label>DNI</label></td>
                    <td><input type="text" name="dni" value=""></td>
                </tr>
                <tr>
                    <td colspan="2" align ="center"><input type="submit" value="Guardar"></td>
                </tr>
            </table>
        </form>
        <%
            //out.print(mensaje);
        %>
        ${mensaje}<%//Una forma de imprimir con el símbolito dolar%>
    </body>
</html>
