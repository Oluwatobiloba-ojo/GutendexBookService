package africa.semicolon.readingList.dtos.response;

import africa.semicolon.readingList.data.model.Authors;
import africa.semicolon.readingList.data.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
@Setter
@Getter
public class ReadingBookResponse {
    private String title;
    private List<String> subjects;
    private List<String> bookshelves;
    private List<String> languages;
    private List<Authors> authors;
    private HashMap<String, String> formats;

    public ReadingBookResponse(Book book, List<Authors> authorByBook) {
        this.title = book.getTitle();
        this.bookshelves = book.getBookshelves();
        this.subjects = book.getSubjects();
        this.languages = book.getLanguages();
        this.authors = authorByBook;
    }
}
