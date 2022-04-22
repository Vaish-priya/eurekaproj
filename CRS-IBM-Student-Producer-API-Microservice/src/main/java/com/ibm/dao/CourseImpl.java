package com.ibm.dao;
public class CourseImpl{}

//	import java.util.ArrayList;
//	import java.util.List;
//	import java.util.Map;
//
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.jdbc.core.JdbcTemplate;
//	import org.springframework.stereotype.Repository;
//	import org.springframework.transaction.annotation.Transactional;
//
//	import com.ibm.Bean.CourseB;
//	import com.ibm.consts.SQLMethods;
//
//	
//
//	@Repository
//	public class CourseImpl implements CourseDao{
//
//		@Autowired
//		private JdbcTemplate jdbcTemplate;
//
//		public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
//			this.jdbcTemplate = jdbcTemplate;
//		}
//
//
//		/**
//		 * Returns list of Courses from the test database. 
//		 * @return list of Courses
//		 * @param LIST_COURSE is an SQL Constant
//		 */
//		@SuppressWarnings("deprecation")
//		@Override
//		public List<CourseB> listCourses() {
//			// TODO Auto-generated method stub
//
//			String sql = SQLMethods.LIST_COURSE;			 
//			List<CourseB> list = new ArrayList<>();
//			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
//			for (Map row : rows) {
//				CourseB obj = new CourseB();
//				obj.setCourseId((int) row.get("CourseID"));
//				obj.setCourseName((String) row.get("CourseName"));
//				obj.setCourseFee((int) row.get("CourseFee")); 
//				list.add(obj);
//			}
//
//			return list;
//		}}