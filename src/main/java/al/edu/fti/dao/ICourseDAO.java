package al.edu.fti.dao;

import al.edu.fti.entity.Course;
import al.edu.fti.entity.Exam;
import al.edu.fti.entity.ExamDetailResult;

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
}
