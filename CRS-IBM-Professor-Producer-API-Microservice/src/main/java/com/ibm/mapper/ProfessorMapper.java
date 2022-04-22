package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Professor;

public class ProfessorMapper implements RowMapper<Professor>{

	@Override
	public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		  Professor professor = new Professor();
		  professor.setId(rs.getInt("id"));
		  professor.setName(rs.getString("name"));
		  professor.setEmail(rs.getString("email"));
		  professor.setDept(rs.getString("mobile"));
		  
	      return professor;
		
	}

}