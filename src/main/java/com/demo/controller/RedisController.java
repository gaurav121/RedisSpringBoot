package com.demo.controller;

import com.demo.base.service.object.StudentSro;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/v1/student/") public class RedisController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RedisController.class);

    @ApiOperation(value = "Fetch Student Info")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = StudentSro.class),
            @ApiResponse(code = 500, message = "Something went wrong", response = String.class)
    })
    @RequestMapping(value = "fetch_student/{rollNo}", method = RequestMethod.GET)
    public StudentSro fetchStudentDetails(@PathVariable("rollNo") long rollNo){
        LOGGER.info(String.format("Fetching Student details for student roll no : %d",rollNo));
        return new StudentSro();
    }

    @ApiOperation(value = "Add Student Info")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Something went wrong", response = String.class)
    })
    @RequestMapping(value = "add_student", method = RequestMethod.POST)
    public String addStudentDetails(@RequestBody StudentSro request){
        LOGGER.info(String.format("Adding new Student details"));
        return String.valueOf(HttpStatus.OK);
    }

}