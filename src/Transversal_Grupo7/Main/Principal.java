
package Transversal_Grupo7.Main;

import Transversa_Grupo7.AccesoADato.AlumnoData;
import Trasnversal_Grupo7.Entidades.Alumno;
import java.time.LocalDate;
import java.time.Month;

public class Principal {
     public static void main(String[] args) {
        Alumno carlos=new Alumno("Correa","Carlos",LocalDate.of(2024,5,11),true,123321);
        AlumnoData alu=new AlumnoData();
        
        //Guardar Alumno
       // alu.guardarAlumno(carlos);
       
//        buscar Alumno por id
          //System.out.println(alu.buscarAlumno(9));
    
//        Buscar alumno por dni
         //System.out.println(alu.buscarAlumnoPorDni(123123)); 
//         
//        modificar alumno
       //alu.modificarAlumno(carlos);
//        
//        Eliminar alumno por id
      //alu.eliminarAlumno(9);
//        
//        Listar alumnos
        //System.out.println(alu.listarAlumno());
        
    }
}
