/*
 * Created by JFormDesigner on Sat May 26 15:46:17 CEST 2018
 */

package al.edu.fti.ui.dashboard;

import al.edu.fti.FtiApplication;
import al.edu.fti.entity.Course;
import al.edu.fti.entity.User;
import al.edu.fti.service.ICourseService;
import al.edu.fti.service.IUserService;
import al.edu.fti.ui.dashboard.adminPanels.CreateLecturer;
import al.edu.fti.ui.dashboard.adminPanels.CreateStudent;
import al.edu.fti.ui.dashboard.adminPanels.ViewLecturerList;
import al.edu.fti.ui.dashboard.adminPanels.ViewStudentList;
import al.edu.fti.ui.dashboard.lecturerPanels.AssociateCourseToStudent;
import al.edu.fti.ui.dashboard.lecturerPanels.CreateCourse;
import al.edu.fti.ui.dashboard.lecturerPanels.CreateExamQuestions;
import al.edu.fti.ui.dashboard.studentPanels.ViewMyExams;
import al.edu.fti.ui.login_form.LoginForm;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * @author Ardit Azo
 */
public class DashboardFrame extends JFrame {

    private ICourseService courseService = FtiApplication.courseService;
    private IUserService userService = FtiApplication.userService;
    public User userLogIn;
    public JFrame jFrameAfterCreation;

    public DashboardFrame(User userLogIn) {
        this.userLogIn = userLogIn;
        initComponents();
        this.jFrameAfterCreation = this;
    }

    private void createLecturerBtnActionPerformed(ActionEvent e) {

        contentCPnl.add(new CreateLecturer(null, userLogIn, contentCPnl, cardLayout), "createLecturer");
        cardLayout.show(contentCPnl, "createLecturer");
    }

    private void createStudentBtnActionPerformed(ActionEvent e) {

        contentCPnl.add(new CreateStudent(null, userLogIn, contentCPnl, cardLayout), "createStudent");
        cardLayout.show(contentCPnl, "createStudent");
    }

    private void lecturerListBtnActionPerformed(ActionEvent e) {

        contentCPnl.add(new ViewLecturerList(contentCPnl, userLogIn), "viewLecturerList");
        cardLayout.show(contentCPnl, "viewLecturerList");
    }

    private void studentListBtnActionPerformed(ActionEvent e) {

        contentCPnl.add(new ViewStudentList(contentCPnl, userLogIn), "viewStudentList");
        cardLayout.show(contentCPnl, "viewStudentList");
    }

    private void myProfileBtnActionPerformed(ActionEvent e) {

        if (userLogIn.getRole().getIdRole().equals(2L)) {
            contentCPnl.add(new CreateLecturer(userLogIn.getIdUser(), userLogIn, contentCPnl, cardLayout), "createLecturer");
            cardLayout.show(contentCPnl, "createLecturer");
        } else if (userLogIn.getRole().getIdRole().equals(3L)) {
            contentCPnl.add(new CreateStudent(userLogIn.getIdUser(), userLogIn, contentCPnl, cardLayout), "createStudent");
            cardLayout.show(contentCPnl, "createStudent");
        }

    }

    private void createCourseBtnActionPerformed(ActionEvent e) {

        contentCPnl.add(new CreateCourse(contentCPnl, cardLayout, userLogIn), "createCourse");
        cardLayout.show(contentCPnl, "createCourse");
    }

    private void createExamBtnActionPerformed(ActionEvent e) {

        List<Course> listCourse = courseService.getCourseByIdUser(userLogIn.getIdUser());
        if (listCourse != null && listCourse.size() > 0) {
            contentCPnl.add(new CreateExamQuestions(contentCPnl, cardLayout, listCourse, userLogIn), "createExamQuestions");
            cardLayout.show(contentCPnl, "createExamQuestions");
        } else {

            Object[] options = {"OK"};
            int input = JOptionPane.showOptionDialog(null,
                    "Before creating the exam, you should have at least one course","",
                    JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if(input == JOptionPane.OK_OPTION)
            {
                // do something
            }
        }
    }

    private void associateStudentCourseBtnActionPerformed(ActionEvent e) {

        List<User> listStudents = userService.getAllStudent();
        List<Course> listCourseByLecturer = courseService.getCourseByIdUser(userLogIn.getIdUser());

        contentCPnl.add(new AssociateCourseToStudent(contentCPnl, listStudents, listCourseByLecturer), "associateCourseToStudent");
        cardLayout.show(contentCPnl, "associateCourseToStudent");
    }

    private void myExamsBtnActionPerformed(ActionEvent e) {

        contentCPnl.add(new ViewMyExams(contentCPnl, cardLayout, userLogIn), "viewMyExams");
        cardLayout.show(contentCPnl, "viewMyExams");
    }

    private void logOutBtnActionPerformed(ActionEvent e) {


        this.dispose();

        LoginForm loginForm = new LoginForm();
        loginForm.setTitle("Exam Management System");
        loginForm.setVisible(true);
        loginForm.setResizable(false);
        loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {

        cardLayout = new CardLayout();

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ardit Azo
        userInfoPnl = new JPanel();
        userInfoLbl = new JLabel();
        logOutBtn = new JButton();
        sideMenuPnl = new JPanel();
        lecturerListBtn = new JButton();
        studentListBtn = new JButton();
        createLecturerBtn = new JButton();
        createStudentBtn = new JButton();
        myExamsBtn = new JButton();
        associateStudentCourseBtn = new JButton();
        myProfileBtn = new JButton();
        createCourseBtn = new JButton();
        createExamBtn = new JButton();
        contentCPnl = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {122, 700, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {37, 732, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

        //======== userInfoPnl ========
        {

            // JFormDesigner evaluation mark
            userInfoPnl.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), userInfoPnl.getBorder())); userInfoPnl.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            userInfoPnl.setLayout(new HorizontalLayout(5));
            userInfoPnl.add(userInfoLbl);

            //---- logOutBtn ----
            logOutBtn.setText("Log Out");
            logOutBtn.addActionListener(e -> logOutBtnActionPerformed(e));
            userInfoPnl.add(logOutBtn);
        }
        contentPane.add(userInfoPnl, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.SOUTHEAST, GridBagConstraints.NONE,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== sideMenuPnl ========
        {
            sideMenuPnl.setLayout(new VerticalLayout(5));

            //---- lecturerListBtn ----
            lecturerListBtn.setText("View Lecturer List");
            lecturerListBtn.addActionListener(e -> lecturerListBtnActionPerformed(e));
            sideMenuPnl.add(lecturerListBtn);

            //---- studentListBtn ----
            studentListBtn.setText("View Student List");
            studentListBtn.addActionListener(e -> studentListBtnActionPerformed(e));
            sideMenuPnl.add(studentListBtn);

            //---- createLecturerBtn ----
            createLecturerBtn.setText("Create Lecturer");
            createLecturerBtn.addActionListener(e -> createLecturerBtnActionPerformed(e));
            sideMenuPnl.add(createLecturerBtn);

            //---- createStudentBtn ----
            createStudentBtn.setText("Create Student");
            createStudentBtn.addActionListener(e -> createStudentBtnActionPerformed(e));
            sideMenuPnl.add(createStudentBtn);

            //---- myExamsBtn ----
            myExamsBtn.setText("My Exams");
            myExamsBtn.addActionListener(e -> myExamsBtnActionPerformed(e));
            sideMenuPnl.add(myExamsBtn);

            //---- associateStudentCourseBtn ----
            associateStudentCourseBtn.setText("<html><center>Associate Student<br>To the Course</center></html>");
            associateStudentCourseBtn.addActionListener(e -> {
			createExamBtnActionPerformed(e);
			associateStudentCourseBtnActionPerformed(e);
		});
            sideMenuPnl.add(associateStudentCourseBtn);

            //---- myProfileBtn ----
            myProfileBtn.setText("My Profile");
            myProfileBtn.addActionListener(e -> {
			myProfileBtnActionPerformed(e);
			myProfileBtnActionPerformed(e);
		});
            sideMenuPnl.add(myProfileBtn);

            //---- createCourseBtn ----
            createCourseBtn.setText("Create Course");
            createCourseBtn.addActionListener(e -> createCourseBtnActionPerformed(e));
            sideMenuPnl.add(createCourseBtn);

            //---- createExamBtn ----
            createExamBtn.setText("Create Exam");
            createExamBtn.addActionListener(e -> createExamBtnActionPerformed(e));
            sideMenuPnl.add(createExamBtn);
        }
        contentPane.add(sideMenuPnl, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 5), 0, 0));

        //======== contentCPnl ========
        {
            contentCPnl.setPreferredSize(new Dimension(480, 450));
            contentCPnl.setLayout(new CardLayout());
        }
        contentPane.add(contentCPnl, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // My components modify

        javax.swing.border.CompoundBorder compoundBorder = (CompoundBorder) userInfoPnl.getBorder();
        javax.swing.border.TitledBorder titledBorder = (TitledBorder) compoundBorder.getOutsideBorder();
        titledBorder.setTitle("");

        userInfoLbl.setText("Welcome, " + userLogIn.getFirstName() + " " + userLogIn.getLastName());
        cardLayout = (CardLayout) (contentCPnl.getLayout());

        // Authorization Roles on menu buttons
        if (userLogIn.getRole().getIdRole().equals(1L)) {

            createLecturerBtn.setVisible(true);
            createStudentBtn.setVisible(true);
            lecturerListBtn.setVisible(true);
            studentListBtn.setVisible(true);

            myProfileBtn.setVisible(false);
            createExamBtn.setVisible(false);
            createCourseBtn.setVisible(false);
            associateStudentCourseBtn.setVisible(false);

            myExamsBtn.setVisible(false);

            contentCPnl.add(new ViewLecturerList(contentCPnl, userLogIn), "viewLecturerList");
            cardLayout.show(contentCPnl, "viewLecturerList");

        } else if (userLogIn.getRole().getIdRole().equals(2L)) {

            createLecturerBtn.setVisible(false);
            createStudentBtn.setVisible(false);
            lecturerListBtn.setVisible(false);
            studentListBtn.setVisible(false);

            myExamsBtn.setVisible(false);

            myProfileBtn.setVisible(true);
            createExamBtn.setVisible(true);
            createCourseBtn.setVisible(true);
            associateStudentCourseBtn.setVisible(true);

            associateStudentCourseBtnActionPerformed(null);

        } else if (userLogIn.getRole().getIdRole().equals(3L)) {

            createExamBtn.setVisible(false);
            createCourseBtn.setVisible(false);
            associateStudentCourseBtn.setVisible(false);

            createLecturerBtn.setVisible(false);
            createStudentBtn.setVisible(false);
            lecturerListBtn.setVisible(false);
            studentListBtn.setVisible(false);

            myProfileBtn.setVisible(true);
            myExamsBtn.setVisible(true);

            contentCPnl.add(new ViewMyExams(contentCPnl, cardLayout, userLogIn), "viewMyExams");
            cardLayout.show(contentCPnl, "viewMyExams");

        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ardit Azo
    private JPanel userInfoPnl;
    private JLabel userInfoLbl;
    private JButton logOutBtn;
    private JPanel sideMenuPnl;
    private JButton lecturerListBtn;
    private JButton studentListBtn;
    private JButton createLecturerBtn;
    private JButton createStudentBtn;
    private JButton myExamsBtn;
    private JButton associateStudentCourseBtn;
    private JButton myProfileBtn;
    private JButton createCourseBtn;
    private JButton createExamBtn;
    private JPanel contentCPnl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    // My components
    private CardLayout cardLayout;

    private CreateLecturer createLecturer;
    private CreateStudent createStudent;
    private ViewLecturerList viewLecturerList;

}
