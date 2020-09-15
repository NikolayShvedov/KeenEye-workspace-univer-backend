package dev.vorstu.repositories;
import org.springframework.data.repository.CrudRepository;

import dev.vorstu.dto.Student;;

/**
 * Repository interface for {@link Student} class.
 */

public interface StudentRepository extends CrudRepository<Student, Long> {
}

