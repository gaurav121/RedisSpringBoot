package com.demo.object;

import java.io.Serializable;

public class SubjectSro implements Serializable {

    public static final long serialVersionUID= -7958673014051201587L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
