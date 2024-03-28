package africa.semicolon.readingList.service;

import africa.semicolon.readingList.data.model.Authors;
import africa.semicolon.readingList.data.model.Book;
import africa.semicolon.readingList.dtos.request.AddAuthorRequest;
import africa.semicolon.readingList.dtos.response.AddAuthorResponse;

import java.util.List;

public interface AuthorService {

    AddAuthorResponse create(AddAuthorRequest request);
    AddAuthorResponse create(List<AddAuthorRequest> request);
    List<Authors> findAll();
    Authors findAuthorBy(Long id);
    List<Authors> findAuthorByBook(Book book);
}
