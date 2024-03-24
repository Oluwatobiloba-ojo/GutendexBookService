package africa.semicolon.readingList.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponse {
    private Long readingListId;
    private String message;
}
