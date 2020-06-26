<%-- 
    Document   : mostrarEstudiantes
    Created on : 7/06/2020, 02:22:12 PM
    Author     : roger
--%>

<%@page import="modelo.Estudiante"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.EstudianteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">Id_Estudiante</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Dirección</th>
                    <th scope="col">Telefono</th>
                    <th scope="col">Opereciones</th>
                </tr>
            </thead>
            <tbody>
                <% EstudianteDAO estudiante = new EstudianteDAO();
                    ArrayList<Estudiante> estudiantes = new ArrayList();
                    estudiantes = estudiante.read();
                for (Estudiante aux:estudiantes) {%>
                <tr>
                    <th scope="row"><%=aux.getEstudiante_id()%></th>
                    <td><%=aux.getNombre()%></td>
                    <td><%=aux.getApellido()%></td>
                    <td><%=aux.getDireccion()%></td>
                    <td><%=aux.getTelefono()%></td>
                    <td><a class="btn btn-primary" href="borrarEstudiante.jsp?Estudiante_id=<%=aux.getEstudiante_id()%>" role="button">Eliminar</a></td>
                    <td><a class="btn btn-primary" href="actualizarEstudiante.jsp?Estudiante_id=<%=aux.getEstudiante_id()%>" role="button">Actualizar</a></td>
                </tr>

                <%}%>
            </tbody>
        </table>
     <a class="btn btn-primary" href="agregarEstudiante.jsp" role="button">Agregar</a>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    </body>
</html>
