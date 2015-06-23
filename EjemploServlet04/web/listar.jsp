<%-- 
    Document   : listar
    Created on : 22/06/2015, 02:22:29 PM
    Author     : WIEXME
--%>

<%@page import="java.util.List"%>
<%@page import="eje04.modelo.entidad.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="listaPersona" scope="request" class="java.util.List" />
        <a href="<%=request.getContextPath()%>"><h1>Listar Persona</h1></a><br>
        <jsp:useBean id="mensaje" scope="request" class="java.lang.String" />
        <form action="listar" method="post">
            <table>
                <thead>
                <tr>
                    <th>#</th>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido Paterno</th>
                    <th>Apellido Materno</th>
                    <th>DNI</th>
                    <th>Opción</th>
                </tr>
                </thead>
                <tbody>
                <%
                    int count = 0;
                    List<Persona> lista = listaPersona;
                    for(Persona persona: lista){
                    count++;
                %>    
                <tr>
                    <td><%=count%></td>
                    <td><%=persona.getIdpersona()%></td>
                    <td><%=persona.getNombre()%></td>
                    <td><%=persona.getApellidoPat()%></td>
                    <td><%=persona.getApellidoMat()%></td>
                    <td><%= persona.getDni()%></td>
                    <td>[<a href="crud?action=actualizar&idpersona=<%=persona.getIdpersona()%>">Actualizar</a>][<a href="crud?action=eliminar&idpersona=<%=persona.getIdpersona()%>">Eliminar</a>]</td>
                </tr>
                <%}%>
                
                </tbody>
            </table>
        </form>
                ${mensaje}
    </body>
</html>
