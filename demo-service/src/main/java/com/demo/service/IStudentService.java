package com.demo.service;

import com.demo.object.StudentSro;

import java.util.List;

public interface IStudentService {

    public String addStudentDetails(StudentSro studentSro);

    public StudentSro fetchStudentDetails(long rollNo);

    public List<StudentSro> fetchStudentDetails();
}
