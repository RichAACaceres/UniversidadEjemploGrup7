
package Transversal_Grupo7.Main;

import Transversa_Grupo7.AccesoADato.AlumnoData;
import Trasnversal_Grupo7.Entidades.Alumno;
import java.time.LocalDate;
import java.time.Month;

public class Principal {
     public static void main(String[] args) {
        Alumno carlos=new Alumno("Suarez","Martin",LocalDate.of(2024,5,11),true,123123);
        AlumnoData alu=new AlumnoData();
        
        //Guardar Alumno
        alu.guardarAlumno(carlos);
       
//        buscar Alumno por id
//        alu.buscarAlumno(1);
//        
//        Buscar alumno por dni
//        alu.buscarAlumnoPorDni(123123);
//         
//        modificar alumno
//        alu.modificarAlumno(carlos);
//        
//        Eliminar alumno por id
//        alu.eliminarAlumno(1);
//        
//        Listar alumnos
//         System.out.println(alu.listarAlumno());
        
    }
}
