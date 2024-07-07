package ir.javapro.sesstion3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class BookResponse {


    private final Long id;
    private final String name;
    private final Long price;
}
