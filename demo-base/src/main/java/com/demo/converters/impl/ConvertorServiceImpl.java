package com.demo.converters.impl;


import com.demo.converters.IConvertorService;
import com.demo.entity.Address;
import com.demo.entity.ReportCard;
import com.demo.entity.Student;
import com.demo.entity.Subject;
import com.demo.object.AddressSro;
import com.demo.object.MarksSro;
import com.demo.object.StudentSro;
import com.demo.object.SubjectSro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("convertorServiceImpm")
public class ConvertorServiceImpl implements IConvertorService {

    @Override
    public StudentSro getStudentSROFromStudent(Student student) {
        if(student==null) return null;
        StudentSro studentSro=new StudentSro();
        studentSro.setRollNo(student.getRollNo());
        studentSro.setAddress(getAddressSROfromAddress(student.getAddress()));
        studentSro.setMarksSros(getMarksSROfromReportCard(student.getReportCard()));
        studentSro.setStandard(student.getStandard());
        studentSro.setName(student.getName());
        return studentSro;
    }

    @Override
    public Student getStudentFromStudentSRO(StudentSro studentSro) {
        return null;
    }

    @Override
    public Address getAddressfromAddressSRO(AddressSro addressSro) {
        return null;
    }

    @Override
    public AddressSro getAddressSROfromAddress(Address address) {
        if(address==null) return null;
        AddressSro addressSro=new AddressSro();
        addressSro.setCity(address.getCity());
        addressSro.setCountry(address.getCountry());
        addressSro.setState(address.getState());
        addressSro.setStreet(address.getStreet());
        addressSro.setStreet2(address.getStreet2());
        addressSro.setZipCode(address.getZipCode());
        return addressSro;
    }

    @Override
    public Subject getSubjectFromSubjectSRO(Subject subject) {
        return null;
    }

    @Override
    public SubjectSro getSubjectSROFromSubject(Subject subject) {
        if(subject==null)return null;

        SubjectSro subjectSro=new SubjectSro();
        subjectSro.setName(subject.getName());
    return subjectSro;
    }

    @Override
    public List<MarksSro> getMarksSROfromReportCard(ReportCard reportCard) {
        if(reportCard==null) return null;
        List<MarksSro> marks=new ArrayList<MarksSro>();
        List<Subject> subjects=reportCard.getSubject();

        for (Subject subject:subjects){

            SubjectSro subjectSro=getSubjectSROFromSubject(subject);
            MarksSro mark=new MarksSro();
            mark.setSubject(subjectSro);
            mark.setMarksObtained(subject.getMarksObtained());
            mark.setMaxMarks(subject.getMaxMarks());
            marks.add(mark);
        }
        return marks;
    }

    @Override
    public ReportCard getReportCardFromMarksSRO(List<MarksSro> marksSros) {
        return null;
    }
}
