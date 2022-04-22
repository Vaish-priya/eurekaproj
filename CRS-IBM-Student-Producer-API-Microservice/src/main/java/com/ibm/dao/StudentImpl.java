package com.ibm.dao;

import java.util.ArrayList;
import java.util.List;

import com.ibm.bean.Catalog;
import com.ibm.bean.Course;
import com.ibm.bean.RegisteredCourse;
import com.ibm.bean.Student;
import com.ibm.mapper.CatalogMapper;
import com.ibm.mapper.RegisteredCourseMapper;
import com.ibm.mapper.StudentMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class StudentImpl implements Studentdao {

   public static List<Student> registers;
   {
       registers = new ArrayList<Student>();
       registers.add(new Student(1,"name1","email@amil.com","CSE"));
       
   }
    // List<ArrayList> students = new ArrayList<>();
    // {
    //     //student id,courseid, grades
    //     new ArrayList(Arrays.asList(1,1,"A+"));
    //     new ArrayList(Arrays.asList(2,2,"B+"));
    // }
    private static List<Student> students;
	{
		students = new ArrayList<Student>();
		students.add(new Student(1, "Ram", "Doe@nk.com", "CSE"));
	}

    private static List<Catalog> courses;
    {
        courses = new ArrayList<Catalog>();
        // courses.add(new Course(Arrays.asList(1,"course1",1000,10,"prof1")));
        courses.add(new Catalog(1, "course1", 100, 10, "stud1"));
    }

    public static List<RegisteredCourse> regCourse;
    {
    	//cid,sid,grade
    }

//     public Student register(Student student) {
// //		student.setId(System.currentTimeMillis());
// 		registrations.add(student);
// 		return student;
// 	}

//     @Override
//     public void drop(int id) {
//         // TODO Auto-generated method stub
//         for(Student c:registrations){
//             // int maxSeats =10;
//             if(c.getId()==id){
//                 registrations.remove(c);
                
//             }
            
//             else System.out.println("Error");
//         }
        
//     }

//     @Override
//     public String viewGrades(int id,int stdId) {
//         // TODO Auto-generated method stub
//         for(RegisteredCourse c:regCourse){
//             if(c.getCourseId()==id && c.getStudentId()==stdId){
//                 // System.out.println("Grades: "+c.get(2));
//                  String s = "Grades for courseId"+c.getCourseId()+": "+c.getGrade();
//                  return s;
//             }
//             // else System.out.println("Error");
//             else return "Error";
//         }
//         return null;
        
//     }

//     @Override
//     public int payFees(int id) {
//         // TODO Auto-generated method stub
//         for(Course c:courses){
//             if(c.getCourseId()==id ){
//                 return (c.getFees());
//             }

//         }
//         return 0;
//     }

    
//     @Override
//     public List list() {
//         // TODO Auto-generated method stub
//         return registrations;
        
//     }

   Logger logger = LoggerFactory.getLogger(StudentImpl.class);

   @Autowired
   private JdbcTemplate jdbcTemplateObject;

   @Override
    @Transactional
    public Student register(Student student) {
        // Register student in the database
        
        
        String SQL = "insert into student (id, name, email, dept) values (?, ?, ?, ?)";
            
        jdbcTemplateObject.update(SQL, new Object[]{student.getId(), student.getName(), student.getEmail(), student.getDept()});
        System.out.println("Created Record Name with studentId = " + student.getId());
    
        return student;
        
    }

    
    @Override
    public void addCourse(Course course) {
        // add course into students profile
        String SQL = "insert into course (studentId, courseId) values (?, ?)";
        jdbcTemplateObject.update(SQL, new Object[]{course.getStudentId(), course.getCourseId()});
        System.out.println("Created Record Name with CourseId = " + course.getCourseId());

        
    }

//    @Override
//    public int payFees(Integer id) {
//        // Pay fees for course
//        
//        String SQL = "select * from course where id = ?";
//            Catalog course = jdbcTemplateObject.queryForObject(SQL, 
//                            new Object[]{id}, new CatalogMapper());
//            logger.debug("value", jdbcTemplateObject.queryForObject(SQL, 
//                            new Object[]{id}, new CatalogMapper()));;
//            logger.debug("value of emp-->" +course.toString());
//            return course.getFees();
//           
//    }

    @Override
    public String viewGrades(Integer id, Integer stdId) {
        // view grades for course
        String SQL = "select * from registerations where course_id = ? and student_id = ?";
            RegisteredCourse course = jdbcTemplateObject.queryForObject(SQL, 
                            new Object[]{id,stdId}, new RegisteredCourseMapper());
            
            logger.debug("value", jdbcTemplateObject.queryForObject(SQL, 
                            new Object[]{id,stdId}, new RegisteredCourseMapper()));;
            logger.debug("value of fees-->" +course.toString());
            return course.getGrade();
          
    }

    @Override
    @Transactional
    public List<Student>list() {
        // list all students
            String SQL = "select * from student";
            List <Student> students = jdbcTemplateObject.query(SQL, 
                                    new StudentMapper());
                    logger.debug("in debug");
            return students;
    }

    
            
    @Override
    public void drop(Integer id) {
        // TODO Auto-generated method stub
        
            String SQL = "delete from student where id = ?";
            jdbcTemplateObject.update(SQL, id);
            System.out.println("Deleted Record with ID = " + id );
            return;
    }


	@Override
	public int payFees(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}


    // @Override
    // public void update(Integer id, Integer age) {
    //     // TODO Auto-generated method stub
    //         String SQL = "update employee set age = ? where id = ?";
    //         jdbcTemplateObject.update(SQL, age, id);
    //         System.out.println("Updated Record with ID = " + id );
    //         return;
    // }

    // @Override
    // @Transactional
    // public int payFees(Integer id) {
    //     // TODO Auto-generated method stub
    //         String SQL = "select fees from course where id = ?";
    //         int fees = jdbcTemplateObject.query(SQL,new StudentMapper(),id);
    //         System.out.println("Fees for courseId"+id+": "+fees);
    //         return fees;
    // }






    

}