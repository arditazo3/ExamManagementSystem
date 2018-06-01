package al.edu.fti.entities_test;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import al.edu.fti.FtiApplication;
import al.edu.fti.dao.IUserDAO;
import al.edu.fti.entity.User;
import al.edu.fti.service.IUserService;
import al.edu.fti.service.UserService;
import al.edu.fti.ui.login_form.LoginForm;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = FtiApplication.class)
//@AutoConfigureTestDatabase(replace = Replace.NONE)
@PropertySource("classpath:application.properties")
@Configuration
@EnableAutoConfiguration
@ComponentScan("entities_test")
public class UserDAOTest {
	
//	@Autowired
//	private IUserService userService;
//	
//	@Autowired
//	private TestEntityManager entityManager;

	@Test
	public void whenFindByUsernameAndPassword_thenReturnUser() {
		
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder(FtiApplication.class).headless(false).run("--spring.output.ansi.enabled=always");
		UserService appFrame = context.getBean(UserService.class);

		// given
		User user = new User();
		user.setFirstName("Name");
		user.setLastName("Surname");
		user.setUsername("username");
		user.setPassword("password");
//		entityManager.persist(user);
//		entityManager.flush();
		
		// when 
//		User userFound = userService.getUser(user.getUsername(), user.getPassword());
		
		// then
//		assertThat(userFound.getFirstName()).isEqualTo(user.getFirstName());
		
		
	}
	
}
