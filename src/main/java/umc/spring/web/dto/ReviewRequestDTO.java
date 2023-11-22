package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {
    @Getter
    public static class ReviewDTO {
        @NotBlank
        private String title;
        @NotNull
        private Float score;
    }
}
