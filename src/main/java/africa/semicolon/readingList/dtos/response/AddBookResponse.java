package africa.semicolon.readingList.dtos.response;

import africa.semicolon.readingList.data.model.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBookResponse {
    private Long id;
    private Book bookAdded;
}
