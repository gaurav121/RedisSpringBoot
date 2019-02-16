package com.demo.service.impl;

import com.demo.base.service.object.AddressSro;
import com.demo.base.service.object.StudentSro;
import com.demo.dao.entity.Address;
import com.demo.dao.entity.Student;
import com.demo.dao.repository.AddressRepository;
import com.demo.dao.repository.StudentRepository;
import com.demo.service.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service("studentServiceImpl")
@Repository
public class StudentServiceImpl implements IStudentService {

    private final static Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String addStudentDetails(StudentSro studentSro) {
        Student student=new Student();
        student.setName(studentSro.getName());
        student.setStandard(studentSro.getStandard());
        student.setRollNo(studentSro.getRollNo());
        student.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        student.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

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
        student.setAddress(address);
        addressRepository.save(address);
        student=studentRepository.save(student);
        return String.valueOf(student.getId());
    }

    @Override
    public StudentSro fetchStudentDetails(long rollNo) {
        return null;
    }
}
