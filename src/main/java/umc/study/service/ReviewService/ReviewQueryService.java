package umc.study.service.ReviewService;

import org.springframework.data.domain.Page;
import umc.study.domain.Review;
import umc.study.domain.Store;

import java.util.Optional;

public interface ReviewQueryService {
    Optional<Store> findStore(Long id);
    Page<Review> getReviewList(Long StoreId, Integer page);
    Page<Review> getMyReviewList(Long UserId, Integer page);
}
