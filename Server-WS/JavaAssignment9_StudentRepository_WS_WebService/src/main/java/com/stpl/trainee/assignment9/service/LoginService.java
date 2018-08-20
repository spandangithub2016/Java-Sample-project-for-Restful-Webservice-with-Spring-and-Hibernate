package com.stpl.trainee.assignment9.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.stpl.trainee.assignment9.bean.StudentBean;
import com.stpl.trainee.assignment9.bean.StudentRegistration;
import com.stpl.trainee.assignment9.sessionfactory.CreateSessionFactory;

@Component
public class LoginService {

	private static final Logger LOGGER = LogManager.getLogger(LoginService.class);
	private CreateSessionFactory createSessionFactory = new CreateSessionFactory();

	public int login(StudentBean bean) {

		Session session = null;
		session = createSessionFactory.getSessionFactory().openSession();

		return loginService(bean, session);

	}

	public int loginService(StudentBean bean, Session session) {

		int result = 0;
		try {

			StudentRegistration student = (StudentRegistration) session.get(StudentRegistration.class,
					bean.getUserName());

			if (student.getPasword().equals(bean.getPasword())) {
				result = 1;
			}

		} 
		catch (Exception e) {
			LOGGER.info("Error is:" + e);
		} 
		finally {

			if (session != null) {
				session.close();
			}
		}
		return result;

	}

}
