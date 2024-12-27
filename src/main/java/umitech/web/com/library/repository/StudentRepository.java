package umitech.web.com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umitech.web.com.library.model.Author;
import umitech.web.com.library.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student findByEmail(String email);
}
