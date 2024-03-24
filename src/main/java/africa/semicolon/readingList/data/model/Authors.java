package africa.semicolon.readingList.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Authors {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String birth_year;
    private String death_year;
    @ManyToOne(cascade = {PERSIST, MERGE})
    private Book book;

    public Authors(String name, String birth_year, String death_year){
        this.name = name;
        this.birth_year = birth_year;
        this.death_year = death_year;
    }
}
