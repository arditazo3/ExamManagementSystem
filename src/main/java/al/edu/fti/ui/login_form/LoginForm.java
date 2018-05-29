/*
 * Created by JFormDesigner on Sat May 26 00:24:31 CEST 2018
 */

package al.edu.fti.ui.login_form;

import al.edu.fti.FtiApplication;
import al.edu.fti.entity.User;
import al.edu.fti.service.IUserService;
import al.edu.fti.ui.dashboard.DashboardFrame;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * @author Ardit Azo
 */
@Component
public class LoginForm extends JFrame {

    private IUserService userService = FtiApplication.userService;

    public LoginForm() {
        initComponents();
    }

    private void onLogInHandler(ActionEvent e) {

        // initial state
        errorLbl.setVisible(true);

        //
        if(userService.getUser(usernameTF.getText(), String.valueOf(passwordPF.getPassword())) != null) {

            User userLogIn = userService.getUser(usernameTF.getText(), String.valueOf(passwordPF.getPassword()));

            // update the date of log in
            userLogIn.setLastLoginDate(new Date());
            userService.update(userLogIn);

            this.setVisible(false);

            DashboardFrame dashboardFrame = new DashboardFrame(userLogIn);
            dashboardFrame.setTitle("Exam Management System");
            dashboardFrame.setVisible(true);
            dashboardFrame.getContentPane().setSize(840,850);
            dashboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        } else {
            errorLbl.setVisible(true);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Lorem
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        mainLbl = new JLabel();
        usernameLbl = new JLabel();
        usernameTF = new JTextField();
        passwordLbl = new JLabel();
        passwordPF = new JPasswordField();
        errorLbl = new JLabel();
        logInBtn = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {92, 213, 0};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {66, 29, 29, 35, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

                //---- mainLbl ----
                mainLbl.setText("Exam Management System");
                mainLbl.setHorizontalTextPosition(SwingConstants.CENTER);
                mainLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
                contentPanel.add(mainLbl, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- usernameLbl ----
                usernameLbl.setText("Username");
                usernameLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
                contentPanel.add(usernameLbl, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- usernameTF ----
                usernameTF.setText("aa.aa");
                contentPanel.add(usernameTF, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- passwordLbl ----
                passwordLbl.setText("Password");
                contentPanel.add(passwordLbl, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));

                //---- passwordPF ----
                passwordPF.setText("aa");
                contentPanel.add(passwordPF, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- errorLbl ----
                errorLbl.setText("Wrong username or password! Please try again.");
                errorLbl.setVisible(false);
                errorLbl.setForeground(Color.red);
                errorLbl.setHorizontalTextPosition(SwingConstants.CENTER);
                contentPanel.add(errorLbl, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- logInBtn ----
                logInBtn.setText("Log In");
                logInBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
                logInBtn.addActionListener(e -> onLogInHandler(e));
                contentPanel.add(logInBtn, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        javax.swing.border.CompoundBorder compoundBorder = (CompoundBorder) dialogPane.getBorder();
        javax.swing.border.TitledBorder titledBorder = (TitledBorder) compoundBorder.getOutsideBorder();
        titledBorder.setTitle("");

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Lorem
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel mainLbl;
    private JLabel usernameLbl;
    private JTextField usernameTF;
    private JLabel passwordLbl;
    private JPasswordField passwordPF;
    private JLabel errorLbl;
    private JButton logInBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
