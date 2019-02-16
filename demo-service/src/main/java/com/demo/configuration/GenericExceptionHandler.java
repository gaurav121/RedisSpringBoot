package com.demo.configuration;


import com.demo.exception.StudentNotFoundException;
import com.demo.object.response.BaseResponse;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;


@RestController
@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler{

    private ResponseEntity<BaseResponse> generateErrorresponse(String message, HttpStatus responseStatus, String errorCode) {
        BaseResponse baseResponse = new BaseResponse();
        BaseResponse.Response response=baseResponse.new Response();
        response.setErrorCode(errorCode);
        response.setHttpStatus(responseStatus);
        response.setMessage(message);
        baseResponse.setResponse(response);
        return new ResponseEntity(baseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    ResponseEntity<?> handleStudentNotFoundException(HttpServletRequest request, Throwable ex) {
        return generateErrorresponse(((StudentNotFoundException)ex).getMessage(),HttpStatus.NOT_FOUND , ((StudentNotFoundException)ex).getCode());
    }

}
