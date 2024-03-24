package africa.semicolon.readingList.service;

import africa.semicolon.readingList.data.model.Book;
import africa.semicolon.readingList.data.model.User;
import africa.semicolon.readingList.dtos.request.AddBookRequest;
import africa.semicolon.readingList.dtos.response.AddBookResponse;

import java.util.List;

public interface BookService {

    AddBookResponse addBook(AddBookRequest addBookRequest);
    List<Book> findBooksBelongingToUser(User user);
}
