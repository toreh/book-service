package tore.springboot.bookservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDTO {

    private Long bookId;
    @NotNull
    @NotBlank
    private String title;
    private String isbn;
    private String source;
}
