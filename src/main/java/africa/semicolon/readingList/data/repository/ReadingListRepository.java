package africa.semicolon.readingList.data.repository;

import africa.semicolon.readingList.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReadingListRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
