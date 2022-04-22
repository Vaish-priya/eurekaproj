package com.ibm.RestController;

import java.util.List;

import javax.ws.rs.core.MediaType;
import com.ibm.bean.Professor;
import com.ibm.bean.RegisteredCourse;
import com.ibm.dao.Professordao;

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
public class ProfessorController {
    @Autowired
    private Professordao professorDAO;

    @RequestMapping("/professors")
    public ResponseEntity<List<Professor>> getAllProfessors() {
        return new ResponseEntity<>(professorDAO.list(), HttpStatus.OK);
    }

//     @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.GET, value = "/professor/{id}")
//     @ResponseBody
//     public ResponseEntity getProfessor(@PathVariable("id") Long id) {
//         Professor professor = professorDAO.get(id);
//         if (professor == null) {
//             return new ResponseEntity("No Professor found for ID " + id, HttpStatus.NOT_FOUND);
//         }
//         return new ResponseEntity(professor, HttpStatus.OK);
//     }

    @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.POST, value = "/post/students/grades")
    @ResponseBody
    public ResponseEntity<RegisteredCourse> createProfessor(@RequestBody RegisteredCourse registeredCourse) {
        professorDAO.grade(registeredCourse);
        return new ResponseEntity<>(registeredCourse, HttpStatus.OK);
    }
	@RequestMapping(method = RequestMethod.GET,value = "/plogin")
	@ResponseBody
	public ResponseEntity getProfessors(@RequestParam("id") int id,@RequestParam("pwd") String pwd) {

		boolean Professor = professorDAO.Login(id, pwd);
		if (Professor == false) {
			return new ResponseEntity("NOT FOUND", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity("Login Successful!", HttpStatus.OK);

	}

//     @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.PUT, value = "/put/professors/{id}")
//     @ResponseBody
//     public ResponseEntity updateProfessor(@PathVariable("id") Long id,@RequestBody Professor professor) {
//         Professor p = professorDAO.update(id, professor);
//         if(null == professor){
//             return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
//         }
//         return new ResponseEntity(p, HttpStatus.OK);
//     }

    // @RequestMapping(produces = MediaType.APPLICATION_JSON,method = RequestMethod.DELETE, value = "/delete/professors/{id}")
    // @ResponseBody
    // public ResponseEntity deleteProfessor(@PathVariable Long id) {
    //    if(null == professorDAO.delete(id)){
    //         return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
    //     }
    //     return new ResponseEntity(id, HttpStatus.OK);
    // }

}