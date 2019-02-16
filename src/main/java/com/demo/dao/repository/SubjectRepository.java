package com.demo.dao.repository;

import com.demo.dao.entity.Address;
import com.demo.dao.entity.Student;
import com.demo.dao.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
