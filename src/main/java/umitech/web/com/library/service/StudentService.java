package umitech.web.com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umitech.web.com.library.dto.CreateStudentRequest;
import umitech.web.com.library.dto.CreateStudentResponse;
import umitech.web.com.library.dto.UpdateStudentRequest;
import umitech.web.com.library.model.Student;
import umitech.web.com.library.repository.StudentRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    StudentRepository studRepo;

    public CreateStudentResponse create(CreateStudentRequest req) {
        CreateStudentResponse createStudRes = null;
        Student s = req.to();
        Student stud = studRepo.findByEmail(s.getEmail());
        if(stud == null) {
            stud = studRepo.save(s);
            createStudRes = new CreateStudentResponse("Success", "Student Created Successfully", stud);
        } else {
            createStudRes = new CreateStudentResponse("Fail", "Student Already Present with emailId " + s.getEmail(), stud);
        }
        return createStudRes;
    }

    public Student get(Integer id) {
        return studRepo.findById(id).orElse(null);
    }

    public Student deleteStud(Integer studId) {
        Student stud = studRepo.findById(studId).orElse(null);
        studRepo.deleteById(studId);
        return stud;
    }

    public Student updateStud(int id, UpdateStudentRequest stud) {
        Map<Integer, Integer> sh = new HashMap<>();
        return null; //studRepo.save(stud);
    }
}
