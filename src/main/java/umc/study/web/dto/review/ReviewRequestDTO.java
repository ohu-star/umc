package umc.study.web.dto.review;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.domain.Member;
import umc.study.domain.Store;

public class ReviewRequestDTO {
    @Getter
    public static class JoinDto {
        String detail;

        @NotNull
        Float score;

        @NotNull
        Long member_id;

        @NotNull
        Long store_id;
    }
}
