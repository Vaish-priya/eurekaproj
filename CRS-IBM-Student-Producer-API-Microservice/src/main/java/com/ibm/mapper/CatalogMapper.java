package com.ibm.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.ibm.bean.Catalog;
// import com.ibm.bean.Course;


public class CatalogMapper implements RowMapper<Catalog>{

	@Override
	public Catalog mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
            Catalog course = new Catalog();
            course.setCourseId(rs.getInt("id"));
            course.setCourseName(rs.getString("name"));
            course.setFees(rs.getInt("fees"));
            course.setProf(rs.getString("professor"));
            return course;
    }

}