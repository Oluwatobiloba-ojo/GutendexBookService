package africa.semicolon.readingList.service;

import africa.semicolon.readingList.data.model.Authors;
import africa.semicolon.readingList.dtos.request.AddBookRequest;
import africa.semicolon.readingList.dtos.response.AddBookResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testAddBook(){
        AddBookRequest addBookRequest = new AddBookRequest();
        addBookRequest.setAuthors(List.of(new Authors("Shelley, Mary Wollstonecraft","1899", "1851")));
        addBookRequest.setTitle("Frankenstein; Or, The Modern Prometheus");
        addBookRequest.setLanguages(List.of("en"));
        addBookRequest.setSubjects(List.of(
                "Frankenstein's monster (Fictitious character) -- Fiction", "Frankenstein, Victor (Fictitious character) -- Fiction", "Gothic fiction", "Horror tales", "Monsters -- Fiction"));
        addBookRequest.setBookshelves(List.of(
                "Gothic Fiction", "Movie Books", "Precursors of Science Fiction"));
        AddBookResponse response = bookService.addBook(addBookRequest);
        assertThat(response).isNotNull();
        assertThat(response.getBookAdded()).isNotNull();
        assertThat(response.getId()).isNotNull();
    }

}