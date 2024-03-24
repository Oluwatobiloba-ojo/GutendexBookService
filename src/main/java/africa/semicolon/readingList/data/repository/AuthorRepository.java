package africa.semicolon.readingList.data.repository;

import africa.semicolon.readingList.data.model.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Authors, Long> {
}
