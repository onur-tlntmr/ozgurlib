package com.example.OzgurLib.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
@Aspect
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");


    /*
    *
    * Login user was printed
    *
    * */

    @AfterReturning(pointcut = "execution(* org.springframework.security.authentication.AuthenticationManager.authenticate(..))"
            , returning = "result")
    public void after(JoinPoint joinPoint, Object result) throws Throwable {

        StringBuilder stringBuilder = new StringBuilder();


        String dateStr = simpleDateFormat.format(new Date());

        stringBuilder.append(dateStr);
        stringBuilder.append("\t");
        stringBuilder.append(((Authentication) result).getName());
        stringBuilder.append(" has been logged !");

        logger.info(stringBuilder.toString());
    }


}
