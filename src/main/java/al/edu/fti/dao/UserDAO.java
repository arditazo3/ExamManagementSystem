package al.edu.fti.dao;

import al.edu.fti.entity.Exam;
import al.edu.fti.entity.User;
import al.edu.fti.enums.StatusEnum;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDAO implements IUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser(String username, String password) {

        String queryGetUser = " select u " +
                              " from User u " +
                              " where u.username = :username and " +
                              "       u.password = :password and " +
                              "       u.status = :status ";

        try {
            return (User) entityManager.createQuery(queryGetUser)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .setParameter("status", StatusEnum.ACTIVE)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User createLecturer(User userLecturer) {

        return entityManager.merge(userLecturer);
    }

    @Override
    public User createStudent(User userStudent) {

        return entityManager.merge(userStudent);
    }

    @Override
    public void update(User user) {

        entityManager.merge(user);
    }
}
