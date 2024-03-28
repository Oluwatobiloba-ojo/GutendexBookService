package africa.semicolon.readingList.service;

import africa.semicolon.readingList.data.model.Authors;
import africa.semicolon.readingList.data.model.Book;
import africa.semicolon.readingList.dtos.request.AddAuthorRequest;
import africa.semicolon.readingList.dtos.response.AddAuthorResponse;
import africa.semicolon.readingList.exception.AuthorNotFoundException;
import africa.semicolon.readingList.data.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppAuthorService implements AuthorService{
    @Autowired
    private AuthorRepository repository;
    private final ModelMapper mapper = new ModelMapper();
    @Override
    public AddAuthorResponse create(AddAuthorRequest request) {
        Authors authors = mapper.map(request, Authors.class);
        repository.save(authors);
        AddAuthorResponse response = new AddAuthorResponse();
        response.setId(authors.getId());
        response.setMessage("Authors created successfully");
        return response;
    }

    @Override
    public AddAuthorResponse create(List<AddAuthorRequest> request) {
        List<Authors> authors = request.stream()
                                       .map(addAuthorRequest -> mapper.map(addAuthorRequest, Authors.class))
                                       .toList();
        repository.saveAll(authors);
        AddAuthorResponse response = new AddAuthorResponse();
        response.setId(authors.getFirst().getId());
        response.setMessage("Authors already added to the repo ....");
        return response;
    }
    @Override
    public List<Authors> findAll() {
        return repository.findAll();
    }

    @Override
    public Authors findAuthorBy(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new AuthorNotFoundException("Author does not exist"));
    }

    @Override
    public List<Authors> findAuthorByBook(Book book) {
        return repository.findAuthorByBook(book);
    }
}
