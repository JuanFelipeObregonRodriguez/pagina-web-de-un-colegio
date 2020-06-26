/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Matias
 */
public class MysqlDb {
    
    private static final String DB_PROPERTIES = "propiedades/propiedades.properties";//Propiedades de los archivos properties
     private static final String DB_NAME_PROP = "dbname";
     private static final String DB_HOST_PROP = "host";
     private static final String DB_PASSWORD_PROP = "password";
     private static final String DB_PORT_PROP = "port";
     private static final String DB_USER_PROP = "user";  
 
     public Connection getConnection() {
           try {
               String connectionString = createConnectionString();
               Connection connection = DriverManager.getConnection(connectionString);
               //Connection connection = DriverManager.getConnection(connectionString,"patrones","123456789*a");
               System.out.println("Connection class ==> "+ connection.getClass().getName());
               System.out.println("Se Establecio conexión con ==> "+ DB_HOST_PROP);
               return connection;
           } catch (Exception e) {
               e.printStackTrace();
               e.getMessage();
               System.out.println("no funciona establecer conexion");
               return null;
           }
       }
       
        private String createConnectionString() {
            Properties prop = PropertiesUtil.loadProperty(DB_PROPERTIES);
            System.out.println(prop.getProperty(DB_HOST_PROP));
            String host = prop.getProperty(DB_HOST_PROP);
            String port = prop.getProperty(DB_PORT_PROP);
            String db = prop.getProperty(DB_NAME_PROP);
            String user = prop.getProperty(DB_USER_PROP);
            String password = prop.getProperty(DB_PASSWORD_PROP);
            //String connectionString = "jdbc:mysql://137.135.78.141:3306/patrones?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String connectionString = "jdbc:mysql://"+host+":"+port+"/"+db+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user="+user+"&password="+password;
            System.out.println("ConnectionString ==> " + connectionString);
            return connectionString;
        } 
    
}
