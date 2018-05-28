/*
 * Created by JFormDesigner on Mon May 28 01:18:57 CEST 2018
 */

package al.edu.fti.ui.dashboard.studentPanels;

import al.edu.fti.entity.Course;
import al.edu.fti.entity.Exam;
import al.edu.fti.entity.ExamQuestion;
import org.jdesktop.swingx.VerticalLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Ardit Azo
 */
public class StartExam extends JPanel {

    public StartExam(JPanel contentCPnl, Course courseToStart, Exam examToStart) {
        this.contentCPnl = contentCPnl;
        this.courseInitial = courseToStart;
        this.examInitial = examToStart;
        initComponents();
    }

    private void finishExamBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ardit Azo
        panel2 = new JPanel();
        courseLb = new JLabel();
        examTitleLbl = new JLabel();
        examTitleTF = new JTextField();
        containerQuestionsPnl = new JPanel();
        gridQuestionPnl = new JPanel();
        questionNoLbl = new JLabel();
        questionNoTF = new JTextField();
        trueRB = new JRadioButton();
        falseRB = new JRadioButton();
        addQuestionPnl = new JPanel();
        panel3 = new JPanel();
        button3 = new JButton();
        finishExamBtn = new JButton();

        //======== this ========
        setAutoscrolls(true);

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new VerticalLayout());

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {197, 361, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {60, 25, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

            //---- courseLb ----
            courseLb.setText("Course: ");
            courseLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
            courseLb.setHorizontalTextPosition(SwingConstants.CENTER);
            panel2.add(courseLb, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 5, 0), 0, 0));

            //---- examTitleLbl ----
            examTitleLbl.setText("Exam title");
            panel2.add(examTitleLbl, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));

            //---- examTitleTF ----
            examTitleTF.setEnabled(false);
            panel2.add(examTitleTF, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel2);

        //======== containerQuestionsPnl ========
        {
            containerQuestionsPnl.setAutoscrolls(true);
            containerQuestionsPnl.setLayout(new VerticalLayout());

            //======== gridQuestionPnl ========
            {
                gridQuestionPnl.setLayout(new GridBagLayout());
                ((GridBagLayout)gridQuestionPnl.getLayout()).columnWidths = new int[] {288, 397, 0};
                ((GridBagLayout)gridQuestionPnl.getLayout()).rowHeights = new int[] {0, 31, 33, 0};
                ((GridBagLayout)gridQuestionPnl.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)gridQuestionPnl.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

                //---- questionNoLbl ----
                questionNoLbl.setText("The Question");
                gridQuestionPnl.add(questionNoLbl, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 3, 0), 0, 0));
                gridQuestionPnl.add(questionNoTF, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 3, 0), 0, 0));

                //---- trueRB ----
                trueRB.setText("True");
                gridQuestionPnl.add(trueRB, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 3), 0, 0));

                //---- falseRB ----
                falseRB.setText("False");
                gridQuestionPnl.add(falseRB, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            containerQuestionsPnl.add(gridQuestionPnl);
        }
        add(containerQuestionsPnl);

        //======== addQuestionPnl ========
        {
            addQuestionPnl.setLayout(new GridBagLayout());
            ((GridBagLayout)addQuestionPnl.getLayout()).columnWidths = new int[] {687, 0};
            ((GridBagLayout)addQuestionPnl.getLayout()).rowHeights = new int[] {0};
            ((GridBagLayout)addQuestionPnl.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
            ((GridBagLayout)addQuestionPnl.getLayout()).rowWeights = new double[] {1.0E-4};
        }
        add(addQuestionPnl);

        //======== panel3 ========
        {
            panel3.setLayout(new GridBagLayout());
            ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {345, 342, 0};
            ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {15, 0, 0};
            ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

            //---- button3 ----
            button3.setText("Cancel");
            panel3.add(button3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 10), 0, 0));

            //---- finishExamBtn ----
            finishExamBtn.setText("Finish the Exam");
            finishExamBtn.addActionListener(e -> finishExamBtnActionPerformed(e));
            panel3.add(finishExamBtn, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel3);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // My component
        List<ExamQuestion> examQuestionList = new ArrayList<ExamQuestion>(examInitial.getExamQuestions());

        Collections.sort(examQuestionList, new Comparator<ExamQuestion>(){
            public int compare(ExamQuestion o1, ExamQuestion o2){
                if(o1.getOrder() == o2.getOrder())
                    return 0;
                return o1.getOrder() < o2.getOrder() ? -1 : 1;
            }
        });

        int index = 0;
        for (ExamQuestion examQuestion : examQuestionList) {

            JPanel newGridQuestionPnl = new JPanel();
            JLabel newQuestionNoLbl = new JLabel();
            JTextField newQuestionNoTF = new JTextField();
            newQuestionNoTF.setText(examQuestion.getQuestion());
            JRadioButton newFalseRB = new JRadioButton();
            JRadioButton newTrueRB = new JRadioButton();

            newGridQuestionPnl.setLayout(new GridBagLayout());
            ((GridBagLayout)newGridQuestionPnl.getLayout()).columnWidths = new int[] {288, 397, 0};
            ((GridBagLayout)newGridQuestionPnl.getLayout()).rowHeights = new int[] {0, 31, 33, 0};
            ((GridBagLayout)newGridQuestionPnl.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)newGridQuestionPnl.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

            //---- questionNoLbl ----
            newQuestionNoLbl.setText("The Question " + String.valueOf(index+1));
            newGridQuestionPnl.add(newQuestionNoLbl, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 3, 0), 0, 0));
            newGridQuestionPnl.add(newQuestionNoTF, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 3, 0), 0, 0));

            //---- trueRB ----
            newTrueRB.setText("True");
            newGridQuestionPnl.add(newTrueRB, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 3), 0, 0));

            //---- falseRB ----
            newFalseRB.setText("False");
            newGridQuestionPnl.add(newFalseRB, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));


            this.containerQuestionsPnl.add(newGridQuestionPnl);
            this.containerQuestionsPnl.revalidate();

            index++;
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ardit Azo
    private JPanel panel2;
    private JLabel courseLb;
    private JLabel examTitleLbl;
    private JTextField examTitleTF;
    private JPanel containerQuestionsPnl;
    private JPanel gridQuestionPnl;
    private JLabel questionNoLbl;
    private JTextField questionNoTF;
    private JRadioButton trueRB;
    private JRadioButton falseRB;
    private JPanel addQuestionPnl;
    private JPanel panel3;
    private JButton button3;
    private JButton finishExamBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    // My component
    private JPanel contentCPnl;
    Course courseInitial;
    Exam examInitial;
}
