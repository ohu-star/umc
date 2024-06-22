package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.converter.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.domain.Review;
import umc.study.service.ReviewService.ReviewCommandService;
import umc.study.service.ReviewService.ReviewQueryService;
import umc.study.validation.annotation.CheckPage;
import umc.study.web.dto.review.ReviewRequestDTO;
import umc.study.web.dto.review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewCommandController {
    private final ReviewCommandService reviewCommandService;
    private final ReviewQueryService reviewQueryService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> join(@RequestBody @Valid ReviewRequestDTO.JoinDto request) {
        Review review = reviewCommandService.joinReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }

    @GetMapping("/store/{storeId}")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",
            description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.
                    ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1페이지입니다.")
    })

    public ReviewResponseDTO.ReviewPreViewListDTO getReviewList(
            @PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page){
        return ReviewConverter.reviewPreViewListDTO(reviewQueryService.getReviewList(storeId, page));
    }

    @GetMapping("/user/{userId}")
    @Operation(summary = "내가 작성한 리뷰 목록 조회 API",
            description = "내가 작성한 리뷰 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses
                    .ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",
                    content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1페이지입니다.")
    })
    public ReviewResponseDTO.ReviewPreViewListDTO getMyReviewList(@PathVariable(name = "userId") Long userId,
                                                                  @CheckPage @RequestParam(name = "page") Integer page){
        return ReviewConverter.reviewPreViewListDTO(reviewQueryService.getMyReviewList(userId, page));
    }
}