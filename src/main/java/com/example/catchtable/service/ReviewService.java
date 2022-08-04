package com.example.catchtable.service;

import com.example.catchtable.dto.review.ReviewRequestDto;
import com.example.catchtable.dto.review.ReviewResponseDto;
import com.example.catchtable.model.Review;
import com.example.catchtable.model.Store;
import com.example.catchtable.model.User;
import com.example.catchtable.repository.ReviewRepository;
import com.example.catchtable.repository.StoreRepository;
import com.example.catchtable.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    /**
     *  리뷰 작성
     */
    @Transactional
    public ResponseEntity<?> registerReview(Long storeId, String userId, ReviewRequestDto reviewRequestDto) {

        Store store = storeRepository.findById(storeId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 가게입니다."));
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 회원입니다."));
        System.out.println("user : " + user.getId());
//        Review review = reviewRequestDto.toEntity();
        Review saveReview = Review.createReview(reviewRequestDto, user, store);

        // 리뷰 저장 및 리턴
        return new ResponseEntity<>(reviewRepository.save(saveReview), HttpStatus.valueOf(200));
    }

    /**
     *  (사용자) 리뷰 목록
     */
//    public List<ReviewResponseDto> getUserReviews(String userId) {
//        // 사용자 확인
//        User user = userRepository.findById(userId).orElseThrow(
//                () -> new NullPointerException("존재하지 않는 회원입니다."));
//
//        List<ReviewResponseDto> reviewResponseDtos = new ArrayList<>();
//
//        // 사용자 작성한 리뷰 가져오기
//        List<Review> myReviews = reviewRepository.findByUserOrderByCreatedAtDesc(user);
//        for (Review myReview : myReviews) {
//            ReviewResponseDto reviewResponseDto = new ReviewResponseDto(myReview);
//            reviewResponseDtos.add(reviewResponseDto);
//        }
//        return reviewResponseDtos;
//    }

    public List<ReviewResponseDto> getUserReviewsss(String userId, int page, int size, String sortBy, boolean isAsc) {
        // 사용자 확인
        User user = userRepository.findById(userId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 회원입니다."));

        // ----------------------페이징 처리-------------------------//
        Sort.Direction direction = isAsc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        // Pageable pageable2 = new PageRequest(page, size, sort); 우리에겐 이 형태가 익숙하지만
        // static 함수(=of)를 사용해서 필요인자를 받아서 new를 해준다.
        // --------------------------------------------------------//

        List<ReviewResponseDto> reviewResponseDtos = new ArrayList<>();

        // 사용자 작성한 리뷰 가져오기
        Page<Review> myReviews = reviewRepository.findByUserOrderByCreatedAtDesc(user, pageable);
        for (Review myReview : myReviews) {
            ReviewResponseDto reviewResponseDto = new ReviewResponseDto(myReview);
            reviewResponseDtos.add(reviewResponseDto);
        }
//      return  reviewResponseDtos = reviewRepository.findByUserOrderByCreatedAtDesc(user, pageable).stream()
//                .map(myReview -> new ReviewResponseDto(myReview)).collect(Collectors.toList());
        return reviewResponseDtos;

    }

    /**
     *  (가게) 리뷰 목록
     */
    public List<ReviewResponseDto> getStoreReviews(Long id) {
        // 가게 확인
        Store store = storeRepository.findById(id).orElseThrow(
                () -> new NullPointerException("존재하지 않는 가게입니다."));

        List<ReviewResponseDto> reviewResponseDtos = new ArrayList<>();

        // 가게 리뷰 가져오기
        List<Review> storeReviews = reviewRepository.findByStoreOrderByCreatedAtDesc(store);
        for (Review storeReview : storeReviews) {
            ReviewResponseDto reviewResponseDto = new ReviewResponseDto(storeReview);
            reviewResponseDtos.add(reviewResponseDto);
        }
        return reviewResponseDtos;
    }

    /**
     * 리뷰 상세 보기
     */
    public ReviewResponseDto getReviewDtl(Long reviewId) {

        Review review = reviewRepository.findById(reviewId).orElseThrow(
                () -> new NullPointerException("존재하지 않는 리뷰입니다."));
        return new  ReviewResponseDto(review);
    }
}
