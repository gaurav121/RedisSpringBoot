package com.demo.service.impl;

import com.demo.converters.IConvertorService;
import com.demo.entity.Address;
import com.demo.entity.ReportCard;
import com.demo.entity.Student;
import com.demo.entity.Subject;
import com.demo.object.AddressSro;
import com.demo.object.MarksSro;
import com.demo.object.StudentSro;
import com.demo.repository.*;
import com.demo.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service("studentServiceImpl")
@Repository
public class StudentServiceImpl implements IStudentService {

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private IConvertorService convertorService;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    private IRedisRepository redisRepository;

    @Autowired
    ReportCardRepository reportCardRepository;
    @Override
    public String addStudentDetails(StudentSro studentSro) {
        Student student=new Student();

        AddressSro addressSro=studentSro.getAddress();
        Address address=new Address();
        address.setCity(addressSro.getCity());
        address.setCountry(addressSro.getCountry());
        address.setState(addressSro.getState());
        address.setStreet(addressSro.getStreet());
        address.setStreet2(addressSro.getStreet2());
        address.setZipCode(addressSro.getZipCode());
        address.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        address.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        addressRepository.save(address);


        student.setName(studentSro.getName());
        student.setStandard(studentSro.getStandard());
        student.setRollNo(studentSro.getRollNo());
        student.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        student.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        student.setAddress(address);
        student=studentRepository.save(student);

        List<MarksSro> marksSros=studentSro.getMarksSros();
        ReportCard reportCard = new ReportCard();
        reportCard.setStudent(student);
        reportCard.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        reportCard.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        reportCardRepository.save(reportCard);

        List<Subject> subjects=new ArrayList<>();
        for(MarksSro marksro:marksSros){
            Subject subject=new Subject();
            subject.setMarksObtained(marksro.getMaxMarks());
            subject.setMarksObtained(marksro.getMarksObtained());
            subject.setMaxMarks(marksro.getMaxMarks());
            subject.setName(marksro.getSubject().getName());
            subject.setReportCard(reportCard);
            subjectRepository.save(subject);
            subjects.add(subject);
        }
        redisRepository.add(Student.serialVersionUID+"-"+student.getRollNo(),student);
        redisRepository.add(Student.serialVersionUID+"-"+student.getRollNo(),student);
        return String.valueOf(student.getRollNo());
    }

    @Override
    public StudentSro fetchStudentDetails(long rollNo) {
        StudentSro studentSro=null;
        Student student= (Student) redisRepository.find(Student.serialVersionUID+"-"+rollNo);
        if(student==null) {
            student = studentRepository.findStudentByrollNo(rollNo);
            redisRepository.add(Student.serialVersionUID+"-"+student.getRollNo(),student);
            studentSro = convertorService.getStudentSROFromStudent(student);
        }
        else {
            return convertorService.getStudentSROFromStudent(student);
        }
        return null;
    }

    @Override
    public List<StudentSro> fetchStudentDetails() {
        List<Student> students=studentRepository.findAll();
        List<StudentSro> studentSros = new ArrayList<>();

        for(Student student:students){
            StudentSro studentSro=convertorService.getStudentSROFromStudent(student);
            studentSros.add(studentSro);
        }
        return studentSros;

    }
}
