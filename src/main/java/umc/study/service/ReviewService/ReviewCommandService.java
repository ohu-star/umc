package umc.study.service.ReviewService;

import umc.study.domain.Review;
import umc.study.web.dto.review.ReviewRequestDTO;

public interface ReviewCommandService {
    public Review joinReview(ReviewRequestDTO.JoinDto request);
}
