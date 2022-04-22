package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Student;


public class StudentMapper implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		  Student student = new Student();
		  student.setId(rs.getInt("id"));
		  student.setName(rs.getString("name"));
		  student.setEmail(rs.getString("email"));
		  student.setDept(rs.getString("dept"));
		  
	      return student;
		
	}

}