package com.stpl.trainee.assignment9.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.stpl.trainee.assignment9.bean.StudentBean;
import com.stpl.trainee.assignment9.bean.StudentRegister;

@Controller
public class View {

    private static final Logger LOGGER = LogManager.getLogger("View.class");

    private static final String MAIN_SERVICE_URL = "http://localhost:8085/"
    		+ "JavaAssignment9_StudentRepository_WS_WebService";
    
    private static final String VIEW_SERVICE_URL = "/student/view/";
    
    private static final String VIEW_MESSAGE = "ViewInput";

    @Autowired
    private StudentBean bean;
    
    public View() {
    	// To fix sonar issue
    }

    @RequestMapping("/ViewServlet")
    public ModelAndView view(HttpServletRequest request) {

        ModelAndView modelAndView = new ModelAndView();

        String username = request.getParameter("username");
        bean.setUserName(username);

        try {

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

            String viewUrl = MAIN_SERVICE_URL + VIEW_SERVICE_URL + username;
            StudentRegister responseBean = restTemplate.getForObject(viewUrl, StudentRegister.class);

            if (responseBean != null) {

                modelAndView.addObject("fullname", responseBean.getFullname());
                modelAndView.addObject("username", responseBean.getUsername());
                modelAndView.addObject("password", responseBean.getPasword());
                modelAndView.addObject("address", responseBean.getAddress());
                modelAndView.addObject("dob", responseBean.getDob());
                modelAndView.addObject("gender", responseBean.getGender());
                modelAndView.addObject("contact", responseBean.getContact());
                modelAndView.addObject("email", responseBean.getEmail());
                modelAndView.addObject("city", responseBean.getCity());
                modelAndView.addObject("state", responseBean.getState());
                modelAndView.addObject("country", responseBean.getCountry());
                modelAndView.addObject("coursename", responseBean.getCoursename());
                modelAndView.addObject("courseid", responseBean.getCourseid());
                modelAndView.addObject("fees", responseBean.getFees());
                modelAndView.addObject("duration", responseBean.getDuration());

                modelAndView.setViewName("ViewAndUpdate");

            } 
            else {

                LOGGER.info("Invalid username, record not found..!");
                modelAndView.setViewName(VIEW_MESSAGE);
            }

        } 
        catch (Exception e) {

            LOGGER.error("Error:  " + e);
            modelAndView.addObject("viewFailureMessage", "Sorry error occured, please try again..!");
            modelAndView.setViewName(VIEW_MESSAGE);
        }
        return modelAndView;
    }

    @RequestMapping("/ViewInputJsp")
    public String view() {
        return VIEW_MESSAGE;
    }
    
}
