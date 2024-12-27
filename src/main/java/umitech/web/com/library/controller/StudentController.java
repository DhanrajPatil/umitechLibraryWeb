package umitech.web.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umitech.web.com.library.dto.CreateStudentRequest;
import umitech.web.com.library.dto.CreateStudentResponse;
import umitech.web.com.library.dto.UpdateStudentRequest;
import umitech.web.com.library.model.Student;
import umitech.web.com.library.service.StudentService;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping()
    public CreateStudentResponse createStudent(@RequestBody @Valid CreateStudentRequest createStudReq){
        return service.create(createStudReq);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return service.get(id);
    }

    @DeleteMapping()
    public Student deleteStudent(@RequestParam("id") Integer studentId) {
        return service.deleteStud(studentId);
    }

    @PutMapping("{id}")
    public Student updateStudent(@PathVariable("id") int studentId, @RequestBody @Valid UpdateStudentRequest stud) {
        return service.updateStud(studentId, stud);
    }
}
