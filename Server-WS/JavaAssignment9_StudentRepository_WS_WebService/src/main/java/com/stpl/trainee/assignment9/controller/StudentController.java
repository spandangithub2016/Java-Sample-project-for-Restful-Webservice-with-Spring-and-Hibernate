package com.stpl.trainee.assignment9.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.stpl.trainee.assignment9.bean.StudentBean;
import com.stpl.trainee.assignment9.bean.StudentRegistration;
import com.stpl.trainee.assignment9.response.StudentResponse;
import com.stpl.trainee.assignment9.service.DeleteService;
import com.stpl.trainee.assignment9.service.LoginService;
import com.stpl.trainee.assignment9.service.RegistrationService;
import com.stpl.trainee.assignment9.service.UpdateService;
import com.stpl.trainee.assignment9.service.ViewService;

@RestController
public class StudentController {

    private static final Logger LOGGER = LogManager.getLogger("Login.class");
    
  
    @RequestMapping(value = "/student/login", method = RequestMethod.POST)
    public StudentResponse login(@RequestBody StudentBean studentBean) {

        LoginService loginService = new LoginService();
        StudentResponse studentResponse = new StudentResponse();

        if (loginService.login(studentBean) != 0) {
            LOGGER.info("Login Successfull");
            studentResponse.setStatus(HttpStatus.FOUND);
            studentResponse.setResult("Login Successfull");
            return studentResponse;
            
        } 
        else {
            LOGGER.info("Login Failed");
            studentResponse.setStatus(HttpStatus.NOT_FOUND);
            studentResponse.setResult("Login Failed, Wrong Username, Password");
            return studentResponse;
        }

    }

    @RequestMapping(value = "/student/add", method = RequestMethod.PUT)
    public StudentResponse registration(@RequestBody StudentBean studentBean) {

        RegistrationService registerableService = new RegistrationService();
        StudentResponse studentResponse = new StudentResponse();

        if (registerableService.insert(studentBean) != 0) {

            LOGGER.info("Regstration Successfull");
            studentResponse.setStatus(HttpStatus.OK);
            studentResponse.setResult("Regstration Successfull");
            return studentResponse;
        } 
        else {

            LOGGER.info("Regstration Failed");
            studentResponse.setStatus(HttpStatus.NOT_ACCEPTABLE);
            studentResponse.setResult("Regstration Failed, username already exists");
            return studentResponse;
        }

    }

    @RequestMapping(value = "/student/delete/{userName}", method = RequestMethod.DELETE)
    public StudentResponse delete(@PathVariable("userName") String userName) {

        DeleteService deleteService = new DeleteService();
        StudentResponse studentResponse = new StudentResponse();

        if (deleteService.delete(userName) != 0) {

            LOGGER.info("Deleted Successfully");
            studentResponse.setStatus(HttpStatus.OK);
            studentResponse.setResult("Deletion Successfull");
            return studentResponse;
        } 
        else {

            LOGGER.info("Deletion Failed");
            studentResponse.setStatus(HttpStatus.NOT_FOUND);
            studentResponse.setResult("Deletion Failed, username does not exist");
            return studentResponse;
        }

    }

    @RequestMapping(value = "/student/update", method = RequestMethod.PUT)
    public StudentResponse update(@RequestBody StudentBean studentBean) {

        UpdateService updateService = new UpdateService();
        StudentResponse studentResponse = new StudentResponse();

        if (updateService.update(studentBean) != 0) {

            LOGGER.info("Updation Successfull");
            studentResponse.setStatus(HttpStatus.OK);
            studentResponse.setResult("Updation Successfull");
            return studentResponse;
        } 
        else {

            LOGGER.info("Updation Failed");
            studentResponse.setStatus(HttpStatus.NOT_FOUND);
            studentResponse.setResult("Updation Failed, username does not exist");
            return studentResponse;
        }

    }

    @RequestMapping(value = "/student/view/{userName}", method = RequestMethod.GET)
    public StudentRegistration view(@PathVariable("userName") String userName) {

        ViewService viewService = new ViewService();
        StudentRegistration bean;

        bean = viewService.view(userName);

        if (bean != null) {

            LOGGER.info("Username found and viewed");
            return bean;
        } 
        else {

            LOGGER.info("Username not found");
            return bean;
        }

    }
    
    @RequestMapping(value = "/student/get/{userName}", method = RequestMethod.GET)
    public StudentResponse get(@PathVariable("userName") String userName) {

        ViewService viewService = new ViewService();
        StudentRegistration bean;
        StudentResponse studentResponse = new StudentResponse();

        bean = viewService.view(userName);

        if (bean != null) {

            LOGGER.info("Username found and viewed");
            studentResponse.setResult("Found");
            studentResponse.setStatus(HttpStatus.FOUND);
            return studentResponse;
        } 
        else {

            LOGGER.info("Username not found");
            studentResponse.setResult("Not Found");
            studentResponse.setStatus(HttpStatus.NOT_FOUND);
            return studentResponse; 
        }

    }
}