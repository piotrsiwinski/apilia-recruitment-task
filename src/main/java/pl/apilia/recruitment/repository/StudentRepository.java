package pl.apilia.recruitment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.apilia.recruitment.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
