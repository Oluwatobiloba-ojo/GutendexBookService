package africa.semicolon.readingList.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBookReadingListRequest {
    private Long id;
    private String title;
}
