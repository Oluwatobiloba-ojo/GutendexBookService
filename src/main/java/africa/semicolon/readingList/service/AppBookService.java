package africa.semicolon.readingList.service;

import africa.semicolon.readingList.data.model.Book;
import africa.semicolon.readingList.data.model.User;
import africa.semicolon.readingList.data.repository.BookRepository;
import africa.semicolon.readingList.dtos.request.AddAuthorRequest;
import africa.semicolon.readingList.dtos.request.AddBookRequest;
import africa.semicolon.readingList.dtos.response.AddBookResponse;
import africa.semicolon.readingList.dtos.response.ReadingBookResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppBookService implements BookService{
    @Autowired
    private BookRepository repository;
    @Autowired
    private AuthorService authorService;
    private final ModelMapper modelMapper = new ModelMapper();
    private final String IMAGE_KEY = "image/jpeg";
    private final String TEXT_KEY = "text/html";

    @Override
    public AddBookResponse addBook(AddBookRequest addBookRequest) {
       Book newBook =  modelMapper.map(addBookRequest, Book.class);
       newBook.setImage(addBookRequest.getFormats().get(IMAGE_KEY));
       newBook.setBook(addBookRequest.getFormats().get(TEXT_KEY));
        List<AddAuthorRequest> requests = getAddAuthorRequests(addBookRequest, newBook);
        authorService.create(requests);
        AddBookResponse response = new AddBookResponse();
        response.setBookAdded(newBook);
        response.setId(newBook.getId());
        return response;
    }

    private static List<AddAuthorRequest> getAddAuthorRequests(AddBookRequest addBookRequest, Book newBook) {
        return addBookRequest.getAuthors()
                .stream()
                .map(authors -> new AddAuthorRequest(authors, newBook))
                .toList();
    }


    @Override
    public List<ReadingBookResponse> findBooksBelongingToUser(User user) {
        List<Book> books = repository.findBooksByUser(user);
       return books.stream()
                .map(book -> new ReadingBookResponse(book, authorService.findAuthorByBook(book)))
                .toList();
    }

}
