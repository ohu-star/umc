package umc.study.service.MemberMissionService;

import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.mapping.MemberMission;
import umc.study.web.dto.memberMission.MemberMissionRequestDTO;

public interface MemberMissionCommandService {
    @Transactional
    MemberMission joinMemberMission(MemberMissionRequestDTO.JoinDto request);
}
