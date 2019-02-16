package com.demo.dao.entity;

import javax.persistence.*;

@Table(name = "subject")
@Entity
public class Subject {
    public static long  serialVersionUID= 1464417676226914623L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
