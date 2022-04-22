package com.ibm.dao;

import java.util.List;

import com.ibm.bean.Admin;
import com.ibm.bean.Professor;
import com.ibm.bean.Student;

public interface Admindao {
    //Admin management
    public List<Admin> list();
    public Admin create(Admin admin);
    public Admin update(Long id, Admin admin);
    public Long delete(Long id);

    //Student management
    public List<Student> listStudents();
    public void deleteStudent(Integer id);

    //Professor management
    public Professor addProfessor(Professor professor);
    public void deleteProfessor(Integer id);
    public  boolean approveStudent(int sid);

}