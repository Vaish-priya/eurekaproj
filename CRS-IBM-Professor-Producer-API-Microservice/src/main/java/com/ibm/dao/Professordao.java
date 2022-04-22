package com.ibm.dao;

import java.util.List;

import com.ibm.bean.Professor;
import com.ibm.bean.RegisteredCourse;

public interface Professordao {

		public boolean Login(int id, String pwd);
		public List viewStudents(int cid);
		public boolean Grades(int sid,int cid, String grade);
		RegisteredCourse grade(RegisteredCourse course);
		List <Professor> list();
	

}
