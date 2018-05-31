package al.edu.fti.entities_test;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import al.edu.fti.FtiApplication;
import al.edu.fti.FtiApplicationTests;
import al.edu.fti.dao.IUserDAO;
import al.edu.fti.entity.User;
import al.edu.fti.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FtiApplication.class)
@SpringBootTest
@PropertySource("classpath:/src/test/resources/application.properties")
public class UserDAOTest {

	@Autowired
	private TestEntityManager entityManager;
	private IUserService userService;

	@Test
	public void whenFindByUsernameAndPassword_thenReturnUser() {
		
		// given
		User user = new User();
		user.setFirstName("Name");
		user.setLastName("Surname");
		user.setUsername("username");
		user.setPassword("password");
		entityManager.persist(user);
		entityManager.flush();
		
		// when 
		User userFound = userService.getUser(user.getUsername(), user.getPassword());
		
		// then
		assertThat(userFound.getFirstName()).isEqualTo(user.getFirstName());
		
		
	}
	
}
