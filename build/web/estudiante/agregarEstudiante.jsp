<%-- 
    Document   : agregarEstudiante
    Created on : 7/06/2020, 02:57:04 PM
    Author     : roger
--%>

<%@page import="modelo.Estudiante"%>
<%@page import="modelo.EstudianteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String direccion = request.getParameter("direccion");
    String telefono = request.getParameter("telefono");

EstudianteDAO estudiante = new EstudianteDAO();
estudiante.create(new Estudiante(0, nombre, apellido, direccion, telefono));
%>


