//package al.edu.fti.dao;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import al.edu.fti.entity.User;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class UserDAOTest {
//
//	@Autowired
//	private TestEntityManager entityManager;
//	
//	@Autowired
//	UserToTestDao userToTestDao;
//	
////	@Autowired
////	IUserDAO userToTestDao;
//	
//	@Test
//	public void testSaveUser() {
//		
//		User user = getUser();
//		User saveUserInDb = entityManager.persist(user);
//		User getFromDb = userToTestDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//		//	User getFromDb = userToTestDao.createUpdateStudent(user);
//		
//		assertThat(getFromDb.getUsername()).isEqualTo(saveUserInDb.getUsername());
//	}
//	
//	
//	private User getUser() {
//		
//		User user = new User();
//		user.setFirstName("first_name21");
//		user.setLastName("last_name12");
//		user.setUsername("username21");
//		user.setEmail("email21");
//		user.setPassword("password21");
//		return user;
//	}
//	
//}
