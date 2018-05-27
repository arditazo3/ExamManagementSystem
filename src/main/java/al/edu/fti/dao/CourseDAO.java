package al.edu.fti.dao;

import al.edu.fti.entity.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class CourseDAO implements ICourseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Course createUpdateCourse(Course course) {

        return entityManager.merge(course);
    }
}
