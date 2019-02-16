package com.demo.controller;

import com.demo.base.service.object.AddressSro;
import com.demo.base.service.object.MarksSro;
import com.demo.base.service.object.StudentSro;
import com.demo.base.service.object.SubjectSro;
import com.demo.service.IStudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/student/") public class StudentController {

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private IStudentService studentService;

    @ApiOperation(value = "Fetch Student Info")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = StudentSro.class),
            @ApiResponse(code = 500, message = "Something went wrong", response = String.class)
    })
    @RequestMapping(value = "fetch_student/{rollNo}", method = RequestMethod.GET)
    public StudentSro fetchStudentDetails(@PathVariable("rollNo") long rollNo){
        LOGGER.info(String.format("Fetching Student details for student roll no : %d",rollNo));

        return studentService.fetchStudentDetails(rollNo);
    }

    @ApiOperation(value = "Fetch Student Info")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = StudentSro.class),
            @ApiResponse(code = 500, message = "Something went wrong", response = String.class)
    })
    @RequestMapping(value = "fetch_students", method = RequestMethod.GET)
    public List<StudentSro> fetchAllStudents(){
        LOGGER.info(String.format("Fetching all Student details"));

        return studentService.fetchStudentDetails();
    }


    @ApiOperation(value = "Add Student Info")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 500, message = "Something went wrong", response = String.class)
    })
    @RequestMapping(value = "add_student", method = RequestMethod.POST)
    public String addStudentDetails(@RequestBody StudentSro request){
        LOGGER.info(String.format("Adding new Student details"));
        String id=studentService.addStudentDetails(request);
        return String.valueOf(id);
    }

}
