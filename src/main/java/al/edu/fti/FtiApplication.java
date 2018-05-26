package al.edu.fti;

import al.edu.fti.service.IUserService;
import al.edu.fti.ui.login_form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class FtiApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new SpringApplicationBuilder(FtiApplication.class).headless(false).run(args);
		LoginForm appFrame = context.getBean(LoginForm.class);

	//	SpringApplication.run(FtiApplication.class, args);

		LoginForm loginForm = new LoginForm();
		loginForm.setTitle("Login Form");
		loginForm.setVisible(true);
		loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginForm.setResizable(false);
	}

	public static IUserService userService;

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
}
