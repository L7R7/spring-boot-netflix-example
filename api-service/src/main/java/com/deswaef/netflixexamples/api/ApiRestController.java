package com.deswaef.netflixexamples.api;

import com.deswaef.netflixexamples.api.infrastructure.ApiException;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RequestMapping(value = "/")
@RestController
public class ApiRestController {

    @Value("${spring.application.version}")
    public String applicationVersion;


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HystrixRuntimeException.class)
    public String handleBadRequest(Exception ex) {
        return ex.getMessage();
    }

    @RequestMapping(method = GET)
    public String version() {
        throw new ApiException("failing");
    }

}
