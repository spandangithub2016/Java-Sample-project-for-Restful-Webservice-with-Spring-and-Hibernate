package com.stpl.trainee.assignment9.service;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.stpl.trainee.assignment9.bean.StudentRegistration;
import com.stpl.trainee.assignment9.sessionfactory.CreateSessionFactory;

@Component
public class ViewService {

	private CreateSessionFactory createSessionFactory = new CreateSessionFactory();

	public StudentRegistration view(String userName) {

		Session session;
		session = createSessionFactory.getSessionFactory().openSession();

		StudentRegistration student = (StudentRegistration) session.get(StudentRegistration.class, userName);

		session.close();

		return student;
	}

}
