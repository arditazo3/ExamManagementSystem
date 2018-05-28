/*
 * Created by JFormDesigner on Sun May 27 19:18:35 CEST 2018
 */

package al.edu.fti.ui.dashboard.lecturerPanels;

import al.edu.fti.FtiApplication;
import al.edu.fti.entity.Course;
import al.edu.fti.entity.User;
import al.edu.fti.service.ICourseService;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ardit Azo
 */
public class AssociateCourseToStudent extends JPanel {

    private ICourseService courseService = FtiApplication.courseService;

    public AssociateCourseToStudent(JPanel contentCPnl, List<User> listStudents, List<Course> listCourseByLecturer) {
        this.contentCPnl = contentCPnl;
        this.listStudents = listStudents;
        this.listCourseByLecturer = listCourseByLecturer;
        initComponents();
    }

    private void createNewCourseBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void joinStudentCourseActionPerformed(ActionEvent e) {

        List<String> courseSelected = courseJList.getSelectedValuesList();
        List<String> studentSelected = studentJList.getSelectedValuesList();

        Map<String, List<String>> listAssociatedCourseStudent = new HashMap<String, List<String>>();

        for (String courseSelectedString : courseSelected) {
            for (String studentSelectedString : studentSelected) {

                String courseSelectedStringSplitted = courseSelectedString.split("-")[0].trim();
                String studentSelectedStringSplitted = studentSelectedString.split("-")[0].trim();

                if (listAssociatedCourseStudent.get(courseSelectedStringSplitted) == null ||
                        listAssociatedCourseStudent.get(courseSelectedStringSplitted).size() == 0) {
                    List<String> listString = new ArrayList<>();
                    listString.add(studentSelectedStringSplitted);
                    listAssociatedCourseStudent.put(courseSelectedStringSplitted, listString);
                } else {
                    listAssociatedCourseStudent.get(courseSelectedStringSplitted).add(studentSelectedStringSplitted);
                }
            }
        }

        if (listAssociatedCourseStudent != null && listAssociatedCourseStudent.size() > 0) {

            courseService.createAssociationCourseStudent(listAssociatedCourseStudent);
        }
    }

    private void courseJListValueChanged(ListSelectionEvent e) {

        JList source = (JList) e.getSource();

        if (!e.getValueIsAdjusting() && source.getSelectedValuesList().size() == 1) {

            String itemSelected = source.getSelectedValue().toString();
            String idCourseSelected = itemSelected.split("-")[0].trim();

            List<Integer> studentSelectedByCourse = courseService.getListIdStudentByIdCourse(Long.valueOf(idCourseSelected));

            for (Integer idStudentSelected : studentSelectedByCourse) {
                for (int i = 0; i < studentJList.getModel().getSize(); i++) {

                    Object studentItem = studentJList.getModel().getElementAt(i);
                    String studentItemString = studentItem.toString();
                    String idStudentToSelect = studentItemString.split("-")[0].trim();

                    if (Long.valueOf(idStudentSelected).equals(Long.valueOf(idStudentToSelect))) {
                        studentJList.setSelectedIndex(i);
                    }
                }
            }
        } else if(!e.getValueIsAdjusting() && source.getSelectedValuesList().size() > 1) {
            for (int i = 0; i < studentJList.getModel().getSize(); i++) {
                studentJList.clearSelection();
            }
        }
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
        joinStudentCourse = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(480, 450));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), getBorder()));
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent e) {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            }
        });

        setLayout(new GridBagLayout());
        ((GridBagLayout) getLayout()).columnWidths = new int[]{336, 350, 0};
        ((GridBagLayout) getLayout()).rowHeights = new int[]{35, 27, 417, 30, 0};
        ((GridBagLayout) getLayout()).columnWeights = new double[]{0.0, 0.0, 1.0E-4};
        ((GridBagLayout) getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- headerLbl ----
        headerLbl.setText("Associate Course To the Student");
        headerLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(headerLbl, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 0), 0, 0));

        //---- courseHeaderLbl ----
        courseHeaderLbl.setText("ID - Course");
        add(courseHeaderLbl, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //---- studentHeaderLbl ----
        studentHeaderLbl.setText("ID - Student");
        add(studentHeaderLbl, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

        //======== scrollPane1 ========
        {

            //---- courseJList ----
            courseJList.addListSelectionListener(e -> courseJListValueChanged(e));
            scrollPane1.setViewportView(courseJList);
        }
        add(scrollPane1, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 5), 0, 0));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(studentJList);
        }
        add(scrollPane2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));

        //---- joinStudentCourse ----
        joinStudentCourse.setText("Join Student to Course");
        joinStudentCourse.addActionListener(e -> joinStudentCourseActionPerformed(e));
        add(joinStudentCourse, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // My component

        javax.swing.border.CompoundBorder compoundBorder = (CompoundBorder) getBorder();
        javax.swing.border.TitledBorder titledBorder = (TitledBorder) compoundBorder.getOutsideBorder();
        titledBorder.setTitle("");

        DefaultListModel listModelStudent = new DefaultListModel();
        for (User student : listStudents) {
            listModelStudent.addElement(student.getIdUser().toString() + " - " + student.getFirstName() + " " + student.getLastName());
        }
        studentJList.setModel(listModelStudent);

        DefaultListModel listModelCourse = new DefaultListModel();
        for (Course course : listCourseByLecturer) {
            listModelCourse.addElement(course.getIdCourse().toString() + " - " + course.getDescription());
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
    private JButton joinStudentCourse;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    // My component
    private JPanel contentCPnl;
    List<User> listStudents = new ArrayList<>();
    List<Course> listCourseByLecturer = new ArrayList<>();
}
