package africa.semicolon.readingList.service;

import africa.semicolon.readingList.data.model.GutendexBook;
import africa.semicolon.readingList.data.model.User;
import africa.semicolon.readingList.data.repository.ReadingListRepository;
import africa.semicolon.readingList.dtos.request.AddBookReadingListRequest;
import africa.semicolon.readingList.dtos.request.AddBookRequest;
import africa.semicolon.readingList.dtos.request.LoginRequest;
import africa.semicolon.readingList.dtos.request.RegisterRequest;
import africa.semicolon.readingList.dtos.response.*;
import africa.semicolon.readingList.exception.BookNotFoundException;
import africa.semicolon.readingList.exception.InvalidDetailException;
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
        System.out.println(response.getBookAdded());
        response1.setBook(response.getBookAdded());
        response1.setMessage("Book added successfully");
        return response1;
    }

    @Override
    public List<ReadingBookResponse> getBooks(Long id) {
        User user = findBy(id);
        return bookService.findBooksBelongingToUser(user);
    }

    @Override
    public User findBy(Long id) {
        return reposoitory.findById(id)
                .orElseThrow(()->  new UserDoesNotExistException("User does not exist"));
    }

    @Override
    public LoginResponse login(LoginRequest request) throws InvalidDetailException {
       User user = findUserBy(request.getUsername());
       if (!user.getPassword().equals(request.getPassword())) throw new InvalidDetailException("Invalid details");
       LoginResponse response = new LoginResponse();
       response.setMessage("Login successfully");
       return response;
    }

    private User findUserBy(String username) throws InvalidDetailException {
        return reposoitory.findByUsername(username).orElseThrow(()-> new InvalidDetailException("Invalid detail"));
    }
}
