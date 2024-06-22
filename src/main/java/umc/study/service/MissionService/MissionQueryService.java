package umc.study.service.MissionService;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.util.Optional;


public interface MissionQueryService {
    Optional<Store> findStore(Long id);
    Page<Mission> getStoreMissionList(Long StoreId, Integer page);
    Page<Mission> getMemberMissionList(Long MemberId, Integer page);
}
