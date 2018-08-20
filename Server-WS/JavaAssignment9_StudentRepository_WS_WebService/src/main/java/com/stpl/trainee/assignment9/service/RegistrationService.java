package com.stpl.trainee.assignment9.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import com.stpl.trainee.assignment9.bean.StudentBean;
import com.stpl.trainee.assignment9.bean.StudentRegistration;
import com.stpl.trainee.assignment9.sessionfactory.CreateSessionFactory;

@Component
public class RegistrationService {

	private static final Logger LOGGER = LogManager.getLogger("RegistrationService.class");
	private CreateSessionFactory createSessionFactory = new CreateSessionFactory();

	public int insert(StudentBean bean) {

		
		Session session = null;
		Transaction tr = null;
		
		session = createSessionFactory.getSessionFactory().openSession();
		tr = session.beginTransaction();
		
		return registrationService(bean, session, tr);

	}

	public int registrationService(StudentBean bean, Session session, Transaction tr) {

		int result = 0;
		StudentRegistration studentRegister = new StudentRegistration();

		studentRegister.setFullname(bean.getFullName());
		studentRegister.setUsername(bean.getUserName());
		studentRegister.setPasword(bean.getPasword());
		studentRegister.setAddress(bean.getAddress());
		studentRegister.setDob(bean.getDob());
		studentRegister.setGender(bean.getGender());
		studentRegister.setEmail(bean.getEmail());
		studentRegister.setContact(bean.getContact());
		
		try {

			session.save(studentRegister);
			tr.commit();

			result = 1;

		} 
		catch (Exception e) {
			
			if(tr != null)
        	{
        		tr.rollback();
        	}

			LOGGER.info("Error in Registration: " + e);

		} 
		finally {
			
			if (session != null) {
				session.close();
			}

		}
		return result;
	}
}
