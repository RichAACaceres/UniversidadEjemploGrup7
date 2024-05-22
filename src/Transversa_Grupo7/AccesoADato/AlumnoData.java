
package Transversa_Grupo7.AccesoADato;


import Trasnversal_Grupo7.Entidades.Alumno;
 import java.sql.*;
import java.time.LocalDate;
 import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
 import javax.swing.JOptionPane; 




public class AlumnoData {
    

    private Connection con=Conexion.getConexion();

     

    
//    public void guardarAlumno(Alumno a){ // viene sin id
//        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
//     try {
//        PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//        ps.setInt(1, a.getDni());
//        ps.setString(2, a.getApellido());
//        ps.setString(3, a.getNombre());
//        ps.setDate(4, Date.valueOf(a.getFechaNacimiento()));//localDate a Date
//        ps.setBoolean(5, a.getActivo()); // if reducido
//        ps.executeUpdate();
//        ResultSet rs = ps.getGeneratedKeys();
//        if (rs.next()) {
//        a.setIdAlumno(rs.getInt("idAlumno"));
//        JOptionPane.showMessageDialog(null, "Alumno añadido con exito."); 
//        }
//        ps.close();
//
//     } catch (SQLException ex) {
//     JOptionPane.showMessageDialog(null, "ErroRRRRRR");
//         System.out.println(ex.getMessage());
//      }
//
//     }
    
    public void guardarAlumno(Alumno a){ // viene sin id
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
     try {
     PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
     ps.setInt(1, a.getDni());
     ps.setString(2, a.getApellido());
     ps.setString(3, a.getNombre());
     ps.setDate(4, Date.valueOf(a.getFechaNacimiento()));//localDate a Date
     ps.setBoolean(5, a.getActivo()); // if reducido
     ps.executeUpdate();
     ResultSet rs = ps.getGeneratedKeys();
     if (rs.next()) {
     a.setIdAlumno(rs.getInt("idAlumno"));
     JOptionPane.showMessageDialog(null, "Alumno añadido con exito.");
    }
     ps.close();

     } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno");
         System.out.println(ex.getMessage());
    }

     }
    
    
    public Alumno buscarAlumno(int id){
        Alumno alumno=new Alumno();
        
        String sqlAlum="SELECT idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE idAlumno = ? AND estado = 1";
        
        try {
            PreparedStatement ps=con.prepareStatement(sqlAlum);
            
            ps.setInt(1, id);
            ResultSet resul=ps.executeQuery();
            
            if (resul.next()) {
                
                alumno.setIdAlumno(id);
                alumno.setApellido(resul.getString("apellido"));
                alumno.setNombre(resul.getString("nombre"));
                alumno.setFechaNacimiento(resul.getDate("fechaNacimiento").toLocalDate());
                alumno.setDni(resul.getInt("dni"));
                alumno.setActivo(true);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumno por id");
        }
        
        return alumno;

    }
    
    public Alumno buscarAlumnoPorDni(int dni){
        Alumno alumno=new Alumno();
        
        String sql="SELECT idAlumno, dni, apellido, nombre, fechaNacimiento, estado FROM alumno WHERE dni = ? AND estado = 1";
                
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, dni);
            
            ResultSet resul=ps.executeQuery();
            
            if(resul.next()){
                alumno.setIdAlumno(resul.getInt("idAlumno"));
                alumno.setDni(dni);
                alumno.setApellido(resul.getString("apellido"));
                alumno.setNombre(resul.getString("nombre"));
                alumno.setFechaNacimiento(resul.getDate("fechaNacimiento").toLocalDate());
                alumno.setActivo(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar alumno por DNI");
        }
        
        return alumno;
                
    }
    
    public void modificarAlumno(Alumno a){
        
        String sql="UPDATE alumno SET dni = ? ,apellido = ? ,nombre = ? ,fechaNacimiento = ? ,estado = ? WHERE idAlumno = ? " ;
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
         
            ps.setInt(1,a.getDni());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getNombre());
            ps.setDate(4, Date.valueOf(a.getFechaNacimiento()));
           ps.setBoolean(5, a.getActivo());    
ps.setInt(6, a.getIdAlumno());
            
           int good=ps.executeUpdate();
           
           if (good==1){
               
               JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
           }else{
               JOptionPane.showMessageDialog(null, "El alumno no existe");
           }
        } catch (SQLException ex) {
            System.out.println("Estoy aqui");
           // JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());

        }
        
    }
    
    public void eliminarAlumno(int id){
        String sql="DELETE FROM `alumno` WHERE idAlumno = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int verificar=ps.executeUpdate();
            if(verificar>0){
                System.out.println("Alumno con el id. "+id+" eliminado" );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar alumno");
        }
        
    
    }
    
    public ArrayList <Alumno> listarAlumno(){
         ArrayList<Alumno> alumnos=new ArrayList();
         String sql="SELECT * FROM `alumno` WHERE estado > 0";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            Alumno alumno=new Alumno();
            alumno.setIdAlumno(rs.getInt("idAlumno"));
            alumno.setDni(rs.getInt("dni"));
            alumno.setApellido(rs.getString("apellido"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setFechaNacimiento(rs.getDate("fechaNacimiento").toLocalDate());
            alumno.setActivo(true);
            alumnos.add(alumno);
            
            }
            ps.close();
        } catch (SQLException ex) {
       JOptionPane.showMessageDialog(null, "error al listar alumnos");
        }
         
        return alumnos;
    
    }
}
