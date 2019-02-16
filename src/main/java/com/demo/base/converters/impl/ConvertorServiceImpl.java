package com.demo.base.converters.impl;


import com.demo.base.converters.IConvertorService;
import com.demo.base.service.object.AddressSro;
import com.demo.base.service.object.MarksSro;
import com.demo.base.service.object.StudentSro;
import com.demo.base.service.object.SubjectSro;
import com.demo.dao.entity.Address;
import com.demo.dao.entity.ReportCard;
import com.demo.dao.entity.Student;
import com.demo.dao.entity.Subject;
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
        List<MarksSro> marks=new ArrayList<>();
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
