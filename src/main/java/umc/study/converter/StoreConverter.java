package umc.study.converter;

import umc.study.domain.Member;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.web.dto.member.MemberResponseDTO;
import umc.study.web.dto.store.StoreRequestDTO;
import umc.study.web.dto.store.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static Store toStore(StoreRequestDTO.JoinDto request){

        return Store.builder()
                .name(request.getName())
                .owner_num(request.getOwner_num())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .region(request.getRegion())
                .build();
    }
}