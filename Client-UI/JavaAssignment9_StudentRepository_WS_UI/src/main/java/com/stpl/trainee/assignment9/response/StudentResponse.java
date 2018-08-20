package com.stpl.trainee.assignment9.response;

import org.springframework.http.HttpStatus;


public class StudentResponse {
    
    private HttpStatus status;
    private String result;
    
    
    public HttpStatus getStatus() {
        return status;
    }
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
   

}
