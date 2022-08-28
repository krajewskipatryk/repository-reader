package com.github.repository.reader.reporeader.Github.Api.Exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GithubUserNotFoundControllerAdvice {
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ApiError> handleUserNotFoundFeign() {
        ResponseEntity<ApiError> responseEntity = new ResponseEntity<>(new ApiError("404 Not Found", "Github user not found!"), HttpStatus.NOT_FOUND);

        return responseEntity;
    }
}
