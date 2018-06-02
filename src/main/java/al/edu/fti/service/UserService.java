package al.edu.fti.service;

import al.edu.fti.dao.IUserDAO;
import al.edu.fti.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityManager;

@Service
public class UserService implements IUserService {

    private IUserDAO userDAO;

    @Autowired
    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUser(String username, String password) {

        return userDAO.getUser(username, password);
    }

    @Override
    public User getUserById(Long idUser) {
        return userDAO.getUserById(idUser);
    }

    @Override
    public User createUpdateLecturer(User userLecturer) {

        return userDAO.createUpdateLecturer(userLecturer);
    }

    @Override
    public User createUpdateStudent(User userStudent) {

        return userDAO.createUpdateStudent(userStudent);
    }

    @Override
    public List<User> getAllLecturer() {
        return userDAO.getAllLecturer();
    }

    @Override
    public List<User> getAllStudent() {
        return userDAO.getAllStudent();
    }

    @Override
    public void update(User user) {

        userDAO.update(user);
    }

	@Override
	public void setEntityManager(EntityManager entityManager) {
		 
		userDAO.setEntityManager(entityManager);
	}

}
