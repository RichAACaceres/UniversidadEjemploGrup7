
package Transversa_Grupo7.AccesoADato;

import Trasnversal_Grupo7.Entidades.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InscripcionData {
    private Connection con=Conexion.getConexion();
private MateriaData md=new MateriaData();
private AlumnoData ad=new AlumnoData();
    public InscripcionData() {
    }
  
    public void guardarInscripciones(Inscripcion ins){
    String sql="INSERT INTO `inscripcion`(`nota`, `idAlumno`, `idMateria`) "
            + "VALUES ( ?,?,?)";
   
    
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
         ps.setDouble(1, ins.getNota());
       ps.setInt(2, ins.getAlumno().getIdAlumno());
       ps.setInt(3,ins.getMateria().getIdMateria() );
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
           if(rs.next()){
           ins.setIdInscripcion(rs.getInt("idInscripcion"));
           JOptionPane.showMessageDialog(null,"Inscripcion cargada");
           }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar la inscripcion");
              System.out.println(ex.getMessage());
        }
    
    }
    public ArrayList<Inscripcion>obtenerInscripciones(){
    ArrayList<Inscripcion> inscripciones=new ArrayList();
    Inscripcion ins=new Inscripcion();
    String sql="SELECT * FROM inscripcion";
        try {
            PreparedStatement ps=con.prepareStatement(sql) ;
           ResultSet rs=ps.executeQuery();
           while(rs.next()){
        ins.setIdInscripcion(rs.getInt("idInscripcion"));
        Alumno alu=ad.buscarAlumno(rs.getInt("idAlumno"));
        Materia mat=md.buscarMateria(rs.getInt("idMateria"));
        ins.setAlumno(alu);
        ins.setMateria(mat);
        ins.setNota(rs.getInt("nota"));
        inscripciones.add(ins);
              
           }
            ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al obtener inscripciones");
        }
    return inscripciones;
    }
    public ArrayList<Inscripcion>obtenerInscripcionesPorAlumno(int id){
    ArrayList<Inscripcion>inscripciones=new ArrayList();
    Inscripcion ins=new Inscripcion();
    String sql="SELECT * FROM inscripcion WHERE idAlumno = ? ";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
           ResultSet rs=ps.executeQuery();
           while(rs.next()){
           ins.setIdInscripcion(rs.getInt("idInscripcion"));
           Alumno alu=ad.buscarAlumnoPorDni(rs.getInt("idAlumno"));
           Materia mat=md.buscarMateria(rs.getInt("idMateria"));
           ins.setAlumno(alu);
           ins.setMateria(mat);
           ins.setNota(rs.getInt("nota"));
           inscripciones.add(ins);
           }
           
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al listar inscripciones por alumno");
        }
    
        return inscripciones;
    
    }
    public ArrayList<Materia> obtenerMateriasCursadas(int id){
        ArrayList<Materia> materias=new ArrayList();
      
        String sql="SELECT inscripcion.idMateria, nombre, año FROM inscripcion, materia "
                + "WHERE inscripcion.idmateria = materia.idMateria AND inscripcion.idAlumno = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
           ResultSet rs= ps.executeQuery();
           while(rs.next()){
                 Materia mat=new Materia();
           mat.setNombre(rs.getString("nombre"));
      
           mat.setAnioMateria(rs.getInt("año"));
           mat.setIdMateria(rs.getInt("idMateria"));
           materias.add(mat);
           }
           ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al listar materias por alumno");
            System.out.println(ex.getMessage());
        }

    return materias;
    }
    public ArrayList<Materia> obtenerMateriasNoCursadas(int id){
    ArrayList <Materia> materias= new ArrayList();

    String sql="SELECT * FROM materia WHERE estado > 0 AND idMateria not in"
            + "(SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();
           while(rs.next()){
                Materia mat=new Materia();
           mat.setNombre(rs.getString("nombre"));
           mat.setAnioMateria(rs.getInt("año"));
           mat.setIdMateria(rs.getInt("idMateria"));
           materias.add(mat);
           }
           ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al obtener materias NO cursadas");
            System.out.println(ex.getMessage());
        }
    
        return materias;
    }
    public void borrarInscripcion(int idAlumno, int idMateria){
        String sql="DELETE FROM inscripcion WHERE inscripcion.idAlumno = ? AND inscripcion.idMateria = ?";

 
        try {
             PreparedStatement ps = con.prepareStatement(sql);
                 ps.setInt(1, idAlumno);
             ps.setInt(2, idMateria);
            int verificar=ps.executeUpdate();
            if(verificar > 0){
            JOptionPane.showMessageDialog(null, "Inscripción borrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al eliminar la inscripcion");
        }
   
    }
    public void actualizarNota(int idAlumno, int idMateria, double nota){
        String sql="UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
         ps.setDouble(1, nota);
         ps.setInt(2, idAlumno);
         ps.setInt(3, idMateria);
         int verificar=ps.executeUpdate();
         if(verificar > 0){
         JOptionPane.showMessageDialog(null, "Nota actualizada");
         }
         ps.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Error al actualizar nota");
        }
        
    
    }
    public ArrayList<Alumno> obtenerAlumnosPorMateria(int idMateria){
    ArrayList<Alumno>alumnos=new ArrayList();
    
    String sql="SELECT alumno.idAlumno , dni , fechaNacimiento , apellido , estado "
            + "FROM inscripcion, alumno "
            + "WHERE inscripcion.idAlumno = alumno.idAlumno AND inscripcion.idMateria = ? AND alumno.estado > 0";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                
                Alumno alu= new Alumno();
                
            alu.setApellido(rs.getString("apellido"));
                        alu.setNombre(rs.getString("nombre"));//Salta un error sobre que no reconoce la columna "nombre"
            alu.setDni(rs.getInt("dni"));
            alu.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
            alu.setIdAlumno(rs.getInt("idAlumno"));

            alumnos.add(alu);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener alumnos por materia");
            System.out.println(ex.getMessage());
        }
    
        return alumnos;
    }
}
