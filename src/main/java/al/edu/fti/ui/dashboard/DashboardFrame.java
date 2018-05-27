/*
 * Created by JFormDesigner on Sat May 26 15:46:17 CEST 2018
 */

package al.edu.fti.ui.dashboard;

import al.edu.fti.entity.User;
import al.edu.fti.ui.dashboard.adminPanels.CreateLecturer;
import al.edu.fti.ui.dashboard.adminPanels.CreateStudent;
import al.edu.fti.ui.dashboard.adminPanels.ViewLecturerList;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author Ardit Azo
 */
public class DashboardFrame extends JFrame {

    public User userLogIn;

    public DashboardFrame(User userLogIn) {
        this.userLogIn = userLogIn;
        initComponents();
    }

    private void createLecturerBtnActionPerformed(ActionEvent e) {

        cardLayout.show(contentCPnl, "createLecturer");
    }

    private void createStudentBtnActionPerformed(ActionEvent e) {

        cardLayout.show(contentCPnl, "createStudent");
    }

    private void lecturerListBtnActionPerformed(ActionEvent e) {

        cardLayout.show(contentCPnl, "viewLecturerList");
    }

    private void initComponents() {

        createLecturer = new CreateLecturer();
        createStudent = new CreateStudent();
        viewLecturerList = new ViewLecturerList();

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
        button5 = new JButton();
        button6 = new JButton();
        contentCPnl = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {122, 700, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {37, 0, 0, 0};
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
            sideMenuPnl.add(studentListBtn);

            //---- createLecturerBtn ----
            createLecturerBtn.setText("Create Lecturer");
            createLecturerBtn.addActionListener(e -> createLecturerBtnActionPerformed(e));
            sideMenuPnl.add(createLecturerBtn);

            //---- createStudentBtn ----
            createStudentBtn.setText("Create Student");
            createStudentBtn.addActionListener(e -> createStudentBtnActionPerformed(e));
            sideMenuPnl.add(createStudentBtn);

            //---- button5 ----
            button5.setText("text");
            sideMenuPnl.add(button5);

            //---- button6 ----
            button6.setText("text");
            sideMenuPnl.add(button6);
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
        userInfoLbl.setText("Welcome, " + userLogIn.getFirstName() + " " + userLogIn.getLastName());

        cardLayout = (CardLayout)(contentCPnl.getLayout());

        JPanel panelTest = new JPanel();
        JLabel labelTest = new JLabel("Test");
        panelTest.add(labelTest);

        contentCPnl.add(panelTest, "1");
        contentCPnl.add(createLecturer, "createLecturer");
        contentCPnl.add(createStudent, "createStudent");
        contentCPnl.add(viewLecturerList, "viewLecturerList");

        cardLayout = (CardLayout)(contentCPnl.getLayout());

        cardLayout.show(contentCPnl, "1");

        add(contentCPnl, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
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
    private JButton button5;
    private JButton button6;
    private JPanel contentCPnl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    // My components
    private CardLayout cardLayout;

    private CreateLecturer createLecturer;
    private CreateStudent createStudent;
    private ViewLecturerList viewLecturerList;

}
