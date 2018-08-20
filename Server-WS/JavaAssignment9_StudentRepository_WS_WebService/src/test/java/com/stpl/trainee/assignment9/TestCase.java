package com.stpl.trainee.assignment9;

import static org.junit.Assert.assertEquals;
import java.util.Random;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.junit.Test;
import com.stpl.trainee.assignment9.bean.StudentBean;
import com.stpl.trainee.assignment9.service.LoginService;
import com.stpl.trainee.assignment9.service.RegistrationService;
import com.stpl.trainee.assignment9.sessionfactory.CreateSessionFactory;

public class TestCase {

	@Test
	public void loginAndRegistrationServiceTestCase() {

		StudentBean bean = new StudentBean();
		LoginService loginService = new LoginService();
		RegistrationService registrationService = new RegistrationService();
		
		// Test for else part
		bean.setUserName("****");
		bean.setPasword("****");
		loginService.login(bean);

		// Random number generation
		Random random = new Random();
		int offset = random.nextInt(1000);

		// Test for If part- TRUE always. First, Add one data 
		bean.setFullName("Vicky" + offset);
		bean.setUserName("v" + offset);
		bean.setPasword("v" + offset);
		bean.setAddress("v" + offset);
		bean.setDob("1" + offset + "-04-05");
		bean.setGender("Male");
		bean.setEmail("v.v@" + offset + ".com");
		bean.setContact("123456" + offset);
		registrationService.insert(bean);
		
		// Second, check for login with the same username added just before.
		bean.setUserName("v" + offset);
		bean.setPasword("v" + "wrong psw");
		int result = loginService.login(bean);
		if(result == 0)
		{
			
			bean.setUserName("v" + offset);
			bean.setPasword("v" + offset);
			int expected = loginService.login(bean);
			assertEquals(expected, 1);
		}
		else
		{
			assertEquals(result, 0);
		}
		
		
		CreateSessionFactory createSessionFactory = new CreateSessionFactory();
		Session session = createSessionFactory.getSessionFactory().openSession();
		loginService.loginService(bean, session);
		
		Session session1 = createSessionFactory.getSessionFactory().openSession();
		registrationService.registrationService(bean, session1, null);
		
		Session session2 = createSessionFactory.getSessionFactory().openSession();
		Transaction tr2 = session2.beginTransaction();
		registrationService.registrationService(bean, session2, tr2);	
		
		Session session3 = createSessionFactory.getSessionFactory().openSession();
		Transaction tr3 = session3.beginTransaction();
		registrationService.registrationService(bean, null, tr3);	
		
		registrationService.registrationService(bean, null, null);	
		
		Session session4 = createSessionFactory.getSessionFactory().openSession();
		loginService.loginService(null, session4);
		
		loginService.loginService(bean, null);
		loginService.loginService(null, null);
	}

}
