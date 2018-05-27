package demo;
import org.jdesktop.swingx.HorizontalLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddComponentr extends JFrame implements ActionListener {

    JPanel panel;

    public AddComponentr() {
        super("Add component on JFrame at runtime");
        setLayout(new BorderLayout());
        this.panel = new JPanel();
        this.panel.setLayout(new HorizontalLayout());
        add(panel, BorderLayout.CENTER);
        JButton button = new JButton("CLICK HERE");
        add(button, BorderLayout.SOUTH);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent evt) {
        this.panel.add(new JButton("Button"));
        this.panel.revalidate();
       // validate();
    }

    public static void main(String[] args) {
        AddComponentr acojfar = new AddComponentr();
    }
}