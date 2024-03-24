package africa.semicolon.readingList.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class GutendexBook {
    private String title;
    private List<String> subjects;
    private List<String> bookshelves;
    private List<String> languages;
    private List<Authors> authors;
}
