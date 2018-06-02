package al.edu.fti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import al.edu.fti.dao.UserToTestDao;
import al.edu.fti.entity.User;

@Service
public class UserToTestService {

	@Autowired
	private UserToTestDao userToTestDao;
	
	public User findByUsernameAndPassword(String username, String password) {
		return userToTestDao.findByUsernameAndPassword(username, password);
	}
	
}
