package com.stpl.trainee.assignment9.sessionfactory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateSessionFactory {

	public SessionFactory getSessionFactory()
	{
		Configuration con = new Configuration();
        con.configure("/hibernate.cfg.xml");
        SessionFactory sessionFactory = con.buildSessionFactory();
        
        return sessionFactory;
	}

}
