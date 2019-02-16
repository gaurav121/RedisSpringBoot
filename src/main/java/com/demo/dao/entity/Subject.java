package com.demo.dao.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "subject")
@Entity
public class Subject {

    public static long  serialVersionUID= 6318692382721684833L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "marks_obtained", updatable = false)
    private Long marksObtained;

    @Column(name = "max_marks", updatable = false)
    private Long maxMarks;


    @Basic(optional = false)
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    @Basic(optional = false)
    @Column(name = "updated_at", updatable = false)
    private Timestamp updatedAt;

    @ManyToOne(cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "report_card_id", referencedColumnName = "id")
    private ReportCard reportCard;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
    public Long getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(Long marksObtained) {
        this.marksObtained = marksObtained;
    }

    public Long getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(Long maxMarks) {
        this.maxMarks = maxMarks;
    }

    public ReportCard getReportCard() {
        return reportCard;
    }

    public void setReportCard(ReportCard reportCard) {
        this.reportCard = reportCard;
    }
}
