package africa.semicolon.readingList.data.repository;

import africa.semicolon.readingList.data.model.Authors;
import africa.semicolon.readingList.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Authors, Long> {
    List<Authors> findAuthorByBook(Book book);

}
