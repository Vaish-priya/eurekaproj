package com.ibm.bean;

import java.io.Serializable;

public class Professor implements Serializable {
    private long id;
    private String name;
    private String email;
    private String Dept;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return Dept;
    }

    public void setDept(String Dept) {
        this.Dept = Dept;
    }

    
    public Professor(long id, String name, String email, String Dept) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.Dept = Dept;
    }

    public Professor(){
        
    }

}