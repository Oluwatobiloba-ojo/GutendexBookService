package africa.semicolon.readingList.controller;

import africa.semicolon.readingList.dtos.request.AddBookReadingListRequest;
import africa.semicolon.readingList.dtos.request.LoginRequest;
import africa.semicolon.readingList.dtos.request.RegisterRequest;
import africa.semicolon.readingList.dtos.response.RegisterResponse;
import africa.semicolon.readingList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/request")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/book")
    public ResponseEntity<?> books(@RequestBody AddBookReadingListRequest request){
        try {
            return ResponseEntity.ok(userService.addBooks(request));
        }catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/books/{userId}")
    public ResponseEntity<?> getBooks(@PathVariable("userId") Long userId){
        try {
            return ResponseEntity.ok(userService.getBooks(userId));
        }catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PostMapping("/sign_in/user")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){
        try{
            return ResponseEntity.accepted().body(userService.login(loginRequest));
        }catch (Exception exception){
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }


}
