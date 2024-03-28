package africa.semicolon.readingList.service;

import africa.semicolon.readingList.data.model.GutendexBook;
import africa.semicolon.readingList.dtos.response.BookResponse;
import africa.semicolon.readingList.exception.BookNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class GutendexUserServiceTest {

    @Autowired
    private GutendexBookService gutendexBookService;

    @Test
    public void testForBooks(){
        BookResponse bookResponse = gutendexBookService.fetchBooks();
        assertThat(bookResponse).isNotNull();
        assertThat(bookResponse.getResults()).isNotNull();
        assertThat(bookResponse.getResults().size()).isEqualTo(32);
    }

    @Test
    public void testBookFormat() throws BookNotFoundException {
        GutendexBook book = gutendexBookService.fetchABook("The Adventures of Roderick Random");
    }

    @Test
    public void testForABook(){
        GutendexBook book = new GutendexBook();
        try {
            book = gutendexBookService.fetchABook("Romeo and Juliet");
        }catch (BookNotFoundException exception){
            System.out.println(exception.getMessage());
        }
        assertThat(book).isNotNull();
        assertThat(book.getTitle()).isEqualTo("Romeo and Juliet");
    }

    @Test
    public void testForBookNotExist(){
        assertThrows(BookNotFoundException.class, ()-> gutendexBookService.fetchABook("Wrong title"));
    }

}