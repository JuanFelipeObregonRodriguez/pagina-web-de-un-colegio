<%-- 
    Document   : modificarEstudiante
    Created on : 8/06/2020, 01:54:25 PM
    Author     : roger
--%>

<%@page import="modelo.Estudiante"%>
<%@page import="modelo.EstudianteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% int id = Integer.parseInt(request.getParameter("Estudiante_id"));
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String direccion = request.getParameter("direccion");
    String telefono = request.getParameter("telefono");
    
    EstudianteDAO estudiante = new EstudianteDAO();
    estudiante.update(new Estudiante(id, nombre, apellido, direccion, telefono));
%>

