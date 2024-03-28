package africa.semicolon.readingList.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class GutendexBook {
    private String title;
    private List<String> subjects;
    private List<String> bookshelves;
    private List<String> languages;
    private List<Authors> authors;
    private Map<String, String> formats;
}
