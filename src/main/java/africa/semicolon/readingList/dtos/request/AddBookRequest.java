package africa.semicolon.readingList.dtos.request;

import africa.semicolon.readingList.data.model.Authors;
import africa.semicolon.readingList.data.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class AddBookRequest {
    private String title;
    private List<Authors> authors;
    private List<String> subjects;
    private List<String> bookshelves;
    private List<String> languages;
    private Map<String, String> formats;
    private User user;
}
