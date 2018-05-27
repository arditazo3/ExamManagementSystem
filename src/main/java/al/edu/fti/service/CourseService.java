package al.edu.fti.service;

import al.edu.fti.dao.ICourseDAO;
import al.edu.fti.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
