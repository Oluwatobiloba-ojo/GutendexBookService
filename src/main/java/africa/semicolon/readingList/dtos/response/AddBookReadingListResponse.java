package africa.semicolon.readingList.dtos.response;

import africa.semicolon.readingList.data.model.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBookReadingListResponse {
    private String message;
    private Book book;
}
