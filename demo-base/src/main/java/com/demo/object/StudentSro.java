package com.demo.object;

import java.io.Serializable;
import java.util.List;

public class StudentSro implements Serializable {

    public static final long serialVersionUID= -4083830087440736688L;

    private Long rollNo;
    private String name;
    private String standard;
    private AddressSro address;
    private List<MarksSro> marksSros;

    public List<MarksSro> getMarksSros() {
        return marksSros;
    }
    public void setMarksSros(List<MarksSro> marksSros) {
        this.marksSros = marksSros;
    }

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
                ", address=" + address +
                '}';
    }
}
