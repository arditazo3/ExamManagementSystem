package al.edu.fti.dao;

import al.edu.fti.entity.User;

import java.util.List;

public interface IUserDAO {
    
    User getUser(String username, String password);
    User getUserById(Long idUser);
    User createUpdateLecturer(User userLecturer);
    User createUpdateStudent(User userStudent);
    List<User> getAllLecturer();
    List<User> getAllStudent();
    void update(User user);
}
