package africa.semicolon.readingList.service;

import africa.semicolon.readingList.data.model.Book;
import africa.semicolon.readingList.data.model.GutendexBook;
import africa.semicolon.readingList.dtos.response.BookResponse;
import africa.semicolon.readingList.exception.BookNotFoundException;

public interface GutendexBookService {

    BookResponse fetchBooks();

    GutendexBook fetchABook(String title) throws BookNotFoundException;
}
