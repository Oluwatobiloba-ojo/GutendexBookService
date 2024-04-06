package africa.semicolon.readingList.service;

import africa.semicolon.readingList.dtos.request.AddBookReadingListRequest;
import africa.semicolon.readingList.dtos.request.LoginRequest;
import africa.semicolon.readingList.dtos.request.RegisterRequest;
import africa.semicolon.readingList.dtos.response.AddBookReadingListResponse;
import africa.semicolon.readingList.dtos.response.LoginResponse;
import africa.semicolon.readingList.dtos.response.RegisterResponse;
import africa.semicolon.readingList.exception.BookNotFoundException;
import africa.semicolon.readingList.exception.InvalidDetailException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void registerAndYouGetAReadingListEmpty(){
        RegisterRequest request = new RegisterRequest();
        request.setUsername("username");
        request.setPassword("password");
        RegisterResponse response = userService.register(request);
        assertThat(response).isNotNull();
        assertThat(response.getReadingListId()).isNotNull();
    }

    @Test
    @Sql(scripts = "/scripts/data.sql")
    public void addBookToReadingList() throws BookNotFoundException {
        AddBookReadingListRequest request = new AddBookReadingListRequest();
        request.setId(201L);
        request.setTitle("Romeo and Juliet");
        AddBookReadingListResponse response = userService.addBooks(request);
        assertThat(response).isNotNull();
        assertThat(userService.getBooks(201L).size()).isEqualTo(1);
    }

    @Test
    @Sql(scripts = "/scripts/data.sql")
    public void addTwoBookToReadingList() throws BookNotFoundException {
        AddBookReadingListRequest request = new AddBookReadingListRequest();
        request.setId(201L);
        request.setTitle("Romeo and Juliet");
        AddBookReadingListResponse response = userService.addBooks(request);
        assertThat(response).isNotNull();
        request.setTitle("Mother's Nursery Tales");
        AddBookReadingListResponse response1 = userService.addBooks(request);
        assertThat(response1).isNotNull();
        assertThat(userService.getBooks(201L).size()).isEqualTo(2);
    }

    @Test
    @Sql(scripts = "/scripts/data.sql")
    public void testUserCanLogin() throws InvalidDetailException {
        LoginRequest request = new LoginRequest();
        request.setUsername("username");
        request.setPassword("password");
        LoginResponse response = userService.login(request);
        assertThat(response).isNotNull();
    }
}
