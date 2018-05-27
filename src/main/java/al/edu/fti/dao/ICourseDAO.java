package al.edu.fti.dao;

import al.edu.fti.entity.Course;

import java.util.List;

public interface ICourseDAO {

    Course createUpdateCourse(Course course);
    List<Course> getCourseByIdLecturer(Long idLecturer);
}
