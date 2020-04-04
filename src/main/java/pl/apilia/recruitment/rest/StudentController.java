package pl.apilia.recruitment.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.apilia.recruitment.model.Student;
import pl.apilia.recruitment.repository.StudentRepository;

import java.util.List;

import static java.util.Objects.requireNonNull;

@RestController
@RequestMapping("/api/student")
public class StudentController {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentController(StudentRepository studentRepository) {
    this.studentRepository = requireNonNull(studentRepository);
  }

  @GetMapping(produces = "application/json")
  public ResponseEntity<List<Student>> getAllStudents() {
    List<Student> studentList = this.studentRepository.findAll();
    return ResponseEntity.ok(studentList);
  }

}
