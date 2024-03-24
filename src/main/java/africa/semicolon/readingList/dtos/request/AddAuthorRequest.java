package africa.semicolon.readingList.dtos.request;

import africa.semicolon.readingList.data.model.Authors;
import africa.semicolon.readingList.data.model.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AddAuthorRequest {
    private String name;
    private String birth_year;
    private String death_year;
    private Long bookId;
    private Book book;

    public AddAuthorRequest(Authors authors, Book book) {
        this.birth_year = authors.getBirth_year();
        this.name = authors.getName();
        this.death_year = authors.getDeath_year();
        this.book = book;
    }
}
