package africa.semicolon.readingList.service;

import africa.semicolon.readingList.data.model.GutendexBook;
import africa.semicolon.readingList.dtos.response.BookResponse;
import africa.semicolon.readingList.exception.BookNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;


@Service
public class GutendexBookServiceImpl implements GutendexBookService{



    @Override
    public BookResponse fetchBooks() {
        String url = "https://gutendex.com/books";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BookResponse> response = restTemplate.getForEntity(URI.create(url), BookResponse.class);
        return response.getBody();
    }

    @Override
    public GutendexBook fetchABook(String title) throws BookNotFoundException {
        String url = "https://gutendex.com/books?search=";
        url += title;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<BookResponse> response = restTemplate.getForEntity(url, BookResponse.class);
        System.out.println(response.getBody().getResults().getFirst());
        return response.getBody().getResults().getFirst();
    }

    private GutendexBook findABook(List<GutendexBook> books, String title) throws BookNotFoundException {
       return books.stream()
                .filter((book) -> book.getTitle().equals(title))
               .findFirst()
               .orElseThrow(()-> new BookNotFoundException("Book not found"));
    }
}
