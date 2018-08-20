
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
public class Update {

    private static final Logger LOGGER = LogManager.getLogger("Update.class");

    private static final String MAIN_SERVICE_URL = "http://localhost:8085/"
    		+ "JavaAssignment9_StudentRepository_WS_WebService";
    
    private static final String UPDATE_SERVICE_URL = "/student/update";
    private static final String GET_SERVICE_URL = "/student/get/";
    
    private static final String FAILURE_MESSAGE = "Username doesn't Exists..!";

    @Autowired
    private StudentBean beanObject;
    
    public Update() {
    	// To fix sonar issue
    }

    @RequestMapping("/UpdateServlet")
    public ModelAndView update(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();
        
        String username = request.getParameter("username");

        beanObject.setFullName(request.getParameter("fullname"));
        beanObject.setUserName(request.getParameter("username"));
        beanObject.setPasword(request.getParameter("password"));
        beanObject.setAddress(request.getParameter("address"));
        beanObject.setDob(request.getParameter("dob"));
        beanObject.setGender(request.getParameter("gender"));
        beanObject.setContact(request.getParameter("phone"));
        beanObject.setEmail(request.getParameter("email"));
        beanObject.setCity(request.getParameter("city"));
        beanObject.setState(request.getParameter("state"));
        beanObject.setCountry(request.getParameter("country"));
        beanObject.setCourseName(request.getParameter("course"));
        beanObject.setCourseId(request.getParameter("cid"));
        beanObject.setFees(request.getParameter("fees"));
        beanObject.setDuration(request.getParameter("duration"));

        try {

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

            String getUrl = MAIN_SERVICE_URL + GET_SERVICE_URL + username;
            StudentResponse response = restTemplate.getForObject(getUrl, StudentResponse.class);

            if (HttpStatus.FOUND.equals(response.getStatus())) {

                String updateUrl = MAIN_SERVICE_URL + UPDATE_SERVICE_URL;
                restTemplate.put(updateUrl, beanObject);

                LOGGER.info("Updated Successfully..!");
                modelAndView.addObject("updateSuccessMessage", "Updated Successfully..!");
                modelAndView.setViewName("UserMenu");
            } 
            else {
                LOGGER.info(FAILURE_MESSAGE);
                modelAndView.addObject("updateFailureMessage", FAILURE_MESSAGE);
                modelAndView.setViewName("ViewAndUpdate");
            }

        } 
        catch (Exception e) {

            LOGGER.error("error:  " + e);
            LOGGER.info(FAILURE_MESSAGE);
            modelAndView.addObject("updateFailureMessage", FAILURE_MESSAGE);
            modelAndView.setViewName("ViewAndUpdate");
        }
        return modelAndView;
    }
}
