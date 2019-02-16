package com.demo.service;

import com.demo.base.service.object.StudentSro;

public interface IStudentService {

    public String addStudentDetails(StudentSro studentSro);

    public StudentSro fetchStudentDetails(long rollNo);
}
