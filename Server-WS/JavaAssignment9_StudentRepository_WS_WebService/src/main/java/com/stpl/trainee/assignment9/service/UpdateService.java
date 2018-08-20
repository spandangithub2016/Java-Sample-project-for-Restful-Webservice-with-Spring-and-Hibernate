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
public class UpdateService {

	private static final Logger LOGGER = LogManager.getLogger("UpdateService.class");
	private CreateSessionFactory createSessionFactory = new CreateSessionFactory();

	public int update(StudentBean bean) {

		int result = 0;

		StudentRegistration student = new StudentRegistration();

		student.setFullname(bean.getFullName());
		student.setUsername(bean.getUserName());
		student.setPasword(bean.getPasword());
		student.setAddress(bean.getAddress());
		student.setDob(bean.getDob());
		student.setGender(bean.getGender());
		student.setEmail(bean.getEmail());
		student.setContact(bean.getContact());
		
		Session session = null;
		Transaction transaction = null;
		
		try {

			session = createSessionFactory.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.update(student);
			transaction.commit();

			result = 1;

		} 
		catch (Exception e) {
			
			if(transaction != null)
        	{
        		transaction.rollback();
        	}
			
			LOGGER.info("Error in Updation: " + e);

		} 
		finally {
			
			if (session != null) {
				session.close();
			}
			
		}
		return result;
	}
}
