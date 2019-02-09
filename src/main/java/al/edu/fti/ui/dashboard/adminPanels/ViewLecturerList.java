/*
 * Created by JFormDesigner on Sun May 27 00:34:12 CEST 2018
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
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author FTI
 */
public class ViewLecturerList extends JPanel {

    private IUserService userService = FtiApplication.userService;

    public ViewLecturerList(JPanel contentCPnl, User userLogIn) {

        this.contentCPnl = contentCPnl;
        this.cardLayout = cardLayout;
        this.userLogIn = userLogIn;
        initComponents();
    }

    private void lecturerTblMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - FTI
        scrollPane1 = new JScrollPane();
        lecturerTbl = new JTable();

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

            //---- lecturerTbl ----
            lecturerTbl.setModel(new DefaultTableModel(
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
                    "ID", "First name", "Last name", "Email", "Gender", "Date of birth", "Phone number", "Lecturer code"
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
                TableColumnModel cm = lecturerTbl.getColumnModel();
                cm.getColumn(0).setPreferredWidth(40);
            }
            scrollPane1.setViewportView(lecturerTbl);
        }
        add(scrollPane1, "card1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // My component

        javax.swing.border.CompoundBorder compoundBorder = (CompoundBorder) getBorder();
        javax.swing.border.TitledBorder titledBorder = (TitledBorder) compoundBorder.getOutsideBorder();
        titledBorder.setTitle("");


        List<User> listArrayLecturer = userService.getAllLecturer();

        Object[][] tableData = new Object[listArrayLecturer.size()][7];

        for (int i = 0; i < listArrayLecturer.size(); i++) {
            User row = listArrayLecturer.get(i);

            lecturerTbl.getModel().setValueAt(row.getIdUser(), i, 0);
            lecturerTbl.getModel().setValueAt(row.getFirstName(), i, 1);
            lecturerTbl.getModel().setValueAt(row.getLastName(), i, 2);
            lecturerTbl.getModel().setValueAt(row.getEmail(), i, 3);
            lecturerTbl.getModel().setValueAt(row.getGender(), i, 4);
            if(row.getDateBirthday() != null) {
            	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dateBirthString = dateFormat.format(row.getDateBirthday());
                lecturerTbl.getModel().setValueAt(dateBirthString, i, 5);
            } else {
            	lecturerTbl.getModel().setValueAt("", i, 5);
            }
            lecturerTbl.getModel().setValueAt(row.getPhoneNumber(), i, 6);
            if(row.getDateBirthday() != null) {
            	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dateBirthString = dateFormat.format(row.getDateBirthday());
                lecturerTbl.getModel().setValueAt(dateBirthString, i, 7);
            } else {
            	lecturerTbl.getModel().setValueAt("", i, 7);
            }
        }

        lecturerTbl.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                if(!event.getValueIsAdjusting() && lecturerTbl.getSelectedRow() != -1 &&
                        lecturerTbl.getValueAt(lecturerTbl.getSelectedRow(), 0) != null) {

                    cardLayout = (CardLayout)(contentCPnl.getLayout());

                    String idUserString = String.valueOf(lecturerTbl.getValueAt(lecturerTbl.getSelectedRow(), 0));
                    Long idUser = Long.parseLong(idUserString);

                    contentCPnl.add(new CreateLecturer(idUser, userLogIn, contentCPnl, cardLayout), "createLecturer");
                    cardLayout.show(contentCPnl, "createLecturer");
                }
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - FTI
    private JScrollPane scrollPane1;
    private JTable lecturerTbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    // My components
    private CardLayout cardLayout;
    private JPanel contentCPnl;
    private User userLogIn;
}
