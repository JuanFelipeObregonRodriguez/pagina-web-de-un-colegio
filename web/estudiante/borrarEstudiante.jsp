<%-- 
    Document   : borrarEstudiante
    Created on : 8/06/2020, 01:12:29 PM
    Author     : roger
--%>

<%@page import="modelo.EstudianteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% int estudiante_id = Integer.parseInt(request.getParameter("Estudiante_id"));
    EstudianteDAO estudiante = new EstudianteDAO();
estudiante.delete(estudiante_id);
%>
