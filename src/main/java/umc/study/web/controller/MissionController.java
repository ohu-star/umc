package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.study.converter.MissionConverter;
import umc.study.converter.ReviewConverter;
import umc.study.service.MissionService.MissionQueryService;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.validation.annotation.CheckPage;
import umc.study.web.dto.mission.MissionResponseDTO;
import umc.study.web.dto.review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionQueryService missionQueryService;

    @GetMapping("/{storeId}")
    @Operation(summary = "특정 가게의 미션 목록 조회 API",
            description = "특정 가게의 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",
                    content = @Content(schema = @Schema(implementation = umc.study.apiPayload.ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",
                    content = @Content(schema = @Schema(implementation = umc.study.apiPayload.ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",
                    content = @Content(schema = @Schema(implementation = umc.study.apiPayload.ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1페이지입니다.")
    })
    public MissionResponseDTO.MissionPreViewListDTO getStoreMissionList(@PathVariable(name = "storeId") Long storeId,
                                                                       @CheckPage @RequestParam(name = "page") Integer page){
        return MissionConverter.missionPreViewListDTO(missionQueryService.getStoreMissionList(storeId, page));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "내가 진행중인 미션 목록 조회 API",
            description = "내가 진행중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",
                    content = @Content(schema = @Schema(implementation = umc.study.apiPayload.ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",
                    content = @Content(schema = @Schema(implementation = umc.study.apiPayload.ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",
                    content = @Content(schema = @Schema(implementation = umc.study.apiPayload.ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1페이지입니다.")
    })
    public MissionResponseDTO.MissionPreViewListDTO getMemberMissionList(@PathVariable(name = "userId") Long userId,
                                                                         @CheckPage @RequestParam(name = "page") Integer page){
        return MissionConverter.missionPreViewListDTO(missionQueryService.getMemberMissionList(userId, page));
    }
}
