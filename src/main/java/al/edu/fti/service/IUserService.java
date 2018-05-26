package al.edu.fti.service;

import al.edu.fti.entity.User;

public interface IUserService {

    User getUser(String username, String password);
    User createLecturer(User userLecturer);
    void update(User user);
}
