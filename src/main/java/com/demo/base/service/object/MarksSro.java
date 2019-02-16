package com.demo.base.service.object;

import java.io.Serializable;

public class MarksSro implements Serializable {

    public static final long serialVersionUID= -7958673014051201587L;

    private long maxMarks;
    private long marksObtained;
    private SubjectSro subject;


    public long getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(long maxMarks) {
        this.maxMarks = maxMarks;
    }

    public long getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(long marksObtained) {
        this.marksObtained = marksObtained;
    }

    public SubjectSro getSubject() {
        return subject;
    }

    public void setSubject(SubjectSro subject) {
        this.subject = subject;
    }
}
