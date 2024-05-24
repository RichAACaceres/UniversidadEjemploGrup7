
package Transversal_Grupo7.Main;

import Transversa_Grupo7.AccesoADato.*;
import Trasnversal_Grupo7.Entidades.*;
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
    

//       Alumno carlos=new Alumno("Suarez","Martin",LocalDate.of(2024,5,11),true,123123);
//        AlumnoData alu=new AlumnoData();
//        
//        Alumno a2=new Alumno("Cáceres","Ricardo",LocalDate.of(2024,5,19),true,25997033);
  //     Alumno a1=new Alumno("Cáceres","Alberto",LocalDate.of(2024,5,20),true,259973);
    //Alumno a3=new Alumno("Cáceres","Alberto",LocalDate.of(2024,5,20),true,973);
        //Alumno a4=new Alumno(2,"Sosa","Pepito",LocalDate.of(2024,2,11),true,421);
        //Guardar Alumno
      //alu.guardarAlumno(a4);
       
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
        Materia m1=new Materia("Laboratorio 1", 2,true);
        //Materia m2=new Materia("Matemática", 1,true);
         //Materia m3=new Materia(1,"Ingles", 1,true);
       MateriaData mate=new MateriaData();

        
        //guardar materia
        //data.agregarMateria(m3);
        
        //buscar materia
        
         //System.out.println(data.buscarMateria(3));

         //Listar materias
         //System.out.println(data.listarMateria());
         
//        InscripcionData ins=new InscripcionData();
//        
//        Alumno alumno=alu.buscarAlumno(12);
//        Materia materia=mate.buscarMateria(8);
//        Inscripcion insc=new Inscripcion(alumno,materia,7);
//        ins.guardarInscripcion(insc);
         
    }
}
