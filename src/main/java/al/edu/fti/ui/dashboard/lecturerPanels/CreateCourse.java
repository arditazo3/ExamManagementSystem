/*
 * Created by JFormDesigner on Sun May 27 11:11:53 CEST 2018
 */

package al.edu.fti.ui.dashboard.lecturerPanels;

import al.edu.fti.FtiApplication;
import al.edu.fti.entity.Course;
import al.edu.fti.entity.User;
import al.edu.fti.enums.StatusEnum;
import al.edu.fti.service.ICourseService;
import al.edu.fti.service.IUserService;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author Ardit Azo
 */
public class CreateCourse extends JPanel {

    private ICourseService courseService = FtiApplication.courseService;
    private IUserService userService = FtiApplication.userService;

    public CreateCourse(JPanel contentCPnl, CardLayout cardLayout, User user) {

        this.user = user;
        this.contentCPnl = contentCPnl;
        this.cardLayout = cardLayout;

        initComponents();

    }


    private void createNewCourseBtnActionPerformed(ActionEvent e) {

        Boolean createAction = true;

        String description = descrTF.getText().trim();
        String code = codeTF.getText().trim();
        String status = statusCB.getSelectedItem().toString();
        String year = yearTF.getText().trim();
        String remarks = remarksTF.getText().trim();
        String grade = gradeTF.getText().trim();

        String errorMessage = "Plese fill up the fields: ";

        if(description.equals("")) {
            createAction = false;
            errorMessage += "Description ";
        }
        if(code.equals("")) {
            createAction = false;
            errorMessage += "Code ";
        }
        if(status.equals("")) {
            createAction = false;
            errorMessage += "Status ";
        }

        if(createAction) {

            Course course = new Course();
            if(courseInitial != null) {
                course = courseInitial;
            }

            course.setDescription(description);
            course.setCode(code);
            course.setStatus(StatusEnum.getStatus(status));
            course.setYear(year);
            course.setRemarks(remarks);
            course.setGrade(grade);
            course.setUser(user);

            Course courseCreateUpdated = courseService.createUpdateCourse(course);

            if(courseCreateUpdated != null) {
                Object[] options = {"OK"};
                int input = JOptionPane.showOptionDialog(null,
                        "New course is created!","",
                        JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if(input == JOptionPane.OK_OPTION) {
                    java.util.List<User> listStudents = userService.getAllStudent();
                    List<Course> listCourseByLecturer = courseService.getCourseByIdUser(user.getIdUser());

                    contentCPnl.add(new AssociateCourseToStudent(contentCPnl, listStudents, listCourseByLecturer), "associateCourseToStudent");
                    cardLayout.show(contentCPnl, "associateCourseToStudent");
                }
            }

        } else {
            errorMsgLbl.setText(errorMessage);
        }
    }

    private void cancelBtnActionPerformed(ActionEvent e) {

        java.util.List<User> listStudents = userService.getAllStudent();
        List<Course> listCourseByLecturer = courseService.getCourseByIdUser(user.getIdUser());

        contentCPnl.add(new AssociateCourseToStudent(contentCPnl, listStudents, listCourseByLecturer), "associateCourseToStudent");
        cardLayout.show(contentCPnl, "associateCourseToStudent");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Lorem
        headerLbl = new JLabel();
        descrLbl = new JLabel();
        descrTF = new JTextField();
        codeLbl = new JLabel();
        codeTF = new JTextField();
        statusLbl = new JLabel();
        statusCB = new JComboBox();
        yearLbl = new JLabel();
        yearTF = new JTextField();
        remarksLbl = new JLabel();
        remarksTF = new JTextField();
        gradeLbl = new JLabel();
        gradeTF = new JTextField();
        errorMsgLbl = new JLabel();
        panel2 = new JPanel();
        cancelBtn = new JButton();
        saveBtn = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(480, 450));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {121, 350, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {35, 35, 35, 35, 35, 35, 35, 35, 30, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- headerLbl ----
        headerLbl.setText("Create New Course");
        headerLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
        headerLbl.setHorizontalTextPosition(SwingConstants.CENTER);
        add(headerLbl, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- descrLbl ----
        descrLbl.setText("* Description");
        descrLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        descrLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(descrLbl, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(descrTF, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- codeLbl ----
        codeLbl.setText("* Code");
        codeLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        codeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(codeLbl, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(codeTF, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- statusLbl ----
        statusLbl.setText("* Status");
        statusLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        statusLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(statusLbl, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(statusCB, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- yearLbl ----
        yearLbl.setText("Year");
        yearLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        yearLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(yearLbl, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //---- yearTF ----
        yearTF.setToolTipText("format: dd/mm/yyyy");
        add(yearTF, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- remarksLbl ----
        remarksLbl.setText("Remarks");
        remarksLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        remarksLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(remarksLbl, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(remarksTF, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- gradeLbl ----
        gradeLbl.setText("Grade");
        gradeLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
        gradeLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        add(gradeLbl, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));
        add(gradeTF, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //---- errorMsgLbl ----
        errorMsgLbl.setForeground(Color.red);
        errorMsgLbl.setHorizontalTextPosition(SwingConstants.CENTER);
        add(errorMsgLbl, new GridBagConstraints(0, 7, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 103, 63, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //---- cancelBtn ----
            cancelBtn.setText("Cancel");
            cancelBtn.addActionListener(e -> cancelBtnActionPerformed(e));
            panel2.add(cancelBtn, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel2, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- saveBtn ----
        saveBtn.setText("Save");
        saveBtn.addActionListener(e -> createNewCourseBtnActionPerformed(e));
        add(saveBtn, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // My components

        javax.swing.border.CompoundBorder compoundBorder = (CompoundBorder) getBorder();
        javax.swing.border.TitledBorder titledBorder = (TitledBorder) compoundBorder.getOutsideBorder();
        titledBorder.setTitle("");

        statusCB.addItem(StatusEnum.ACTIVE.toString());
        statusCB.addItem(StatusEnum.DISABLED.toString());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Lorem
    private JLabel headerLbl;
    private JLabel descrLbl;
    private JTextField descrTF;
    private JLabel codeLbl;
    private JTextField codeTF;
    private JLabel statusLbl;
    private JComboBox statusCB;
    private JLabel yearLbl;
    private JTextField yearTF;
    private JLabel remarksLbl;
    private JTextField remarksTF;
    private JLabel gradeLbl;
    private JTextField gradeTF;
    private JLabel errorMsgLbl;
    private JPanel panel2;
    private JButton cancelBtn;
    private JButton saveBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //  My components
    Long idCourse = null;
    private CardLayout cardLayout;
    private JPanel contentCPnl;
    Course courseInitial = null;
    User user = null;

}
