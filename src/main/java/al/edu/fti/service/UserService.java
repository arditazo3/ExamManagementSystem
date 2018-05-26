package al.edu.fti.service;

import al.edu.fti.dao.IUserDAO;
import al.edu.fti.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
