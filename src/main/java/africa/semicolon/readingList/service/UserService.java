package africa.semicolon.readingList.service;

import africa.semicolon.readingList.data.model.User;
import africa.semicolon.readingList.dtos.request.AddBookReadingListRequest;
import africa.semicolon.readingList.dtos.request.LoginRequest;
import africa.semicolon.readingList.dtos.request.RegisterRequest;
import africa.semicolon.readingList.dtos.response.AddBookReadingListResponse;
import africa.semicolon.readingList.dtos.response.LoginResponse;
import africa.semicolon.readingList.dtos.response.ReadingBookResponse;
import africa.semicolon.readingList.dtos.response.RegisterResponse;
import africa.semicolon.readingList.exception.BookNotFoundException;
import africa.semicolon.readingList.exception.InvalidDetailException;

import java.util.List;

public interface UserService {


    RegisterResponse register(RegisterRequest request);
    AddBookReadingListResponse addBooks(AddBookReadingListRequest request) throws BookNotFoundException;
    List<ReadingBookResponse> getBooks(Long id);
    User findBy(Long id);
    LoginResponse login(LoginRequest request) throws InvalidDetailException;

}
