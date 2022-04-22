package com.ibm.dao;

import java.util.List;

import com.ibm.bean.Course;
public class Coursedao {

	public interface CourseDAO {

		List<Course> listCourses();

	}
}
