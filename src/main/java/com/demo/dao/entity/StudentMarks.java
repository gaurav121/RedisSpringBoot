package com.demo.dao.entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "student_marks")
@Entity
public class StudentMarks implements Serializable {

    public static long  serialVersionUID= 1464417676226914623L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "student_id")
    private Student student;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
