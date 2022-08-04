package com.example.catchtable.controller;

import com.example.catchtable.dto.review.ReviewRequestDto;
import com.example.catchtable.dto.review.ReviewResponseDto;
import com.example.catchtable.security.UserDetailsImpl;
import com.example.catchtable.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    // 리뷰 작성 --> OK
    @PostMapping("/api/review/stores/{storeId}")
    public ResponseEntity<?> registerReview(@PathVariable Long storeId,
                                            @AuthenticationPrincipal UserDetailsImpl userDetails,
                                            @RequestBody ReviewRequestDto reviewRequestDto) {
        if (userDetails != null) {
            String userId = userDetails.getUser().getId();
            return reviewService.registerReview(storeId, userId, reviewRequestDto);
        }
        return new ResponseEntity<>("로그인 후 사용해주세요", HttpStatus.valueOf(401));
    }

//    // (사용자) 리뷰 목록
//    @GetMapping("/api/users/reviews")
//    public List<ReviewResponseDto> getUserReviews(@AuthenticationPrincipal UserDetailsImpl userDetails) {
//        return reviewService.getUserReviews(userDetails.getUser().getId());
//    }
    // (사용자) 리뷰 목록 --> OK
    @GetMapping("/api/users/reviews")
    public List<ReviewResponseDto> getUserReviews(@RequestParam("page") int page,
                                                  @RequestParam("size") int size,
                                                  @RequestParam("sortBy") String sortBy,
                                                  @RequestParam("isAsc") boolean isAsc,
                                                  @AuthenticationPrincipal UserDetailsImpl userDetails) {
        page = page - 1;    // 서버는 항상 0붜 시작이기때문에 1이 들어오면 0으로 만들어서 첫번째 페이지로 만들어준다.
        return reviewService.getUserReviewsss(userDetails.getUser().getId(), page, size, sortBy, isAsc);
    }

    // (가게) 리뷰 목록 --> OK
    @GetMapping("/api/reviews/stores/{id}")
    public List<ReviewResponseDto> getStoreReviews(@PathVariable Long id) {
        return reviewService.getStoreReviews(id);
    }

    // 리뷰 상세 보기 --> OK
    @GetMapping("/api/reviews/{reviewId}")
    public ReviewResponseDto getReviewDtl(@PathVariable Long reviewId) {
        return reviewService.getReviewDtl(reviewId);
    }
}
