
package com.stpl.trainee.assignment9.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.stpl.trainee.assignment9.bean.StudentBean;
import com.stpl.trainee.assignment9.response.StudentResponse;

@Controller
public class Registration {

    private static final Logger LOGGER = LogManager.getLogger("Registration.class");

    private static final String MAIN_SERVICE_URL = "http://localhost:8085/"
    		+ "JavaAssignment9_StudentRepository_WS_WebService";
    
    private static final String INSERT_SERVICE_URL = "/student/add";
    private static final String GET_SERVICE_URL = "/student/get/";
    
    private static final String EXIST_MESSAGE = "Username Already Exists..!";
    private static final String SUCCESS_MESSAGE = "Registration Successfull..!";
    private static final String REGISTRATION_MESSAGE = "Registration";
    
    @Autowired
    private StudentBean studentBean;
    
    public Registration() {
    	// To fix sonar issue
    }


    @RequestMapping("/RegistrationServlet")
    public ModelAndView registration(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        studentBean.setFullName(request.getParameter("fullname"));
        studentBean.setUserName(request.getParameter("username"));
        studentBean.setPasword(request.getParameter("password"));
        studentBean.setAddress(request.getParameter("address"));
        studentBean.setDob(request.getParameter("dob"));
        studentBean.setGender(request.getParameter("gender"));
        studentBean.setContact(request.getParameter("phone"));
        studentBean.setEmail(request.getParameter("email"));
        studentBean.setCity(request.getParameter("city"));
        studentBean.setState(request.getParameter("state"));
        studentBean.setCountry(request.getParameter("country"));
        studentBean.setCourseName(request.getParameter("course"));
        studentBean.setCourseId(request.getParameter("cid"));
        studentBean.setFees(request.getParameter("fees"));
        studentBean.setDuration(request.getParameter("duration"));
        
        String userName = request.getParameter("username");

        try {

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            
            
            String getUrl = MAIN_SERVICE_URL + GET_SERVICE_URL + userName;
            StudentResponse response = restTemplate.getForObject(getUrl, StudentResponse.class);
            
            if(HttpStatus.NOT_FOUND.equals(response.getStatus()))
            {
                
                String addUrl = MAIN_SERVICE_URL + INSERT_SERVICE_URL;
                restTemplate.put(addUrl, studentBean);

                LOGGER.info(SUCCESS_MESSAGE);
                modelAndView.addObject("deleteSuccessMessage", SUCCESS_MESSAGE);
                modelAndView.setViewName("Login");
            }
            else
            {
                LOGGER.info(EXIST_MESSAGE);
                modelAndView.addObject("deleteFailureMessage", EXIST_MESSAGE);
                modelAndView.setViewName(REGISTRATION_MESSAGE);
            }

        } 
        catch (Exception e) {

            
            LOGGER.error("error:  " + e);
            LOGGER.info("Username Violation Occured..!");
            modelAndView.addObject("deleteFailureMessage", EXIST_MESSAGE);
            modelAndView.setViewName(REGISTRATION_MESSAGE);
            
        }
        return modelAndView;
    }

    @RequestMapping("/RegistrationJsp")
    public String registrationJsp() {
        return REGISTRATION_MESSAGE;

    }

}
