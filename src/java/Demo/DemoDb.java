/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Demo;

import bdatos.MysqlDb;
import java.util.ArrayList;
import modelo.Estudiante;
import modelo.EstudianteDAO;

/**
 *
 * @author Matias
 */
public class DemoDb {
    public static void main(String []args){
    MysqlDb m= new MysqlDb();
    m.getConnection();
    Estudiante e = new Estudiante();
    EstudianteDAO est = new EstudianteDAO();
    est.create(new Estudiante(0, "rober", "vargas", "cadwe", "dasdasd"));
    est.delete(3);
   ArrayList<Estudiante> alumnos = new ArrayList();
        alumnos=est.read();
        for (int i=0;i<alumnos.size();i++){
            System.out.println(alumnos.get(i).getNombre()+"----"+alumnos.get(i).getApellido());
        }
            }
}
