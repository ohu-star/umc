package umc.study.converter;

import jakarta.validation.constraints.NotNull;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.Store;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.member.MemberRequestDTO;
import umc.study.web.dto.review.ReviewRequestDTO;
import umc.study.web.dto.review.ReviewResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ReviewConverter {
    public static ReviewResponseDTO.JoinResultDTO toJoinResultDTO(Review review) {
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.JoinDto request, Member member, Store store) {
        return Review.builder()
                .detail(request.getDetail())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();
    }
}
