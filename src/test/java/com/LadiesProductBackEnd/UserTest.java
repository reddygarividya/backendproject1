package com.LadiesProductBackEnd;

import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.spring.config.hiberConfig;
import com.spring.dao.UserDAO;
import com.spring.model.User;

@Ignore
@ComponentScan("com.spring.model") 
public class UserTest {
	
	
	@Autowired
	private static UserDAO userDAO;


	@Autowired
	private static User user;




@BeforeClass
@Ignore
public static void initialize()

{

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

	context.scan("com.spring.*");

	context.register(hiberConfig.class);

	context.refresh();

	

	user = (User) context.getBean("user");

	userDAO = (UserDAO) context.getBean("userDAO");

}


@Test
@Ignore
public void addUserTest()

{

	 user=new User();

	//user.setUser_id(1);

	user.setFirstName("vidhya");

	user.setLastName("reddy");

	
	user.setPhone("5654545");

	user.setEmail("vidhya@gmail.com");

	user.setPassword("123");

	user.setRole("ROLE_USER");
	boolean flag=userDAO.insertUser(user);
	assertEquals("createCategoryTestCase", true, flag);


}


}


