package al.edu.fti.service;

import al.edu.fti.dao.ICourseDAO;
import al.edu.fti.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class CourseService implements ICourseService {

    private ICourseDAO courseDAO;

    @Autowired
    public void setCourseDAO(ICourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    public Course createUpdateCourse(Course course) {

        return courseDAO.createUpdateCourse(course);
    }

    @Override
    public List<Course> getCourseByIdUser(Long idUser) {

        return courseDAO.getCourseByIdUser(idUser);
    }

    @Override
    public Course getCourseById(Long idCourse) {

        return courseDAO.getCourseById(idCourse);
    }

    @Override
    public Exam createUpdateExam(Exam exam) {

        return courseDAO.createUpdateExam(exam);
    }

    @Override
    public void createAssociationCourseStudent(Map<String, List<String>> listAssociatedCourseStudent) {

        courseDAO.createAssociationCourseStudent(listAssociatedCourseStudent);
    }

    @Override
    public List<Integer> getListIdStudentByIdCourse(Long idCourse) {

        return courseDAO.getListIdStudentByIdCourse(idCourse);
    }

    @Override
    public Exam getExamById(Long idExam) {

        return courseDAO.getExamById(idExam);
    }

    @Override
    public ExamDetailResult createUpdateExamDetailResult(ExamDetailResult examDetailResult) {

        return courseDAO.createUpdateExamDetailResult(examDetailResult);
    }

    @Override
    public void startEvaluationExam(ExamResult examResult) {

        Set<ExamQuestion> examQuestionList = examResult.getExam().getExamQuestions();
        Set<ExamDetailResult> examDetailResultList = examResult.getExam().getExamDetailResults();

        int countCorrectAnswer = 0;
        for (ExamDetailResult examDetailResult : examDetailResultList) {
            for (ExamQuestion examQuestion : examQuestionList) {

                if(examDetailResult.getExamQuestion().getIdExamQuestion().equals(examQuestion.getIdExamQuestion())) {
                    if(examDetailResult.getAnswer().equals(examQuestion.getAnswer())) {
                        countCorrectAnswer++;
                    }
                }
            }
        }

        examResult.setResult(String.valueOf( (countCorrectAnswer * 100 /examQuestionList.size()) ) + " %");

        courseDAO.saveEvaluationExam(examResult);
    }

    @Override
    public ExamResult getExamResultByIdStudentAndIdExam(User student, Exam exam) {
        return courseDAO.getExamResultByIdStudentAndIdExam(student, exam);
    }
}
