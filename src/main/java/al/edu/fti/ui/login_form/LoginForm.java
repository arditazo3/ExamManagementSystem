/*
 * Created by JFormDesigner on Sat May 26 00:24:31 CEST 2018
 */

package al.edu.fti.ui.login_form;

import al.edu.fti.FtiApplication;
import al.edu.fti.service.IUserService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

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
        // TODO add your code here
        if(userService.getUser(usernameTF.getText(), String.valueOf(passwordPF.getPassword())) != null) {
            System.out.print("Logged in!");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ardit Azo
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        mainLbl = new JLabel();
        usernameLbl = new JLabel();
        usernameTF = new JTextField();
        passwordLbl = new JLabel();
        passwordPF = new JPasswordField();
        errorLbl = new JLabel();
        button1 = new JButton();

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
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {109, 29, 29, 0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

                //---- mainLbl ----
                mainLbl.setText("Exam Management System");
                mainLbl.setHorizontalTextPosition(SwingConstants.CENTER);
                contentPanel.add(mainLbl, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- usernameLbl ----
                usernameLbl.setText("Username");
                usernameLbl.setHorizontalTextPosition(SwingConstants.RIGHT);
                contentPanel.add(usernameLbl, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                contentPanel.add(usernameTF, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- passwordLbl ----
                passwordLbl.setText("Password");
                contentPanel.add(passwordLbl, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                contentPanel.add(passwordPF, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- errorLbl ----
                errorLbl.setText("text");
                errorLbl.setVisible(false);
                contentPanel.add(errorLbl, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- button1 ----
                button1.setText("Log In");
                button1.addActionListener(e -> onLogInHandler(e));
                contentPanel.add(button1, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ardit Azo
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel mainLbl;
    private JLabel usernameLbl;
    private JTextField usernameTF;
    private JLabel passwordLbl;
    private JPasswordField passwordPF;
    private JLabel errorLbl;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
