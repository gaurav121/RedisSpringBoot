package com.demo.converters;


import com.demo.entity.Address;
import com.demo.entity.ReportCard;
import com.demo.entity.Student;
import com.demo.entity.Subject;
import com.demo.object.AddressSro;
import com.demo.object.MarksSro;
import com.demo.object.StudentSro;
import com.demo.object.SubjectSro;
import java.util.List;

public interface IConvertorService {

    StudentSro getStudentSROFromStudent(Student student);
    Student getStudentFromStudentSRO(StudentSro studentSro);

    Address getAddressfromAddressSRO(AddressSro addressSro);
    AddressSro getAddressSROfromAddress(Address address);

    Subject getSubjectFromSubjectSRO(Subject subject);
    SubjectSro getSubjectSROFromSubject(Subject subject);

    List<MarksSro> getMarksSROfromReportCard(ReportCard reportCard);
    ReportCard getReportCardFromMarksSRO(List<MarksSro> marksSros);
}
