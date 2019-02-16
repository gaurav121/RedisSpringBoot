package com.demo.base.converters;

import com.demo.base.service.object.AddressSro;
import com.demo.base.service.object.MarksSro;
import com.demo.base.service.object.StudentSro;
import com.demo.base.service.object.SubjectSro;
import com.demo.dao.entity.Address;
import com.demo.dao.entity.ReportCard;
import com.demo.dao.entity.Student;
import com.demo.dao.entity.Subject;

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
