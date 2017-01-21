/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gUI;

import businesLogic.DataStore;
import education.Education;
import education.EducationDegree;
import education.HigherEducation;
import education.PrimaryEducation;
import education.SecondaryEducation;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import static javax.swing.JTable.AUTO_RESIZE_OFF;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author stanislav
 */
public class NewJDialog extends javax.swing.JDialog {

    public static final int ID_OK = 1;
    public static final int ID_CANCEL = 0;

    private int exitCode = ID_CANCEL;   
    //private DataStore dataStore = null;
    
    private CitizenJDialog owner=null;
    

    /**
     * Creates new form NewJDialog
     */
    public NewJDialog(java.awt.Frame parent, boolean modal) {        
        super(parent, modal);
        //this.dataStore=dataStore;
        initComponents();        
    }

    public NewJDialog(JDialog owner) {
        super(owner);
        this.owner=(CitizenJDialog) owner;
        //this.dataStore=((CitizenJDialog) owner).dataStore;
        bigInitComponents();
        setLocationRelativeTo(getParent());        
    }

    private void bigInitComponents() {
        initComponents();

        jSpinner1.setComponentPopupMenu(new JPopupMenu("Ala Bala"));

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        //model.setColumnCount(2);
        //model.setRowCount(6);
        jTable2.setAutoCreateColumnsFromModel(true);

        model.setDataVector(new Object[][]{{"first name:", ""},
                  {"middle name:", ""}, {"last name:", ""}, {"gender:", ""}, {"date of birth:", ""},
                     {"height:", ""}}, new Object[]{"description", "value"});
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        jTable2.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
                
//        jTable2.setValueAt("first name:", 0, 0);
//        jTable2.setValueAt("middle name:", 1, 0);
//        jTable2.setValueAt("last name:", 2, 0);
//        jTable2.setValueAt("gender:", 3, 0);
//        jTable2.setValueAt("date of birth:", 4, 0);
//        jTable2.setValueAt("height:", 5, 0);
        //jTable2.setVisible(true);
        //model.addColumn(new Object[]{"Description", "Data"});
        //jTable2.addColumn(new TableColumn(0,100));
        //jTable2.addColumn(new TableColumn(1,100));
        //jTable2.setAutoResizeMode(AUTO_RESIZE_OFF);
        //jTable2.setSize(50, 50);
//        model.addRow(new Object[]{"row1", "rpw2"});
//        model.addRow(new Object[]{"row2", "rpw2"});
//        model.addRow(new Object[]{"row3", "rpw2"});
//        model.addRow(new Object[]{"row4", "rpw2"});
//        model.addRow(new Object[]{"row5", "rpw2"});
//        model.addRow(new Object[]{"row6", "rpw2"});
//        model.
        model = (DefaultTableModel) jTable1.getModel();
        model.setDataVector(new Object[][]{{"type:", ""},
                  {"institution name:", ""}, {"enrollment date:", ""}, {"graduation date:", ""}
                , {"graduated:", ""},{"final grade:", ""}}, new Object[]{"description", "value"});
        jTable1.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);


         model = (DefaultTableModel) jTable3.getModel();
        model.setDataVector(new Object[][]{{"year:", ""},
                  {"month:", ""}, {"amount:", ""}}, new Object[]{"description", "value"});
        jTable3.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);

        
        model = (DefaultTableModel) jTable4.getModel();
        model.setDataVector(new Object[][]{{"country:", ""},{"city:", ""},{"municipality:", ""},
                  {"postalCode:", ""}, {"street:", ""}, {"number:", ""}, {"floor:", ""}, 
                  {"apartmentNo:", ""}}, new Object[]{"description", "value"});
        jTable4.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        
        int maxNumCitizen=0;
        if(owner.dataStore!=null){
            maxNumCitizen=owner.dataStore.getCitizensCount()-1;
        }
        
        jSpinner3.setModel(new SpinnerNumberModel(0, 0, maxNumCitizen, 1));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable2.setAutoCreateColumnsFromModel(false);
        jTable2.setBorder(new javax.swing.border.MatteBorder(null));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner2StateChanged(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel());
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jSpinner3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner3StateChanged(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jSpinner1))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jSpinner3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jSpinner1, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSpinner2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinner3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner3StateChanged
        int idx=(int) jSpinner3.getValue();
        jTable2.setValueAt(owner.dataStore.getCitizenAt(idx).getFirstName(), 0, 1);
        jTable2.setValueAt(owner.dataStore.getCitizenAt(idx).getMiddleName(), 1, 1);
        jTable2.setValueAt(owner.dataStore.getCitizenAt(idx).getLastName(), 2, 1);
        jTable2.setValueAt(owner.dataStore.getCitizenAt(idx).getGender().toString(), 3, 1);
        jTable2.setValueAt(owner.dataStore.getCitizenAt(idx).getDateOfBirth().toString(), 4, 1);
        jTable2.setValueAt(owner.dataStore.getCitizenAt(idx).getHeight(), 5, 1);        
        jTable4.setValueAt(owner.dataStore.getCitizenAt(idx).getAddress().getCountry(), 0, 1);
        jTable4.setValueAt(owner.dataStore.getCitizenAt(idx).getAddress().getCity(), 1, 1);
        jTable4.setValueAt(owner.dataStore.getCitizenAt(idx).getAddress().getMunicipality(), 2, 1);
        jTable4.setValueAt(owner.dataStore.getCitizenAt(idx).getAddress().getPostalCode(), 3, 1);
        jTable4.setValueAt(owner.dataStore.getCitizenAt(idx).getAddress().getStreet(), 4, 1);
        jTable4.setValueAt(owner.dataStore.getCitizenAt(idx).getAddress().getNumber(), 5, 1);
        jTable4.setValueAt(owner.dataStore.getCitizenAt(idx).getAddress().getFloor(), 6, 1);
        jTable4.setValueAt(owner.dataStore.getCitizenAt(idx).getAddress().getApartmentNo(), 7, 1);
        
        int maxValue=0;
        if(owner.dataStore.getCitizenAt(idx).getEducations()!=null){
            maxValue=owner.dataStore.getCitizenAt(idx).getEducations().size()-1;
        }
        jSpinner1.setModel(new SpinnerNumberModel(0, 0, maxValue, 1));
        
        maxValue=0;
        if(owner.dataStore.getCitizenAt(idx).getSocialInsuranceRecords()!=null){
            maxValue=owner.dataStore.getCitizenAt(idx).getSocialInsuranceRecords().size()-1;
        }
        jSpinner2.setModel(new SpinnerNumberModel(0, 0, maxValue, 1));
    }//GEN-LAST:event_jSpinner3StateChanged

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        int idx=(int) jSpinner3.getValue();
        int idx1=(int) jSpinner1.getValue();
        Education education=owner.dataStore.getCitizenAt(idx).getEducations().get(idx1);
        if(education instanceof PrimaryEducation){
            jTable1.setValueAt("Primary", 0, 1);
        }else if(education instanceof SecondaryEducation){
            jTable1.setValueAt("Secondary", 0, 1);
             jTable1.setValueAt(((SecondaryEducation) education).getFinalGrade(), 4, 1);
        }else{
            jTable1.setValueAt(((HigherEducation) education).getFinalGrade(), 4, 1);
            switch (((HigherEducation) education).getDegree()){
                case Master:
                    jTable1.setValueAt("Master", 0, 1);
                    break;
                case Bachelor:
                    jTable1.setValueAt("Bachelor", 0, 1);
                    break;
                case Doctorate:
                    jTable1.setValueAt("Doctorate", 0,1);
                    break;
            }
            
        }
        jTable1.setValueAt(education.getEnrollmentDate().toString(), 1, 1);
        jTable1.setValueAt(education.getGraduationDate().toString(), 2, 1);
        jTable1.setValueAt(education.isGraduated(), 3, 1);
        
        
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner2StateChanged
        int idx=(int) jSpinner3.getValue();
        int idx1=(int) jSpinner2.getValue();
        jTable3.setValueAt(owner.dataStore.getCitizenAt(idx).getSocialInsuranceRecords()
                                    .get(idx1).getYear(), 0, 1);
        jTable3.setValueAt(owner.dataStore.getCitizenAt(idx).getSocialInsuranceRecords()
                                    .get(idx1).getMonth(), 1, 1);
        jTable3.setValueAt(owner.dataStore.getCitizenAt(idx).getSocialInsuranceRecords()
                                    .get(idx1).getAmount(), 2, 1);
    }//GEN-LAST:event_jSpinner2StateChanged

    public int doModal() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setVisible(true);

        return exitCode;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
