package al.edu.fti.dao;

import al.edu.fti.entity.User;

public interface IUserDAO {
    
    User getUser(String username, String password);
    User createLecturer(User userLecturer);
    User createStudent(User userStudent);
    void update(User user);
}
