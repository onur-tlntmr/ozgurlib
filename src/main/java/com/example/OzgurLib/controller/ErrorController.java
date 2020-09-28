package com.example.OzgurLib.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if(status != null){
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value())
                return "errors/error-500";


            if(statusCode == HttpStatus.NOT_FOUND.value())
                return "errors/error-404";

        }
        return "errors/error-500";
    }

}
