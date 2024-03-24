package africa.semicolon.readingList.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    @ManyToOne(cascade = {MERGE})
    private User user;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> subjects;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> bookshelves;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> languages;
}
