package umc.study.web.dto.store;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.domain.Mission;
import umc.study.domain.Region;

import java.util.ArrayList;
import java.util.List;

public class StoreRequestDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        Long id;
        @NotNull
        String name;
        @NotNull
        Long owner_num;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @NotNull
        private Region region;

        List<Mission> missionList;
    }
}
