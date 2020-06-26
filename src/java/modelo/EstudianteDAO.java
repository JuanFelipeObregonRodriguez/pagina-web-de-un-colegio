/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bdatos.MysqlDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author roger
 */
public class EstudianteDAO {
    
    public void create(Estudiante estudiante){
        
     MysqlDb mysqlDb = new MysqlDb();
     Connection connection = mysqlDb.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO estudiantes VALUES (NULL,?,?,?,?,?)");
            statement.setString(1, estudiante.getNombre());    
            statement.setString(2, estudiante.getApellido());  
            statement.setString(3, estudiante.getDireccion()); 
            statement.setString(4, estudiante.getTelefono());   
               statement.setInt(5, estudiante.getEstudiante_id());
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public ArrayList<Estudiante> read (){
     ArrayList<Estudiante> estudiantes = new ArrayList();
     MysqlDb mysqlDb = new MysqlDb();
     Connection connection = mysqlDb.getConnection();
        try {            
            String sql ="SELECT * FROM estudiantes";
            Statement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery(sql);
            while(resultado.next()){
       estudiantes.add(new Estudiante(resultado.getInt("estudiantes_id"),resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("direccion"),resultado.getString("telefono")));
            }      
            return estudiantes;
            
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
      
    }
    
    public void update(Estudiante estudiante){
      
     MysqlDb mysqlDb = new MysqlDb();
     Connection connection = mysqlDb.getConnection(); 
      try{
       PreparedStatement statement = connection.prepareStatement("UPDATE estudiantes SET  nombre=?,apellido=?,direccion=?, telefono=? WHERE id=?");
            statement.setString(1, estudiante.getNombre());
            statement.setString(2, estudiante.getApellido());  
            statement.setString(3, estudiante.getDireccion()); 
            statement.setString(4, estudiante.getTelefono());
            statement.setInt(5, estudiante.getEstudiante_id());
            connection.close();
       }
       catch(Exception e){
       e.printStackTrace();
       }
    }
    
    public void delete(int estudiante_id){
        
      MysqlDb mysqlDb = new MysqlDb();
     Connection connection = mysqlDb.getConnection(); 
       try{
       PreparedStatement statement = connection.prepareStatement("DELETE * FROM estudiantes WHERE estudiante_id=?");
            statement.setInt(1,estudiante_id);
            connection.close();
       }
       catch(Exception e){
       e.printStackTrace();
       
       }    
    }
    
    public Estudiante readEstudiante (int id){
     MysqlDb mysqlDb = new MysqlDb();
     Connection connection = mysqlDb.getConnection();
     Estudiante estudiante = null;
        try {            
            String sql ="SELECT * FROM estudiantes WHERE id=?";
            Statement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery(sql);
            while(resultado.next()){
                estudiante = new Estudiante(resultado.getInt("id"),resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("telefono"),resultado.getString("direccion"));
            }      
            return estudiante;
            
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
      
    }
}
