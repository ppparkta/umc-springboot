package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class MissionRegisterDTO {
        @NotNull
        private Integer reward;
        @NotNull
        private LocalDate deadline;
        @NotBlank
        private String mission_spec;
    }
}
