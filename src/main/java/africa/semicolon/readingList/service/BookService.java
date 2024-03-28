package africa.semicolon.readingList.service;

import africa.semicolon.readingList.data.model.User;
import africa.semicolon.readingList.dtos.request.AddBookRequest;
import africa.semicolon.readingList.dtos.response.AddBookResponse;
import africa.semicolon.readingList.dtos.response.ReadingBookResponse;

import java.util.List;

public interface BookService {

    AddBookResponse addBook(AddBookRequest addBookRequest);
    List<ReadingBookResponse> findBooksBelongingToUser(User user);
}
