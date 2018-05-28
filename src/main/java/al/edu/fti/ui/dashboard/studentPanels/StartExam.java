/*
 * Created by JFormDesigner on Mon May 28 01:18:57 CEST 2018
 */

package al.edu.fti.ui.dashboard.studentPanels;

import al.edu.fti.FtiApplication;
import al.edu.fti.entity.*;
import al.edu.fti.service.ICourseService;
import org.jdesktop.swingx.VerticalLayout;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

/**
 * @author Ardit Azo
 */
public class StartExam extends JPanel {

    private ICourseService courseService = FtiApplication.courseService;

    public StartExam(JPanel contentCPnl, Course courseToStart, Exam examToStart, User user) {
        this.userInitial = user;
        this.contentCPnl = contentCPnl;
        this.courseInitial = courseToStart;
        this.examInitial = examToStart;
        initComponents();
    }

    private void finishExamBtnActionPerformed(ActionEvent e) {

        Boolean saveAction = true;

        List<ExamDetailResult> examDetailResultList = new ArrayList<ExamDetailResult>();
        Integer order = 0;
        Component[] getAllComponents = this.containerQuestionsPnl.getComponents();

        int indexQuestion = 0;
        for (Component component : getAllComponents) {
            if (component instanceof JPanel) {

                String question = null;
                Boolean answer = null;

                ExamDetailResult examDetailResult = new ExamDetailResult();
                ExamQuestion examQuestion = examQuestionList.get(indexQuestion);
                examDetailResult.setExamQuestion(examQuestion);
                examDetailResult.setExam(examInitial);
                examDetailResult.setUser(userInitial);

                Component[] getAllComponentsJPanel = ((JPanel) component).getComponents();

                for (Component componentInsideJPanel : getAllComponentsJPanel) {

                    if (componentInsideJPanel instanceof JRadioButton) {
                        if (((JRadioButton) componentInsideJPanel).getText().equalsIgnoreCase("True") && ((JRadioButton) componentInsideJPanel).isSelected()) {
                            answer = true;
                        } else if (((JRadioButton) componentInsideJPanel).getText().equalsIgnoreCase("False") && ((JRadioButton) componentInsideJPanel).isSelected()) {
                            answer = false;
                        }
                    } else if (componentInsideJPanel instanceof JLabel) {

                    } else if (componentInsideJPanel instanceof JTextField) {
                        question = ((JTextField) componentInsideJPanel).getText().trim();
                    }
                }

                if (answer != null) {
                    examDetailResult.setAnswer(answer);
                    examDetailResultList.add(examDetailResult);
                }

                indexQuestion++;
            }
        }

        if (getAllComponents.length == examDetailResultList.size()) {

            userInitial.setExamDetailResults(new HashSet<ExamDetailResult>(examDetailResultList));

            Set<ExamDetailResult> examDetailResultSet = new HashSet<ExamDetailResult>();
            for (ExamDetailResult examDetailResultToSave : examDetailResultList) {
                examDetailResultSet.add(courseService.createUpdateExamDetailResult(examDetailResultToSave));
            }

            // Exam Evaluation
            ExamResult examResult = new ExamResult();
            examResult.setUser(userInitial);
            examInitial.setExamDetailResults(examDetailResultSet);
            examResult.setExam(examInitial);
            examResult.setExamEndDate(new Date());

            courseService.startEvaluationExam(examResult);

        } else {

        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Lorem
        panel2 = new JPanel();
        courseLb = new JLabel();
        examTitleLbl = new JLabel();
        examTitleTF = new JTextField();
        containerQuestionsPnl = new JPanel();
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
            examTitleTF.setEditable(false);
            panel2.add(examTitleTF, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel2);

        //======== containerQuestionsPnl ========
        {
            containerQuestionsPnl.setAutoscrolls(true);
            containerQuestionsPnl.setLayout(new VerticalLayout());
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

        examTitleTF.setText(examInitial.getDescription());

        // My component

        javax.swing.border.CompoundBorder compoundBorder = (CompoundBorder) getBorder();
        javax.swing.border.TitledBorder titledBorder = (TitledBorder) compoundBorder.getOutsideBorder();
        titledBorder.setTitle("");

        examQuestionList = new ArrayList<ExamQuestion>(examInitial.getExamQuestions());

        Collections.sort(examQuestionList, new Comparator<ExamQuestion>() {
            public int compare(ExamQuestion o1, ExamQuestion o2) {
                if (o1.getOrder() == o2.getOrder())
                    return 0;
                return o1.getOrder() < o2.getOrder() ? -1 : 1;
            }
        });

        int index = 0;
        for (ExamQuestion examQuestion : examQuestionList) {

            JPanel newGridQuestionPnl = new JPanel();
            JLabel newQuestionNoLbl = new JLabel();
            JTextField newQuestionNoTF = new JTextField();
            newQuestionNoTF.setEditable(false);
            newQuestionNoTF.setText(examQuestion.getQuestion());
            JRadioButton newFalseRB = new JRadioButton();
            JRadioButton newTrueRB = new JRadioButton();

            newGridQuestionPnl.setLayout(new GridBagLayout());
            ((GridBagLayout) newGridQuestionPnl.getLayout()).columnWidths = new int[]{288, 397, 0};
            ((GridBagLayout) newGridQuestionPnl.getLayout()).rowHeights = new int[]{0, 31, 33, 0};
            ((GridBagLayout) newGridQuestionPnl.getLayout()).columnWeights = new double[]{0.0, 0.0, 1.0E-4};
            ((GridBagLayout) newGridQuestionPnl.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 1.0E-4};

            //---- questionNoLbl ----
            newQuestionNoLbl.setText("The Question " + String.valueOf(index + 1));
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
    // Generated using JFormDesigner Evaluation license - Lorem
    private JPanel panel2;
    private JLabel courseLb;
    private JLabel examTitleLbl;
    private JTextField examTitleTF;
    private JPanel containerQuestionsPnl;
    private JPanel addQuestionPnl;
    private JPanel panel3;
    private JButton button3;
    private JButton finishExamBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    // My component
    private JPanel contentCPnl;
    Course courseInitial;
    Exam examInitial;
    User userInitial;
    List<ExamQuestion> examQuestionList = new ArrayList<ExamQuestion>();
}
