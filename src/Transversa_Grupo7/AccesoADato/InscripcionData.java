
package Transversa_Grupo7.AccesoADato;

import Trasnversal_Grupo7.Entidades.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class InscripcionData {
    private Connection con=Conexion.getConexion();
private MateriaData mt;
private AlumnoData ad;
    public InscripcionData() {
    }
  
    public void guardarInscripcion(Inscripcion ins){
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
    
    
}
