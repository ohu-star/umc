package umc.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.mapping.MemberMission;
import umc.study.service.MemberMissionService.MemberMissionCommandService;
import umc.study.web.dto.memberMission.MemberMissionRequestDTO;
import umc.study.web.dto.memberMission.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members/mission")
public class MemberMissionController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.JoinResultDTO> join
            (@RequestBody @Valid MemberMissionRequestDTO.JoinDto request) {
        MemberMission memberMission = memberMissionCommandService.joinMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(memberMission));
    }
}
