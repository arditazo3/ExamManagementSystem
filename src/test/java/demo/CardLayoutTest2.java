package demo;

import al.edu.fti.ui.dashboard.adminPanels.CreateLecturer;
import org.jdesktop.swingx.HorizontalLayout;
import org.jdesktop.swingx.VerticalLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CardLayoutTest2 extends JFrame {

    public  void CardLayoutTests() {
        initComponents();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createLecturerBtnActionPerformed(ActionEvent e) {

        cardLayout.show(contentCPnl, "2");
    }

    private void initComponents() {

        createLecturer = new CreateLecturer();

        cardLayout = new CardLayout();

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ardit Azo
        userInfoPnl = new JPanel();
        userInfoLbl = new JLabel();
        logOutBtn = new JButton();
        sideMenuPnl = new JPanel();
        button1 = new JButton();
        createLecturerBtn = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        contentCPnl = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {122, 622, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {28, 0, 0, 0};
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
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 0), 0, 0));

        //======== sideMenuPnl ========
        {
            sideMenuPnl.setLayout(new VerticalLayout(5));

            //---- button1 ----
            button1.setText("text");
            sideMenuPnl.add(button1);

            //---- createLecturerBtn ----
            createLecturerBtn.setText("Create Lecturer");
            createLecturerBtn.addActionListener(e -> {
                createLecturerBtnActionPerformed(e);
            });
            sideMenuPnl.add(createLecturerBtn);

            //---- button3 ----
            button3.setText("text");
            sideMenuPnl.add(button3);

            //---- button4 ----
            button4.setText("text");
            sideMenuPnl.add(button4);

            //---- button5 ----
            button5.setText("text");
            sideMenuPnl.add(button5);

            //---- button6 ----
            button6.setText("text");
            sideMenuPnl.add(button6);
        }
        contentPane.add(sideMenuPnl, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

        //======== contentCPnl ========
        {
            contentCPnl.setLayout(cardLayout);
        }
        contentPane.add(contentCPnl, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // My components modify


        JPanel panel = new JPanel();
        JLabel label = new JLabel("test");
        panel.add(label);

        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("tes 2t");
        panel2.add(label2);

        contentCPnl.add(panel, "1");

        contentCPnl.add(panel2, "2");

        cardLayout = (CardLayout)(contentCPnl.getLayout());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ardit Azo
    private JPanel userInfoPnl;
    private JLabel userInfoLbl;
    private JButton logOutBtn;
    private JPanel sideMenuPnl;
    private JButton button1;
    private JButton createLecturerBtn;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JPanel contentCPnl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    // My components
    private CreateLecturer createLecturer;

    private CardLayout cardLayout = new CardLayout();

    public static void main(String[] args) {

       CardLayoutTest2 cardtest = new CardLayoutTest2();
       cardtest.CardLayoutTests();


    }
}