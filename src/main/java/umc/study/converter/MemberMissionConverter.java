package umc.study.converter;

import umc.study.domain.Food;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.web.dto.memberMission.MemberMissionRequestDTO;
import umc.study.web.dto.memberMission.MemberMissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {
    public static MemberMissionResponseDTO.JoinResultDTO toJoinResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.JoinResultDTO.builder()
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.JoinDto request,Mission mission, Member member) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .build();
    }
}

