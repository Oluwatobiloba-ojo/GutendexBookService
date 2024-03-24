package africa.semicolon.readingList.dtos.response;

import africa.semicolon.readingList.data.model.Book;
import africa.semicolon.readingList.data.model.GutendexBook;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@ToString
@Setter
@Getter
public class BookResponse {
    private String next;
    private Long count;
    private String previous;
    private List<GutendexBook> results;
}
