package al.edu.fti.dao;

import al.edu.fti.entity.*;

import java.util.List;
import java.util.Map;

public interface ICourseDAO {

    Course createUpdateCourse(Course course);
    List<Course> getCourseByIdUser(Long idUser);
    Course getCourseById(Long idCourse);
    Exam createUpdateExam(Exam exam);

    void createAssociationCourseStudent(Map<String, List<String>> listAssociatedCourseStudent);
    void deleteEntriesByIdCourse(Long idCourse);
    List<Integer> getListIdStudentByIdCourse(Long idCourse);

    Exam getExamById(Long idExam);
    ExamDetailResult createUpdateExamDetailResult(ExamDetailResult examDetailResult);

    void saveEvaluationExam(ExamResult examResult);
    public ExamResult getExamResultByIdStudentAndIdExam(User student, Exam exam);
}
