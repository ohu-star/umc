package umc.study.web.dto.memberMission;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;
import umc.study.validation.annotation.ExistFood;

import java.util.List;

public class MemberMissionRequestDTO {
    @Getter
    public static class JoinDto{
        @NotNull
        Long member_id;

        @NotNull
        Long mission_id;

    }
}
