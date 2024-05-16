/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccesoADato;

import universidadejemplo.Entidades.Alumno;
 import java.sql.Connection;
 import java.sql.Date;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.sql.Statement;
 import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
 import javax.swing.JOptionPane; 
//import java.sql.PreparedStatement;


/**
 *
 * @author Usuario
 */
public class AlumnoData {
    
    private Connection con;

    public AlumnoData(Alumno a) {
    }
    
    public void guardarAlumno(Alumno a){ // viene sin id
        String sql = "INSERT INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUES (?, ?, ?, ?, ?)";
     try {
     PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
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
     JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno"+ex.getMessage()); 
    }

     }
    
    public Alumno buscarAlumno(int id){
        Alumno alumno=new Alumno();
        
        String sqlAlum="SELECT `idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado` FROM `alumno` WHERE idAlumno = ? AND estado = 1";
        
        try {
            PreparedStatement ps=con.prepareStatement(sqlAlum);
            
            ps.setInt(1, id);
            ResultSet resul=ps.executeQuery();
            
            if (resul.next()) {
                
                alumno.setIdAlumno(id);
                alumno.setApellido(resul.getString("apellido"));
                alumno.setNombre(resul.getString("nombre"));
                alumno.setFechaNacimiento(resul.getDate("fechaNacimiento").toLocalDate());
                
                alumno.setActivo(true);
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar por Alumno");
        }
        
        return alumno;

    }
    
    public Alumno buscarAlumnoPorDni(int dni){
        Alumno alumno=new Alumno();
        
        String sql="SELECT `idAlumno`, `dni`, `apellido`, `nombre`, `fechaNacimiento`, `estado` FROM `alumno` WHERE dni = ? AND estado = 1";
                
            
            
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(2, dni);
            
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
            JOptionPane.showMessageDialog(null, "Error al buscar por DNI");
        }
        
        return alumno;
                
    }
    
    public void modificarAlumno(Alumno a){
        
        String sql="UPDATE `alumno` SET `idAlumno`= ? ,`dni`= ? ,`apellido`= ? ,`nombre`= ? ,`fechaNacimiento`= ? ,`estado`= ? ";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setInt(1, a.getIdAlumno());
            ps.setInt(2,a.getDni());
            ps.setString(3, a.getApellido());
            ps.setString(4, a.getNombre());
            ps.setDate(5, Date.valueOf(a.getFechaNacimiento()));
           // ps.setBoolean(6, a.getActivo()); no iria ya que modificarias el estado
            
           int good=ps.executeUpdate();
           
           if (good==1){
               
               JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
           }else{
               JOptionPane.showMessageDialog(null, "El alumno no existe");
           }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());

        }
        
    }
    
    public void eliminarAlumno(int id){
    
    }
    
    public ArrayList <Alumno> listarAlumno(){
    
    }
}
