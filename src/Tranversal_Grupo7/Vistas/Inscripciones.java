
package Tranversal_Grupo7.Vistas;

import Transversa_Grupo7.AccesoADato.*;
import Trasnversal_Grupo7.Entidades.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class Inscripciones extends javax.swing.JInternalFrame {
    DefaultTableModel modelo= new DefaultTableModel();
   
    public Inscripciones() {
        initComponents();
        cargarCombo();
        armarCabecera();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcAlumnos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jrMateriasInscriptas = new javax.swing.JRadioButton();
        jrMateriasNOInscriptas = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMaterias = new javax.swing.JTable();
        jbInscribir = new javax.swing.JButton();
        jbEliminarInscripcion = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        setTitle("Formulario de inscripciones");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Formulario de inscripción");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Seleccione un alumno");

        jcAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcAlumnosActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Listado de materias");

        jLabel4.setText("Materias inscriptas");

        jLabel5.setText("Materias NO inscriptas");

        jrMateriasInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMateriasInscriptasActionPerformed(evt);
            }
        });

        jrMateriasNOInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrMateriasNOInscriptasActionPerformed(evt);
            }
        });

        jtMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtMaterias);

        jbInscribir.setText("Inscribir");
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jbEliminarInscripcion.setText("Anular inscripcion");
        jbEliminarInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarInscripcionActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jbInscribir)
                .addGap(81, 81, 81)
                .addComponent(jbEliminarInscripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(48, 48, 48))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jrMateriasInscriptas)))
                                .addGap(153, 153, 153)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jrMateriasNOInscriptas))
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(38, 38, 38)
                                    .addComponent(jcAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrMateriasNOInscriptas)
                            .addComponent(jrMateriasInscriptas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 116, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbInscribir)
                            .addComponent(jbEliminarInscripcion)
                            .addComponent(jbSalir))
                        .addGap(50, 50, 50))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcAlumnosActionPerformed
        Alumno alumno= new Alumno();
        alumno=(Alumno) jcAlumnos.getSelectedItem();
     
        
    }//GEN-LAST:event_jcAlumnosActionPerformed

    private void jrMateriasInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMateriasInscriptasActionPerformed
       borrarFilas();
       jrMateriasNOInscriptas.setSelected(false);
       cargarDatosInscriptas();
       jbInscribir.setEnabled(false);
       jbEliminarInscripcion.setEnabled(true);
       
    }//GEN-LAST:event_jrMateriasInscriptasActionPerformed

    private void jrMateriasNOInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrMateriasNOInscriptasActionPerformed
        borrarFilas();
        jrMateriasInscriptas.setSelected(false);
        cargarDatosNOInscriptas();
        jbInscribir.setEnabled(true);
        jbEliminarInscripcion.setEnabled(false);
    }//GEN-LAST:event_jrMateriasNOInscriptasActionPerformed

    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
       int fila=jtMaterias.getSelectedRow();
   
       if(fila!=-1){
              MateriaData md=new MateriaData();
       Alumno alumno=new Alumno();
       
       InscripcionData id=new InscripcionData();
       alumno=(Alumno) jcAlumnos.getSelectedItem();
       int idMateria=(int) modelo.getValueAt(fila, 0);
       String nombre=(String) modelo.getValueAt(fila, 1);
       int año=(int) modelo.getValueAt(fila, 2);
       Materia materia=new Materia(idMateria,nombre,año,true);
       Inscripcion i=new Inscripcion(alumno,materia,0);
       id.guardarInscripciones(i);
       borrarFilas();
       }
    }//GEN-LAST:event_jbInscribirActionPerformed

    private void jbEliminarInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarInscripcionActionPerformed
              int fila=jtMaterias.getSelectedRow();
              if(fila!=-1){
                  InscripcionData id= new InscripcionData();
            Alumno alumno=new Alumno();
            alumno=(Alumno) jcAlumnos.getSelectedItem();
            int idMateria=(int) modelo.getValueAt(fila, 0);
            id.borrarInscripcion(alumno.getIdAlumno(), idMateria);
            borrarFilas();
            
              }
    }//GEN-LAST:event_jbEliminarInscripcionActionPerformed
  public void borrarFilas(){
while(modelo.getRowCount()>0){
modelo.removeRow(0);
}


}
  private void cargarDatosInscriptas(){
        borrarFilas();
  Alumno alumno= new Alumno();
  InscripcionData id= new InscripcionData();
  ArrayList<Materia>materias=new ArrayList();
   alumno=(Alumno) jcAlumnos.getSelectedItem();
  materias=id.obtenerMateriasCursadas(alumno.getIdAlumno());
 for(Materia m :materias){
modelo.addRow(new Object[]{m.getIdMateria(),m.getNombre(),m.getAnioMateria()});
 }
  }
  private void cargarDatosNOInscriptas(){
      borrarFilas();
  Alumno alumno= new Alumno();
  InscripcionData id= new InscripcionData();
  ArrayList<Materia>materias=new ArrayList();
   alumno=(Alumno) jcAlumnos.getSelectedItem();
  materias=id.obtenerMateriasNoCursadas(alumno.getIdAlumno());
 for(Materia m :materias){
modelo.addRow(new Object[]{m.getIdMateria(),m.getNombre(),m.getAnioMateria()});
 }
  }
public void cargarCombo(){
    ArrayList<Alumno> alumnos=new ArrayList();
    AlumnoData ad=new AlumnoData();
    alumnos=ad.listarAlumno();
    for(Alumno alumno: alumnos ){
    jcAlumnos.addItem(alumno);
    
    }
jcAlumnos.setSelectedItem(ui);
}
public void armarCabecera(){
modelo.addColumn("IdMateria");
modelo.addColumn("Nombre");
modelo.addColumn("Año");
jtMaterias.setModel(modelo);

}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbEliminarInscripcion;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcAlumnos;
    private javax.swing.JRadioButton jrMateriasInscriptas;
    private javax.swing.JRadioButton jrMateriasNOInscriptas;
    private javax.swing.JTable jtMaterias;
    // End of variables declaration//GEN-END:variables
}
