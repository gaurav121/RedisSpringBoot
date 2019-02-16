package com.demo.base.service.object;

import java.io.Serializable;
import java.util.List;

public class StudentSro implements Serializable {

    public static final long serialVersionUID= -4083830087440736688L;

    private Long rollNo;
    private String name;
    private String standard;
    private List<String> subjects;
    private AddressSro address;

    public Long getRollNo() {
        return rollNo;
    }

    public void setRollNo(Long rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public AddressSro getAddress() {
        return address;
    }

    public void setAddress(AddressSro address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentSro{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", standard='" + standard + '\'' +
                ", subjects=" + subjects +
                ", address=" + address +
                '}';
    }
}
