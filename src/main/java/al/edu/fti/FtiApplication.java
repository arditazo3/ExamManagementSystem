package al.edu.fti;

import al.edu.fti.service.ICourseService;
import al.edu.fti.service.IRoleService;
import al.edu.fti.service.IUserService;
import al.edu.fti.ui.login_form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class FtiApplication {

	public static IUserService userService;
	public static IRoleService roleService;
	public static ICourseService courseService;

	@Autowired
	public void setServices(IUserService userService, IRoleService roleService, ICourseService courseService) {
		FtiApplication.userService = userService;
		FtiApplication.roleService = roleService;
		FtiApplication.courseService = courseService;
	}

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new SpringApplicationBuilder(FtiApplication.class).headless(false).run(args);
		LoginForm appFrame = context.getBean(LoginForm.class);

		LoginForm loginForm = new LoginForm();
		loginForm.setTitle("Exam Management System");
		loginForm.setVisible(true);
		loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginForm.setResizable(false);
	}
}
