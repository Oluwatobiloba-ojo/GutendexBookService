package africa.semicolon.readingList.service;

import africa.semicolon.readingList.data.model.Book;
import africa.semicolon.readingList.data.model.GutendexBook;
import africa.semicolon.readingList.data.model.User;
import africa.semicolon.readingList.data.repository.ReadingListRepository;
import africa.semicolon.readingList.dtos.request.AddBookReadingListRequest;
import africa.semicolon.readingList.dtos.request.AddBookRequest;
import africa.semicolon.readingList.dtos.request.RegisterRequest;
import africa.semicolon.readingList.dtos.response.AddBookReadingListResponse;
import africa.semicolon.readingList.dtos.response.AddBookResponse;
import africa.semicolon.readingList.dtos.response.RegisterResponse;
import africa.semicolon.readingList.exception.BookNotFoundException;
import africa.semicolon.readingList.exception.UserDoesNotExistException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService implements UserService {
    @Autowired
    private ReadingListRepository reposoitory;
    @Autowired
    private BookService bookService;
    @Autowired
    private GutendexBookService gutendexBookService;

    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = modelMapper.map(request, User.class);
        System.out.println(user);
        User savedUser = reposoitory.save(user);
        RegisterResponse response = new RegisterResponse();
        response.setReadingListId(savedUser.getId());
        response.setMessage("Reading List Created for "+ request.getUsername());
        return response;
    }

    @Override
    public AddBookReadingListResponse addBooks(AddBookReadingListRequest request) throws BookNotFoundException {
        User user = findBy(request.getId());
        GutendexBook gutendexBook = gutendexBookService.fetchABook(request.getTitle());
        AddBookRequest request1 = modelMapper.map(gutendexBook, AddBookRequest.class);
        request1.setUser(user);
        AddBookResponse response = bookService.addBook(request1);
        AddBookReadingListResponse response1 = new AddBookReadingListResponse();
        response1.setBook(response.getBookAdded());
        response1.setMessage("Book added successfully");
        return response1;
    }

    @Override
    public List<Book> getBooks(Long id) {
        User user = findBy(id);
        return bookService.findBooksBelongingToUser(user);
    }

    @Override
    public User findBy(Long id) {
        return reposoitory.findById(id)
                .orElseThrow(()->  new UserDoesNotExistException("User does not exist"));
    }
}
