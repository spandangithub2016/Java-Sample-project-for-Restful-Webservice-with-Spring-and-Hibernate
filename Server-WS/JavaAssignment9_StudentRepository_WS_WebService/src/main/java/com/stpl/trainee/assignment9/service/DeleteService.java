package com.stpl.trainee.assignment9.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.stpl.trainee.assignment9.bean.StudentRegistration;
import com.stpl.trainee.assignment9.sessionfactory.CreateSessionFactory;

@Component
public class DeleteService {

    private static final Logger LOGGER = LogManager.getLogger("DeleteService.class");
    private CreateSessionFactory createSessionFactory = new CreateSessionFactory();

    public int delete(String userName) {

        int result = 0;
        Session session = null;
        Transaction transaction = null;

        try {
        	
        	session = createSessionFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            StudentRegistration  student = (StudentRegistration) session.get(StudentRegistration.class, userName);

            if (student != null) {

                session.delete(student);
                transaction.commit();
                result = 1;
            }

        }
        catch (Exception e) {
        	
            LOGGER.info("Error in Deleteion: " + e);
            
            if(transaction != null)
        	{
        		transaction.rollback();
        	}
            
        }
        finally {
			
        	if (session != null) {
                session.close();
            }
		}
        
        return result;
    }

}
