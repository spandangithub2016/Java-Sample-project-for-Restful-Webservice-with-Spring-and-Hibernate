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
public class Delete {

    private static final Logger LOGGER = LogManager.getLogger("Delete.class");

    private static final String MAIN_SERVICE_URL = "http://localhost:8085/"
    		+ "JavaAssignment9_StudentRepository_WS_WebService";
    
    private static final String GET_SERVICE_URL = "/student/get/";
    private static final String DELETE_SERVICE_URL = "/student/delete/";
    private static final String MESSAGE = "Delete";

    @Autowired
    private StudentBean bean;
    
    
    Delete()
    {
    	//  To fix sonar issue
    }

    
    @RequestMapping("/DeleteServlet")
    public ModelAndView delete(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        String uname = request.getParameter("username");
        bean.setUserName(uname);
        
        try {

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                    
            String getUrl = MAIN_SERVICE_URL + GET_SERVICE_URL + uname;
            StudentResponse response = restTemplate.getForObject(getUrl, StudentResponse.class);
            
            if(HttpStatus.FOUND.equals(response.getStatus()))
            {
  
              String deleteUrl = MAIN_SERVICE_URL + DELETE_SERVICE_URL + bean.getUserName();
              restTemplate.delete(deleteUrl, bean);
  
              LOGGER.info("Username Deleted");
              modelAndView.setViewName("AdminMenu");
            }
            else
            {
               
              LOGGER.info("Username Doesn't Exist");
              modelAndView.addObject("deleteFailureMessage", "Username Doesn't Exist");
              modelAndView.setViewName(MESSAGE);
            }

        } 
        catch (Exception e) {

            
            LOGGER.error("Error:  " + e);
            modelAndView.addObject("deleteFailureMessage", "Deletion Failed, Try again");
            modelAndView.setViewName(MESSAGE);
            
        }

        return modelAndView;
    }

    @RequestMapping("/DeleteJsp")
    public String delete() {
        return MESSAGE;
    }
}
