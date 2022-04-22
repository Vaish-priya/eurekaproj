package com.ibm.RestController;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.ibm.bean.Course;
// import com.ibm.bean.RegisteredCourse;
import com.ibm.bean.Student;
import com.ibm.dao.Studentdao;
import com.ibm.dao.StudentImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private Studentdao studentDAO;
    
    // @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.GET, value = "/student/{id}")
    // @ResponseBody
    // public ResponseEntity getStudent(@PathVariable("id") Long id) {
    //     Student student = studentDAO.get(id);
    //     if (student == null) {
    //         return new ResponseEntity("No Student found for ID " + id, HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity(student, HttpStatus.OK);
    // }

    // @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/post/students")
    // @ResponseBody
    // public ResponseEntity createStudent(@RequestBody Student student) {
    //     studentDAO.create(student);
    //     return new ResponseEntity(student, HttpStatus.OK);
    // }

    // @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.PUT, value = "/put/students/{id}")
    // @ResponseBody
    // public ResponseEntity updateStudent(@PathVariable("id") Long id,@RequestBody Student student) {
    //     Student p = studentDAO.update(id, student);
    //     if(null == student){
    //         return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity(p, HttpStatus.OK);
    // }

    // @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.DELETE, value = "/delete/students/{id}")
    // @ResponseBody
    // public ResponseEntity deleteStudent(@PathVariable Long id) {
    //    if(null == studentDAO.delete(id)){
    //         return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity(id, HttpStatus.OK);
    // }

    //=================================================================
    //register course
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/course/registrationStudent")
    @ResponseBody
    public ResponseEntity<Student> registerCourse(@RequestBody Student student) {
        studentDAO.register(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    // Drop course
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.DELETE, value = "/drop/students/course/{id}")
    @ResponseBody
    public ResponseEntity<Integer> deleteCourse(@PathVariable int id) {
        studentDAO.drop(id);
        return new ResponseEntity<Integer>(id, HttpStatus.OK);
    }
    

    //fees
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.GET, value = "/pay/students/fees/{id}")
    @ResponseBody
    public int payFees(@PathVariable int id) {
        return studentDAO.payFees(id);
        // return new ResponseEntity(x, HttpStatus.OK);
    }

    //get all registrations
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.GET, value ="/students/registrations")
    public ResponseEntity<List<Student>> getAllStudents() {
        return new ResponseEntity<List<Student>>(studentDAO.list(), HttpStatus.OK);
    }

    //view grades
   @RequestMapping("/students/grades/{id}/{id2}")
   public ResponseEntity<String> getStudentGrades(@PathVariable("id") int id, @PathVariable("id2") int id2) {
        String x="Student id:"+id+"\n"+"Course Grade:"+studentDAO.viewGrades(id,id2);
        return new ResponseEntity<String>(x, HttpStatus.OK);
   }
   
//  	@RequestMapping(method = RequestMethod.PUT,value = "/put/regstudentdb")
//  	@ResponseBody
//  	public ResponseEntity<String> createStudentr(@RequestParam("id") int id,
//  			@RequestParam("sname") String sname,@RequestParam("email") String email,@RequestParam("dob") String dept) {
//  		Student student;
//  		
//  		Student x=studentDAO.register(student);
////  		if(x==false) {
////  			return new ResponseEntity<String>("NOT FOUND",HttpStatus.NOT_FOUND);}
////  		else {
//  			return new ResponseEntity<String>("Student Registered Successfully. Your default password is: password. Please change your password after login.",HttpStatus.OK);}
//  	
//  	

    // add course
    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/course/add")
    @ResponseBody
    public ResponseEntity<Course> addCourse(@RequestBody Course Course) {
        studentDAO.addCourse(Course);
        return new ResponseEntity<Course>(Course, HttpStatus.OK);
    }

}
