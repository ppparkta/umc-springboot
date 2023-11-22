package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.base.Code;
import umc.spring.base.exception.handler.MemberHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;

    public Review review(ReviewRequestDTO.ReviewDTO form) {
        Member member = memberRepository.findById(1L).orElseThrow(() -> new MemberHandler(Code.MEMBER_NOT_FOUND));
        Review review = ReviewConverter.toReview(form, member);
        return reviewRepository.save(review);
    }
}
