package al.edu.fti.dao;

import al.edu.fti.entity.Course;
import al.edu.fti.entity.Exam;
import al.edu.fti.enums.StatusEnum;
import al.edu.fti.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class CourseDAO implements ICourseDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public Course createUpdateCourse(Course course) {

        return entityManager.merge(course);
    }

    @Override
    public List<Course> getCourseByIdLecturer(Long idLecturer) {

        String queryCourseByIdLecturer = " select c from Course c where c.user = :user and c.status = :status ";

        return entityManager.createQuery(queryCourseByIdLecturer)
                            .setParameter("user", userService.getUserById(idLecturer))
                            .setParameter("status", StatusEnum.ACTIVE)
                            .getResultList();
    }

    @Override
    public Course getCourseById(Long idCourse) {
        return entityManager.find(Course.class, idCourse);
    }

    @Override
    public Exam createUpdateExam(Exam exam) {
        return entityManager.merge(exam);
    }
}
