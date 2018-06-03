package al.edu.fti.dao;

import al.edu.fti.entity.User;
import al.edu.fti.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
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

    private IRoleDAO roleDAO;

    @Autowired
    public void setRoleDAO(IRoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

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
        	e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserById(Long idUser) {
        return entityManager.find(User.class, idUser);
    }

    @Override
    public User createUpdateLecturer(User userLecturer) {

        return entityManager.merge(userLecturer);
    }

    @Override
    public User createUpdateStudent(User userStudent) {

        return entityManager.merge(userStudent);
    }

    @Override
    public List<User> getAllLecturer() {

        String queryAllLecturer = " select u " +
                                  " from User u " +
                                  " where u.role = :role and " +
                                  " u.status = :status ";

        return (List<User>) entityManager.createQuery(queryAllLecturer)
                                        .setParameter("role", roleDAO.getRoleById(2L))
                                        .setParameter("status", StatusEnum.ACTIVE)
                                        .getResultList();

    }

    @Override
    public List<User> getAllStudent() {

        String queryAllLecturer = " select u " +
                                  " from User u " +
                                  " where u.role = :role and " +
                                  " u.status = :status ";

        return (List<User>) entityManager.createQuery(queryAllLecturer)
                                        .setParameter("role", roleDAO.getRoleById(3L))
                                        .setParameter("status", StatusEnum.ACTIVE)
                                        .getResultList();
    }

    @Override
    public void update(User user) {

        entityManager.merge(user);
    }
}
