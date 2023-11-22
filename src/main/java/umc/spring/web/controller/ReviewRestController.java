package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.base.Code;
import umc.spring.base.ResponseDto;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/users/{storeId}/reviews")
    public ResponseDto<ReviewResponseDTO.ReviewResultDTO> review(@RequestBody @Valid ReviewRequestDTO.ReviewDTO form){
        Review review = reviewCommandService.review(form);
        return ResponseDto.onSuccess(
                ReviewConverter.toReviewResultDTO(review), Code.OK
        );
    }
}
