package umc.study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MemberMissionHandler;
import umc.study.converter.MemberMissionConverter;
import umc.study.domain.Member;
import umc.study.domain.Mission;
import umc.study.domain.mapping.MemberMission;
import umc.study.repository.MemberMissionRepository;
import umc.study.repository.MemberRepository;
import umc.study.repository.MissionRepository;
import umc.study.web.dto.memberMission.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {
    private final MemberRepository memberRepository;

    private final MissionRepository missionRepository;

    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public MemberMission joinMemberMission(MemberMissionRequestDTO.JoinDto request) {
        Member member = memberRepository.findById(request.getMember_id())
                .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMission_id())
                .orElseThrow(() -> new MemberMissionHandler(ErrorStatus.MISSON_NOT_FOUND));

        MemberMission memberMission = MemberMissionConverter.toMemberMission(request, mission, member);

        return memberMissionRepository.save(memberMission);
    }
}
