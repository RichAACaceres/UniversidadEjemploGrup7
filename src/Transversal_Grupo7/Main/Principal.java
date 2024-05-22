
package Transversal_Grupo7.Main;

import Transversa_Grupo7.AccesoADato.AlumnoData;
import Transversa_Grupo7.AccesoADato.MateriaData;
import Trasnversal_Grupo7.Entidades.Alumno;
import Trasnversal_Grupo7.Entidades.Materia;
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
    

//        Alumno carlos=new Alumno("Suarez","Martin",LocalDate.of(2024,5,11),true,123123);
//        AlumnoData alu=new AlumnoData();
//        
//        Alumno a2=new Alumno("Cáceres","Ricardo",LocalDate.of(2024,5,19),true,25997033);
//        Alumno a1=new Alumno("Cáceres","Alberto",LocalDate.of(2024,5,20),true,259973);
//         Alumno a3=new Alumno("Cáceres","Alberto",LocalDate.of(2024,5,20),true,973);
        
        //Guardar Alumno
//        alu.guardarAlumno(a3);
       
        //buscar Alumno por id
       // alu.buscarAlumno(1);
//        

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

//         System.out.println(alu.listarAlumno());
        Materia m1=new Materia("Laboratori 1", 2,true);
        MateriaData data=new MateriaData();

        
        //guardar materia
        //data.agregarMateria(m1);
        
        //buscar materia
        
         System.out.println(data.buscarMateria(3));

    }
}
