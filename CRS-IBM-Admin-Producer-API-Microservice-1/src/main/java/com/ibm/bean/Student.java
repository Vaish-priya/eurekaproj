package com.ibm.bean;
import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    private int id;
    private String name;
    private String email;
    public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	private String dept;
    private int mainCourse;
    private int electiveCourse;
    public int getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(int mainCourse) {
        this.mainCourse = mainCourse;
    }

    public int getElectiveCourse() {
        return electiveCourse;
    }

    public void setElectiveCourse(int electiveCourse) {
        this.electiveCourse = electiveCourse;
    }

    private List<String> courses;

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
//    
    public Student(int id, String name, String email, String dept) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.dept = dept;
    }

    public Student(){
        
    }
}