package al.edu.fti.service;

import al.edu.fti.entity.Course;
import al.edu.fti.entity.Exam;

import java.util.List;

public interface ICourseService {

    Course createUpdateCourse(Course course);
    List<Course> getCourseByIdLecturer(Long idLecturer);
    Course getCourseById(Long idCourse);

    Exam createUpdateExam(Exam exam);
}
