/*
 * Created by JFormDesigner on Sun May 27 19:18:35 CEST 2018
 */

package al.edu.fti.ui.dashboard.lecturerPanels;

import al.edu.fti.entity.Course;
import al.edu.fti.entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ardit Azo
 */
public class AssociateCourseToStudent extends JPanel {

    public AssociateCourseToStudent(JPanel contentCPnl, List<User> listStudents, List<Course> listCourseByLecturer) {
        this.contentCPnl = contentCPnl;
        this.listStudents = listStudents;
        this.listCourseByLecturer = listCourseByLecturer;
        initComponents();
    }

    private void createNewCourseBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ardit Azo
        headerLbl = new JLabel();
        courseHeaderLbl = new JLabel();
        studentHeaderLbl = new JLabel();
        scrollPane1 = new JScrollPane();
        courseJList = new JList();
        scrollPane2 = new JScrollPane();
        studentJList = new JList();

        //======== this ========
        setPreferredSize(new Dimension(480, 450));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {336, 350, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {35, 27, 446, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

        //---- headerLbl ----
        headerLbl.setText("Associate Course To the Student");
        headerLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(headerLbl, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- courseHeaderLbl ----
        courseHeaderLbl.setText("Course");
        add(courseHeaderLbl, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- studentHeaderLbl ----
        studentHeaderLbl.setText("Student");
        add(studentHeaderLbl, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(courseJList);
        }
        add(scrollPane1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(studentJList);
        }
        add(scrollPane2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // My component
        DefaultListModel listModelStudent = new DefaultListModel();
        for (User student : listStudents) {
            listModelStudent.addElement(student);
        }
        studentJList.setModel(listModelStudent);

        DefaultListModel listModelCourse = new DefaultListModel();
        for (Course course : listCourseByLecturer) {
            listModelCourse.addElement(course);
        }
        courseJList.setModel(listModelCourse);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ardit Azo
    private JLabel headerLbl;
    private JLabel courseHeaderLbl;
    private JLabel studentHeaderLbl;
    private JScrollPane scrollPane1;
    private JList courseJList;
    private JScrollPane scrollPane2;
    private JList studentJList;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    // My component
    private JPanel contentCPnl;
    List<User> listStudents = new ArrayList<>();
    List<Course> listCourseByLecturer = new ArrayList<>();
}
