package al.edu.fti.dao;

import org.springframework.data.repository.CrudRepository;

import al.edu.fti.entity.User;

public interface UserToTestDao extends CrudRepository<User, Long> {

	
	User findByUsernameAndPassword(String username, String password);
}
