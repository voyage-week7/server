package com.example.catchtable.service;


import com.example.catchtable.dto.RestApi;
import com.example.catchtable.dto.StoreImageDto;
import com.example.catchtable.dto.reservation.ReservationResponseDto;
import com.example.catchtable.dto.review.ReviewResponseDto;
import com.example.catchtable.dto.store.StoreRequestDto;
import com.example.catchtable.dto.store.StoreResponseDto;
import com.example.catchtable.model.Reservation;
import com.example.catchtable.model.Review;
import com.example.catchtable.model.Store;
import com.example.catchtable.model.StoreImageURL;
import com.example.catchtable.repository.ReviewRepository;
import com.example.catchtable.repository.StoreImageRepository;
import com.example.catchtable.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreImageRepository storeImageRepository;
    private final ReviewRepository reviewRepository;


    public List<StoreResponseDto> getStores(String filter,String sort,String word,String minPrice,String maxPrice) {
        // .equal로 사용시 에러 발생
        if (filter == "") {
            filter = null;
        }
        if (sort == "" ) {
            sort = null;
        }
        if (word == "") {
            word = null;
        }
        if (minPrice == "") {
            minPrice = null;
        }
        if (maxPrice == "") {
            maxPrice = null;
        }

        List<Store> stores = new ArrayList<>();
        if (filter == null && sort == null && word == null && minPrice == null && maxPrice == null) {
            stores = storeRepository.findAllByOrderByIdDesc();
        } else if (filter != null) {

        } else if (sort != null) {
            if (sort.equals("Desc")) {
                stores = storeRepository.findAllByOrderByIdDesc();
            } else if (sort.equals("Asc")) {
                stores = storeRepository.findAllByOrderByIdAsc();
            } 
            // 평점 높은 순으로 조회
            else if (sort.equals("reviewAvg")) {
                stores = storeRepository.findAllByOrderByReviewAvgDesc();
            }
            // 리뷰 갯수 순
            else if (sort.equals("reviewCount")) {
                stores = storeRepository.findAllByOrderByReviewCountDesc();
            }
        }
        // 가게 이름 검색 기능 - 카테고리로 해야되는건가??
        else if (word != null) {
            stores = storeRepository.findByStorenameIsContaining(word);
        }
        List<StoreResponseDto> result = new ArrayList<>();
        for(Store store : stores) {
            // 가게 이미지
            List<StoreImageURL> storeImageURLS = store.getStoreImageURLS();
            List<StoreImageDto> storeImageDtos = new ArrayList<>();
            if(storeImageURLS.size() > 0) {
                for(StoreImageURL storeImageURL : storeImageURLS) {
                    StoreImageDto storeImageDto = new StoreImageDto(storeImageURL);
                    storeImageDtos.add(storeImageDto);
                }
            }
            StoreResponseDto responseDto = new StoreResponseDto(store, averageReviewScore(store),reviewCount(store), storeImageDtos);
            result.add(responseDto);
        }
        return result;
    }

    // 가게 상세 장보 조회
    public StoreResponseDto getStore(Long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow(
                () -> new IllegalArgumentException("해당 가게가 존재하지 않습니다.")
        );
        // 예약
        List<Reservation> reservations = store.getReservations();  // 연관관계 매핑으로 연결된 데이터를 조회할 수 있다.
        List<ReservationResponseDto> reservationResponseDtos = new ArrayList<>();
        if(reservations.size() > 0) {
            for(Reservation reservation : reservations) {
                ReservationResponseDto reservationResponseDto = new ReservationResponseDto(reservation);
                reservationResponseDtos.add(reservationResponseDto);
            }
        }
        // 가게 이미지
        List<StoreImageURL> storeImageURLS = store.getStoreImageURLS();
        List<StoreImageDto> storeImageDtos = new ArrayList<>();
        if(storeImageURLS.size() > 0) {
            for(StoreImageURL storeImageURL : storeImageURLS) {
                StoreImageDto storeImageDto = new StoreImageDto(storeImageURL);
                storeImageDtos.add(storeImageDto);
            }
        }
        // 리뷰
        List<Review> reviews = store.getReviews();
        List<ReviewResponseDto> reviewResponseDtos = new ArrayList<>();
        if(reviews.size() > 0) {
            for(Review review : reviews) {
                ReviewResponseDto reviewResponseDto = new ReviewResponseDto(review);
                reviewResponseDtos.add(reviewResponseDto);
            }
        }
        String averageReviewRate = averageReviewScore(store);
        Integer reviewCount = reviewCount(store);
        return new StoreResponseDto(store, reservationResponseDtos, storeImageDtos, reviewResponseDtos, averageReviewRate, reviewCount);
    }

    // 가게 이미지 등록
    @Transactional
    public RestApi createStoreImageURL(StoreImageDto storeImageDto, Long id) {
        Store store  = storeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("점포를 찾을수가 없습니다.")
        );
        StoreImageURL storeImageURL = new StoreImageURL(storeImageDto);
        store.addStoreImageURL(storeImageURL);
        storeImageRepository.save(storeImageURL);

        String Message = "이미지 등록이 완료되었습니다.";
        HttpStatus httpStatus = HttpStatus.OK;
        return new RestApi(Message, httpStatus);
    }

    // 가게에 대한 평점 조회후 계산
    public String averageReviewScore(Store store) {
        List<Review> rates = reviewRepository.findByStoreOrderByRate(store);
        Integer reviewCount = rates.size();
        if(rates.size() == 0) {
            return "0.0";
        }
        Float averageRate = 0f;
        if(rates.size() > 0) {
            for(Review rate : rates) {
                averageRate += rate.getRate();
            }
        }
        return String.format("%.1f", averageRate / reviewCount);
    }
    // 가게 리뷰 갯수
    public Integer reviewCount(Store store) {
        List<Review> rates = reviewRepository.findByStoreOrderByRate(store);
        return rates.size();
    }

    // 가게 등록
    public RestApi registerStore(StoreRequestDto storeRequestDto) {
        String storename = storeRequestDto.getStorename();
        if (storeRepository.findByStorename(storename).isPresent()){
            throw new IllegalArgumentException("이미 존재하는 점포 입니다.");
        }
        Store store = new Store(storeRequestDto);
        storeRepository.save(store);

        String Message = "점포가 등록되었습니다..";
        HttpStatus httpStatus = HttpStatus.OK;
        return new RestApi(Message, httpStatus);
    }
}
