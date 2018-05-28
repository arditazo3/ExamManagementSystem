package al.edu.fti.dao;

import al.edu.fti.entity.Course;
import al.edu.fti.entity.Exam;
import al.edu.fti.entity.ExamDetailResult;
import al.edu.fti.enums.StatusEnum;
import al.edu.fti.service.IUserService;
import al.edu.fti.utils.CourseStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

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
    public List<Course> getCourseByIdUser(Long idUser) {

        String queryCourseByIdLecturer = " select c from Course c " +
                " where c.user = :user and " +
                " c.status = :status ";

        return entityManager.createQuery(queryCourseByIdLecturer)
                            .setParameter("user", userService.getUserById(idUser))
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

    @Override
    public void createAssociationCourseStudent(Map<String, List<String>> listAssociatedCourseStudent) {

        for (String idCourse : listAssociatedCourseStudent.keySet()) {

            deleteEntriesByIdCourse(Long.valueOf(idCourse));

            for (String idStudent : listAssociatedCourseStudent.get(idCourse)) {
                String queryInsertEntry = " insert into course_student(course_id, student_id) values (:course_id, :student_id) ";
                entityManager.createNativeQuery(queryInsertEntry)
                        .setParameter("course_id", Long.valueOf(idCourse))
                        .setParameter("student_id", Long.valueOf(idStudent))
                        .executeUpdate();
            }
        }

    }

    @Override
    public void deleteEntriesByIdCourse(Long idCourse) {

        String queryDeleteEntriesByIdCourse = " delete from course_student where course_id = :course_id ";

        entityManager.createNativeQuery(queryDeleteEntriesByIdCourse)
                .setParameter("course_id", idCourse)
                .executeUpdate();

    }

    @Override
    public List<Integer> getListIdStudentByIdCourse(Long idCourse) {

        String queryGetIdStudentByIdCourse = " select student_id from course_student where course_id = :course_id ";

        return entityManager.createNativeQuery(queryGetIdStudentByIdCourse)
                .setParameter("course_id", idCourse)
                .getResultList();
    }

    @Override
    public Exam getExamById(Long idExam) {
        return entityManager.find(Exam.class, idExam);
    }

    @Override
    public ExamDetailResult createUpdateExamDetailResult(ExamDetailResult examDetailResult) {
        return entityManager.merge(examDetailResult);
    }
}
