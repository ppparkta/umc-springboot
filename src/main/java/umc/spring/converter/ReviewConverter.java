package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.ReviewDTO form, Member member) {
        return Review.builder()
                .member(member)
                .title(form.getTitle())
                .score(form.getScore())
                .build();
    }

    public static ReviewResponseDTO.ReviewResultDTO toReviewResultDTO(Review review){
        return ReviewResponseDTO.ReviewResultDTO.builder()
                .nickname(review.getMember().getName())
                .score(review.getScore())
                .review_id(review.getId())
                .title(review.getTitle())
                .build();
    }
}
