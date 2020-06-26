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
public class DocenteDAO {
    
    public void create(Docente docente){
        
     MysqlDb mysqlDb = new MysqlDb();
     Connection connection = mysqlDb.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO docentes VALUES (NULL,?,?,?,?)");
            statement.setString(1, docente.getNombre());    
            statement.setString(2, docente.getApellido());  
            statement.setString(3, docente.getDireccion()); 
            statement.setString(4, docente.getTelefono());    
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public ArrayList<Docente> read (){
        ArrayList<Docente> docentes = new ArrayList();
     MysqlDb mysqlDb = new MysqlDb();
     Connection connection = mysqlDb.getConnection();
        try {            
            String sql ="SELECT * FROM docentes";
            Statement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery(sql);
            while(resultado.next()){
                docentes.add(new Docente(resultado.getInt("docente_id"),resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("telefono"),resultado.getString("direccion")));
            }      
            return docentes;
            
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
      
    }
    
    public void update(Docente docente){
      
     MysqlDb mysqlDb = new MysqlDb();
     Connection connection = mysqlDb.getConnection(); 
      try{
       PreparedStatement statement = connection.prepareStatement("UPDATE docentes SET  nombre=?,apellido=?,direccion=?, telefono=? WHERE id=?");
            statement.setString(1, docente.getNombre());
            statement.setString(2, docente.getApellido());  
            statement.setString(3, docente.getDireccion()); 
            statement.setString(4, docente.getTelefono());
            statement.setInt(5, docente.getId());
            connection.close();
       }
       catch(Exception e){
       e.printStackTrace();
       }
    }
    
    public void delete(int id){
        
      MysqlDb mysqlDb = new MysqlDb();
     Connection connection = mysqlDb.getConnection(); 
       try{
       PreparedStatement statement = connection.prepareStatement("DELETE * FROM docentes WHERE id=?");
            statement.setInt(1,id);
            connection.close();
       }
       catch(Exception e){
       e.printStackTrace();
       
       }    
    }
}
