package al.edu.fti.dao;

import al.edu.fti.entity.Course;
import al.edu.fti.entity.Exam;

import java.util.List;

public interface ICourseDAO {

    Course createUpdateCourse(Course course);
    List<Course> getCourseByIdLecturer(Long idLecturer);
    Course getCourseById(Long idCourse);
    Exam createUpdateExam(Exam exam);
}
