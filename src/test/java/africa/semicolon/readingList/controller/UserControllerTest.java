package africa.semicolon.readingList.controller;

import africa.semicolon.readingList.dtos.request.AddBookReadingListRequest;
import africa.semicolon.readingList.dtos.request.RegisterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void registerController() throws Exception {
        RegisterRequest request = new RegisterRequest();
        request.setUsername("username");
        request.setPassword("password");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/request/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(request)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }

    @Test
    @Sql(scripts = "/scripts/data.sql")
    public void testAddBook() throws Exception {
        AddBookReadingListRequest request = new AddBookReadingListRequest();
        request.setId(201L);
        request.setTitle("Peter and Wendy");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/request/book")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(request)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }

    @Test
    public void testGetBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/request/books/201")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }



}