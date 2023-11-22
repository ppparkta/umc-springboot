package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class MissionResponseDTO {
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionResultDTO {
        private String msg;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MissionRegisterDTO {
        private Long mission_id;
        private Integer reward;
        private LocalDate deadline;
        private String missionSpec;
        private Long store_id;
    }
}
