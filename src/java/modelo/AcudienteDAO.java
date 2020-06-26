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
public class AcudienteDAO {
 
    public void create(Acudiente acudiente){
        
     MysqlDb mysqlDb = new MysqlDb();
     Connection connection = mysqlDb.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO acudientes VALUES (NULL,?,?,?,?,?)");
            statement.setString(1, acudiente.getNombre());    
            statement.setString(2, acudiente.getApellido());  
            statement.setString(3, acudiente.getDireccion()); 
            statement.setString(4, acudiente.getTelefono());  
            statement.setInt(5, acudiente.getId());
            statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public ArrayList<Acudiente> read (){
        ArrayList<Acudiente> acudientes = new ArrayList();
     MysqlDb mysqlDb = new MysqlDb();
     Connection connection = mysqlDb.getConnection();
        try {            
            String sql ="SELECT * FROM acudientes";
            Statement sentencia = connection.prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery(sql);
            while(resultado.next()){
                acudientes.add(new Acudiente(resultado.getInt("acudiente_id"),resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("telefono"),resultado.getString("direccion")));
            }      
            return acudientes;
            
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
      
    }
    
    public void update(Acudiente acudiente){
      
     MysqlDb mysqlDb = new MysqlDb();
     Connection connection = mysqlDb.getConnection(); 
      try{
       PreparedStatement statement = connection.prepareStatement("UPDATE acudientes SET  nombre=?,apellido=?,direccion=?, telefono=? WHERE id=?");
            statement.setString(1, acudiente.getNombre());
            statement.setString(2, acudiente.getApellido());  
            statement.setString(3, acudiente.getDireccion()); 
            statement.setString(4, acudiente.getTelefono());
            statement.setInt(5, acudiente.getId());
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
       PreparedStatement statement = connection.prepareStatement("DELETE * FROM acudientes WHERE id=?");
            statement.setInt(1,id);
            connection.close();
       }
       catch(Exception e){
       e.printStackTrace();
       
       }    
    }
    
}
