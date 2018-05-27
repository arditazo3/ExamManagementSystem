package al.edu.fti.service;

import al.edu.fti.dao.IUserDAO;
import al.edu.fti.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User createLecturer(User userLecturer) {

        return userDAO.createLecturer(userLecturer);
    }

    @Override
    public User createStudent(User userStudent) {

        return userDAO.createStudent(userStudent);
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
}
