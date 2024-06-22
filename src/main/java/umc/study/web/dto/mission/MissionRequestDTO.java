package umc.study.web.dto.mission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class JoinDto {
        @NotNull
        LocalDate deadline;

        @NotNull
        Integer point;

        @NotNull
        Long store_id;

        @NotNull
        String detail;
    }
}
