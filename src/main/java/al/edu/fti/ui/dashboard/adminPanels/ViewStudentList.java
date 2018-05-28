/*
 * Created by JFormDesigner on Sun May 27 09:21:39 CEST 2018
 */

package al.edu.fti.ui.dashboard.adminPanels;

import al.edu.fti.FtiApplication;
import al.edu.fti.entity.User;
import al.edu.fti.service.IUserService;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.List;

/**
 * @author Ardit Azo
 */
public class ViewStudentList extends JPanel {

    private IUserService userService = FtiApplication.userService;

    public ViewStudentList(JPanel contentCPnl) {
        initComponents();
        this.contentCPnl = contentCPnl;
        this.cardLayout = cardLayout;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ardit Azo
        scrollPane1 = new JScrollPane();
        studentTbl = new JTable();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new CardLayout());

        //======== scrollPane1 ========
        {

            //---- studentTbl ----
            studentTbl.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                },
                new String[] {
                    "ID", "First name", "Last name", "Email", "Gender", "Date of birth", "Phone number", "Student code"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, true, true, true, true, true, true
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = studentTbl.getColumnModel();
                cm.getColumn(0).setPreferredWidth(40);
            }
            scrollPane1.setViewportView(studentTbl);
        }
        add(scrollPane1, "card1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // My component

        javax.swing.border.CompoundBorder compoundBorder = (CompoundBorder) getBorder();
        javax.swing.border.TitledBorder titledBorder = (TitledBorder) compoundBorder.getOutsideBorder();
        titledBorder.setTitle("");


        List<User> listArrayLecturer = userService.getAllStudent();

        Object[][] tableData = new Object[listArrayLecturer.size()][7];

        for (int i = 0; i < listArrayLecturer.size(); i++) {
            User row = listArrayLecturer.get(i);

            studentTbl.getModel().setValueAt(row.getIdUser(), i, 0);
            studentTbl.getModel().setValueAt(row.getFirstName(), i, 1);
            studentTbl.getModel().setValueAt(row.getLastName(), i, 2);
            studentTbl.getModel().setValueAt(row.getEmail(), i, 3);
            studentTbl.getModel().setValueAt(row.getGender(), i, 4);
            studentTbl.getModel().setValueAt("GABIM", i, 5);
            studentTbl.getModel().setValueAt(row.getPhoneNumber(), i, 6);
            studentTbl.getModel().setValueAt("GABIM", i, 7);
        }

        studentTbl.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                if(!event.getValueIsAdjusting() && studentTbl.getSelectedRow() != -1 &&
                        studentTbl.getValueAt(studentTbl.getSelectedRow(), 0) != null) {

                    cardLayout = (CardLayout)(contentCPnl.getLayout());

                    String idUserString = String.valueOf(studentTbl.getValueAt(studentTbl.getSelectedRow(), 0));
                    Long idUser = Long.parseLong(idUserString);

                    contentCPnl.add(new CreateStudent(idUser), "createStudent");
                    cardLayout.show(contentCPnl, "createStudent");
                }
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ardit Azo
    private JScrollPane scrollPane1;
    private JTable studentTbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    // My components
    private CardLayout cardLayout;
    private JPanel contentCPnl;
}
