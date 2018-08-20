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
public class Login {

    private static final Logger LOGGER = LogManager.getLogger("Login.class");

    private static final String MAIN_SERVICE_URL = "http://localhost:8085/"
    		+ "JavaAssignment9_StudentRepository_WS_WebService";
    
    private static final String LOGIN_SERVICE_URL = "/student/login";

    @Autowired
    private StudentBean bean;
    
    Login()
    {
    	// To fix sonar issue
    }


    @RequestMapping("/LoginServlet")
    public ModelAndView login(HttpServletRequest request) {

        ModelAndView mv = new ModelAndView();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        bean.setUserName(username);
        bean.setPasword(password);

        if ("admin".equals(username) && "admin".equals(password)) {

            LOGGER.info("Admin login success");
            mv.setViewName("AdminMenu");

        } 
        else {

            try {

                RestTemplate rt = new RestTemplate();
                rt.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
                rt.getMessageConverters().add(new StringHttpMessageConverter());

                String loginUrl = MAIN_SERVICE_URL + LOGIN_SERVICE_URL;
                StudentResponse response = rt.postForObject(loginUrl, bean, StudentResponse.class);

                if (HttpStatus.FOUND.equals(response.getStatus())) {

                    LOGGER.info("User login success");
                    mv.setViewName("UserMenu");
                    
                } 
                else {

                    LOGGER.info("User login failed");
                    mv.setViewName("Login");
                }

            } 
            catch (Exception e) {
                LOGGER.error("error is:  " + e);

            }
        }
        return mv;
    }

    @RequestMapping("/LoginJsp")
    public String login() {
        return "Login";
    }
    
}
