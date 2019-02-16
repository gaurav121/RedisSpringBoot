package com.demo.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "report_card")
@Entity
public class ReportCard {
    public static long  serialVersionUID= 1464417676226914623L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "subject_name", updatable = false)
    private String name;

    @Basic(optional = false)
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @Basic(optional = false)
    @Column(name = "updated_at", updatable = false)
    private Timestamp updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
