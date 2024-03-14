package bootcamp.crudjpa.repository;

import bootcamp.crudjpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {



}
