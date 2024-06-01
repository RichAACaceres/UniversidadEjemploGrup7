
package Transversa_Grupo7.AccesoADato;
import Trasnversal_Grupo7.Entidades.Materia;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MateriaData {
    private Connection con= Conexion.getConexion();

    public MateriaData() {
    }
    
    public void agregarMateria(Materia m){
        
        String sql="INSERT INTO materia(nombre, año, estado) VALUES ( ? , ? , ? )";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, m.getNombre());
            ps.setInt(2, m.getAnioMateria());
            ps.setBoolean(3, m.getActivo());
            
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            
            if(rs.next()){
                m.setIdMateria(rs.getInt("idMateria"));
                
                JOptionPane.showMessageDialog(null,"Materia Agregada Exitosamente");
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Materia");
         System.out.println(ex.getMessage());
        }
        
            
    }
    
    public Materia buscarMateria(int id){
        Materia m=new Materia();
        
        String sql="SELECT idMateria, nombre, año, estado FROM `materia` WHERE idMateria = ? AND estado > 0 ";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs= ps.executeQuery();
            
            if(rs.next()){
                m.setIdMateria(id);
                m.setNombre(rs.getString("nombre"));
                m.setActivo(true);
                m.setAnioMateria(rs.getInt("año"));
           
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar materia por ID");
        }
        
        return m;
    }
    
    public void modificarMateria(Materia m){
        String sql="UPDATE materia SET  nombre = ? , año = ? WHERE idMateria = ? ";

        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            
            ps.setInt(3,m.getIdMateria());
            ps.setString(1,m.getNombre());
            ps.setInt(2,m.getAnioMateria());
            
            int good= ps.executeUpdate();
            
            if(good==1){
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
           }else{
               JOptionPane.showMessageDialog(null, "La Materia a modificar no existe");
           }
            
            
        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());

        }
        
       
        
    }
    
    public void eliminarMAteria(int id){
    
        String sql="UPDATE materia SET estado = 0 WHERE idMateria = ? ";
        
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int fila = ps.executeUpdate();
            
            if(fila==1){
               JOptionPane.showMessageDialog(null, " Se eliminó la materia.");
 
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");
        }
 
    }
    public ArrayList<Materia> listarMateria(){
        ArrayList<Materia> lista=new ArrayList();
        String sql="SELECT * FROM materia WHERE estado > 0";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
           ResultSet rs= ps.executeQuery();
           while(rs.next()){
               Materia materia=new Materia();
               
               materia.setNombre(rs.getString("nombre"));
               materia.setAnioMateria(rs.getInt("año"));
               materia.setIdMateria(rs.getInt("idMateria"));
               materia.setActivo(true);
               lista.add(materia);
               
           }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al listar alumnos");
        }
        
        return lista;
    
    
    }

}
