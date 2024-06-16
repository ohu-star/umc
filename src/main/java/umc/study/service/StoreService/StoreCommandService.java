package umc.study.service.StoreService;

import umc.study.domain.Store;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

public interface StoreCommandService {

    Store joinStore(StoreRequestDTO.JoinDto request);
}
