package umc.study.web.dto.store;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class JoinDto {
        @NotNull
        private Long regionId;

        @NotNull
        private String name;

        @NotNull
        private Long ownerNum;

        @Size(min = 2, max = 12)
        private String address;

        @Size(min = 2, max = 12)
        private String specAddress;
    }
}

