package africa.semicolon.readingList.dtos.request;

import africa.semicolon.readingList.data.model.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class AddBookRequest {
    private String title;
    private List<Authors> authors;
    private List<String> subjects;
    private List<String> bookshelves;
    private List<String> languages;
    private User user;
}
