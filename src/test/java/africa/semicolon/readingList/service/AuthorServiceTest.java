package africa.semicolon.readingList.service;

import africa.semicolon.readingList.dtos.request.AddAuthorRequest;
import africa.semicolon.readingList.dtos.response.AddAuthorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AuthorServiceTest {
    @Autowired
    private AuthorService authorService;

    @Test
    public void testCreateAuthor(){
        AddAuthorRequest request = new AddAuthorRequest();
        request.setName("Shakespare");
        request.setBirth_year("1895");
        request.setDeath_year("1999");
        AddAuthorResponse response = authorService.create(request);
        assertThat(response).isNotNull();
    }

    @Test
    public void testCreateAuthors(){
        AddAuthorRequest request = new AddAuthorRequest();
        request.setName("Willams shakespare");
        request.setBirth_year("1200");
        request.setDeath_year("1900");
        AddAuthorRequest request1 = new AddAuthorRequest();
        request1.setName("Aina");
        request1.setBirth_year("1300");
        request1.setDeath_year("2000");
        List<AddAuthorRequest> requests = List.of(request1, request);
        AddAuthorResponse response = authorService.create(requests);
        assertThat(response).isNotNull();
        assertThat(authorService.findAll().size()).isEqualTo(2);
    }

    @Test
    @Sql(scripts = "/scripts/data.sql")
    public void testCreateAuthorWithABook(){
        AddAuthorRequest request = new AddAuthorRequest();
        request.setName("Willams shakespare");
        request.setBirth_year("1200");
        request.setDeath_year("1900");
        request.setBookId(200L);
        AddAuthorResponse response = authorService.create(request);
        assertThat(response).isNotNull();
        assertThat(authorService.findAuthorBy(1L).getBook()).isNotNull();
    }

}