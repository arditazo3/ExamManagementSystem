/*
 * Created by JFormDesigner on Mon May 28 00:19:30 CEST 2018
 */

package al.edu.fti.ui.dashboard.studentPanels;

import al.edu.fti.FtiApplication;
import al.edu.fti.entity.Course;
import al.edu.fti.entity.Exam;
import al.edu.fti.entity.ExamResult;
import al.edu.fti.entity.User;
import al.edu.fti.service.ICourseService;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author FTI
 */
public class ViewMyExams extends JPanel {

    private ICourseService courseService = FtiApplication.courseService;

    public ViewMyExams(JPanel contentCPnl, CardLayout cardLayout, User userLogIn) {

        this.contentCPnl = contentCPnl;
        this.cardLayout = cardLayout;
        this.userInitial = userLogIn;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Lorem
        scrollPane1 = new JScrollPane();
        myExamsTbl = new JTable();

        //======== this ========

        // JFormDesigner evaluation mark
        setBorder(new javax.swing.border.CompoundBorder(
            new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

        setLayout(new CardLayout());

        //======== scrollPane1 ========
        {

            //---- myExamsTbl ----
            myExamsTbl.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                },
                new String[] {
                    "Id Course", "Id Exam", "Course Description", "Exam Description", "Result"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, true, true, true, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = myExamsTbl.getColumnModel();
                cm.getColumn(0).setMaxWidth(90);
                cm.getColumn(1).setMaxWidth(90);
                cm.getColumn(4).setMaxWidth(110);
            }
            scrollPane1.setViewportView(myExamsTbl);
        }
        add(scrollPane1, "card1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // My component

        javax.swing.border.CompoundBorder compoundBorder = (CompoundBorder) getBorder();
        javax.swing.border.TitledBorder titledBorder = (TitledBorder) compoundBorder.getOutsideBorder();
        titledBorder.setTitle("");

        List<Course> listMyCourse = new ArrayList<Course>(userInitial.getCoursesRelatedToStudent());

        Object[][] tableData = new Object[listMyCourse.size()][4];

        for (int i = 0; i < listMyCourse.size(); i++) {
            Course course = listMyCourse.get(i);

            List<Exam> listMyExam = new ArrayList<Exam>(course.getExams());

            for (int j = 0; j < listMyExam.size(); j++) {

                Exam exam = listMyExam.get(j);
                ExamResult examResult = courseService.getExamResultByIdStudentAndIdExam(userInitial, exam);

                myExamsTbl.getModel().setValueAt(course.getIdCourse(), i + j, 0);
                myExamsTbl.getModel().setValueAt(exam.getIdExam(), i + j, 1);
                myExamsTbl.getModel().setValueAt(course.getDescription(), i + j, 2);
                myExamsTbl.getModel().setValueAt(exam.getDescription(), i + j, 3);

                if(examResult != null) {
                    myExamsTbl.getModel().setValueAt(examResult.getResult(), i + j, 4);
                } else {
                    myExamsTbl.getModel().setValueAt("", i + j, 4);
                }

            }
        }

        myExamsTbl.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                if (!event.getValueIsAdjusting() && myExamsTbl.getSelectedRow() != -1 &&
                        myExamsTbl.getValueAt(myExamsTbl.getSelectedRow(), 0) != null) {

                    cardLayout = (CardLayout) (contentCPnl.getLayout());

                    String idCourse = String.valueOf(myExamsTbl.getValueAt(myExamsTbl.getSelectedRow(), 0));
                    Long idCourseLong = Long.parseLong(idCourse);
                    Course courseToStart = courseService.getCourseById(idCourseLong);

                    String idExam = String.valueOf(myExamsTbl.getValueAt(myExamsTbl.getSelectedRow(), 1));
                    Long idExamLong = Long.parseLong(idExam);
                    Exam examToStart = courseService.getExamById(idExamLong);

                    Boolean finishedExam = false;
                    String checkFinishedExam = String.valueOf(myExamsTbl.getValueAt(myExamsTbl.getSelectedRow(), 4));
                    if(!checkFinishedExam.equalsIgnoreCase("")) {
                        finishedExam = true;
                    }

                    if(!finishedExam) {
                        contentCPnl.add(new StartExam(contentCPnl, courseToStart, examToStart, userInitial, cardLayout), "startExam");
                        cardLayout.show(contentCPnl, "startExam");
                    }
                }
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Lorem
    private JScrollPane scrollPane1;
    private JTable myExamsTbl;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    // My components
    private CardLayout cardLayout;
    private JPanel contentCPnl;
    private User userInitial;
}
