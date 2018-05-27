package al.edu.fti.service;

import al.edu.fti.dao.ICourseDAO;
import al.edu.fti.entity.Course;
import al.edu.fti.entity.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public List<Course> getCourseByIdLecturer(Long idLecturer) {

        return courseDAO.getCourseByIdLecturer(idLecturer);
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
}
