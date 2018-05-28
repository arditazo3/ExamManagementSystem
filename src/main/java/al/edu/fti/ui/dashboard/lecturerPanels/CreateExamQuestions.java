/*
 * Created by JFormDesigner on Sun May 27 13:01:53 CEST 2018
 */

package al.edu.fti.ui.dashboard.lecturerPanels;

import al.edu.fti.FtiApplication;
import al.edu.fti.entity.Course;
import al.edu.fti.entity.Exam;
import al.edu.fti.entity.ExamQuestion;
import al.edu.fti.service.ICourseService;
import al.edu.fti.utils.Concept;
import al.edu.fti.utils.RenderComboBox;
import org.jdesktop.swingx.VerticalLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Ardit Azo
 */
public class CreateExamQuestions extends JPanel {

    private ICourseService courseService = FtiApplication.courseService;

    public CreateExamQuestions(JPanel contentCPnl, List<Course> listCourse) {
        this.listCourse = listCourse;
        initComponents();
    }

    private void createNewCourseBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void addQuestionBtnActionPerformed(ActionEvent e) {

        JPanel newGridQuestionPnl = new JPanel();
        JLabel newQuestionNoLbl = new JLabel();
        JTextField newQuestionNoTF = new JTextField();
        JRadioButton newFalseRB = new JRadioButton();
        JRadioButton newTrueRB = new JRadioButton();

        newGridQuestionPnl.setLayout(new GridBagLayout());
        ((GridBagLayout)newGridQuestionPnl.getLayout()).columnWidths = new int[] {288, 397, 0};
        ((GridBagLayout)newGridQuestionPnl.getLayout()).rowHeights = new int[] {0, 31, 33, 0};
        ((GridBagLayout)newGridQuestionPnl.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
        ((GridBagLayout)newGridQuestionPnl.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

        //---- questionNoLbl ----
        newQuestionNoLbl.setText("The Question");
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
    }

    private void saveExamBtnActionPerformed(ActionEvent e) {

        Boolean saveAction = true;

        if(courseCB.getSelectedItem() == null || courseCB.getSelectedItem().equals("")) {
            saveAction = false;
        }
        String examTtile = examTitleTF.getText().trim();
        if(examTtile.equals("")) {
            saveAction = false;
        }

        if(saveAction) {

            Concept conceptSelected = (Concept)(courseCB.getSelectedItem());
            Long idCourse = Long.valueOf(conceptSelected.getValue());

            Exam newExam = new Exam();
            newExam.setDescription(examTtile);
            newExam.setCourse(courseService.getCourseById(idCourse));

            List<ExamQuestion> listExamQuestion = new ArrayList<ExamQuestion>();
            Integer order = 0;
            Component[] getAllComponents = this.containerQuestionsPnl.getComponents();

            for (Component component : getAllComponents) {
                if(component instanceof JPanel) {

                    String question = null;
                    Boolean answer = null;

                    Component[] getAllComponentsJPanel = ((JPanel) component).getComponents();

                    for (Component componentInsideJPanel : getAllComponentsJPanel) {
                        if(componentInsideJPanel instanceof JRadioButton) {
                            if(((JRadioButton) componentInsideJPanel).getText().equalsIgnoreCase("True") && ((JRadioButton) componentInsideJPanel).isSelected()) {
                                answer = true;
                            } else if(((JRadioButton) componentInsideJPanel).getText().equalsIgnoreCase("False") && ((JRadioButton) componentInsideJPanel).isSelected()) {
                                answer = false;
                            }
                        } else if(componentInsideJPanel instanceof JLabel) {

                        } else if(componentInsideJPanel instanceof JTextField) {
                            question = ((JTextField) componentInsideJPanel).getText().trim();
                        }
                    }

                    if(question != null && !question.equalsIgnoreCase("") && answer != null) {

                        ExamQuestion examQuestion = new ExamQuestion();
                        examQuestion.setQuestion(question);
                        examQuestion.setAnswer(answer);
                        examQuestion.setOrder(order);

                        examQuestion.setExam(newExam);

                        listExamQuestion.add(examQuestion);

                        order++;
                    }
                }
            }

            if(listExamQuestion.size() > 0) {

                newExam.setExamQuestions(new HashSet<ExamQuestion>(listExamQuestion));

                courseService.createUpdateExam(newExam);
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ardit Azo
        examQuestionPnl = new JPanel();
        panel2 = new JPanel();
        headerLbl = new JLabel();
        courseLbl = new JLabel();
        courseCB = new JComboBox();
        examTitleLbl = new JLabel();
        examTitleTF = new JTextField();
        containerQuestionsPnl = new JPanel();
        gridQuestionPnl = new JPanel();
        questionNoLbl = new JLabel();
        questionNoTF = new JTextField();
        trueRB = new JRadioButton();
        falseRB = new JRadioButton();
        addQuestionPnl = new JPanel();
        addQuestionBtn = new JButton();
        panel3 = new JPanel();
        button3 = new JButton();
        saveExamBtn = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(480, 450));

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new VerticalLayout());

        //======== examQuestionPnl ========
        {
            examQuestionPnl.setAutoscrolls(true);
            examQuestionPnl.setLayout(new VerticalLayout());

            //======== panel2 ========
            {
                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {197, 361, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {60, 30, 25, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

                //---- headerLbl ----
                headerLbl.setText("Create Exam related to the Course");
                headerLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
                headerLbl.setHorizontalTextPosition(SwingConstants.CENTER);
                panel2.add(headerLbl, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- courseLbl ----
                courseLbl.setText("* Course");
                panel2.add(courseLbl, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 5), 0, 0));
                panel2.add(courseCB, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- examTitleLbl ----
                examTitleLbl.setText("* Exam title");
                panel2.add(examTitleLbl, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 5), 0, 0));
                panel2.add(examTitleTF, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            examQuestionPnl.add(panel2);

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
            examQuestionPnl.add(containerQuestionsPnl);

            //======== addQuestionPnl ========
            {
                addQuestionPnl.setLayout(new GridBagLayout());
                ((GridBagLayout)addQuestionPnl.getLayout()).columnWidths = new int[] {687, 0};
                ((GridBagLayout)addQuestionPnl.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)addQuestionPnl.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                ((GridBagLayout)addQuestionPnl.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- addQuestionBtn ----
                addQuestionBtn.setText("Add Question");
                addQuestionBtn.addActionListener(e -> addQuestionBtnActionPerformed(e));
                addQuestionPnl.add(addQuestionBtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            examQuestionPnl.add(addQuestionPnl);

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

                //---- saveExamBtn ----
                saveExamBtn.setText("Save Exam");
                saveExamBtn.addActionListener(e -> saveExamBtnActionPerformed(e));
                panel3.add(saveExamBtn, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            examQuestionPnl.add(panel3);
        }
        add(examQuestionPnl);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // My components
        List<Concept> listConcepts = new ArrayList<Concept>();
        for (Course course : listCourse) {
            listConcepts.add(new Concept(course.getDescription(), String.valueOf(course.getIdCourse())));
        }
        courseCB = RenderComboBox.getRendererComboBox(courseCB, listConcepts);


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ardit Azo
    private JPanel examQuestionPnl;
    private JPanel panel2;
    private JLabel headerLbl;
    private JLabel courseLbl;
    private JComboBox courseCB;
    private JLabel examTitleLbl;
    private JTextField examTitleTF;
    private JPanel containerQuestionsPnl;
    private JPanel gridQuestionPnl;
    private JLabel questionNoLbl;
    private JTextField questionNoTF;
    private JRadioButton trueRB;
    private JRadioButton falseRB;
    private JPanel addQuestionPnl;
    private JButton addQuestionBtn;
    private JPanel panel3;
    private JButton button3;
    private JButton saveExamBtn;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    //  My components
    JFrame jFrameAfterCreation;
    List<Course> listCourse = new ArrayList<>();
}
