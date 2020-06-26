<%-- 
    Document   : actualizarEstudiante
    Created on : 8/06/2020, 01:28:59 PM
    Author     : roger
--%>

<%@page import="modelo.Estudiante"%>
<%@page import="modelo.EstudianteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <% int estudiante_id = Integer.parseInt(request.getParameter("Estudiante_id"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String direccion = request.getParameter("direccion");
            String telefono = request.getParameter("telefono");
            EstudianteDAO estudiante = new EstudianteDAO();
            Estudiante est = estudiante.readEstudiante(estudiante_id);
        %>

        <form action="modificarEstudiante.jsp" method="POST">

            <div class="form-group">
                <label for="exampleInputEmail1">Id</label>
                <input type="text" value="<%=est.getEstudiante_id()%>" hidden="true" class="form-control" id="id" name="id" >
            </div>

            <div class="form-group">
                <label for="exampleInputEmail1">Nombre</label>
                <input type="text" value="<%=est.getNombre()%>" class="form-control" id="nombre" name="nombre" >
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Apellido</label>
                <input type="text" value="<%=est.getApellido()%>"class="form-control" id="apellido" name="apellido">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Dirección</label>
                <input type="text" value="<%=est.getDireccion()%>"class="form-control" id="direccion" name="direccion">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Telefono</label>
                <input type="text" value="<%=est.getTelefono()%>"class="form-control" id="telefono" name="telefono">
            </div>
            <button type="submit" class="btn btn-primary">Realizar Cambios</button>
        </form>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

    </body>
</html>

