package al.edu.fti.dao;

import al.edu.fti.entity.User;

import java.util.List;

public interface IUserDAO {
    
    User getUser(String username, String password);
    User createLecturer(User userLecturer);
    User createStudent(User userStudent);
    List<User> getAllLecturer();
    List<User> getAllStudent();
    void update(User user);
}
