package com.example.catchtable.model;

import com.example.catchtable.dto.store.StoreRequestDto;
import com.example.catchtable.dto.store.StoreResponseDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "STORE_ID")
    private Long id;

    @Column(nullable = false, unique = true)
    private String storename;

    @Column(nullable = false)
    private String category;
    private String region;
    private String launchPrice;
    private String dinnerPrice;
    private String phone;
    private String description;
    private Float lat; // 위도
    private Float lng; // 경도

    @Column
    private String reviewAvg;
    private Integer reviewCount;

    // 여기에서는 외래키를 생성하는것이 아닌, 양방향 연관관계를 만들기위한 코드이다.
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    // 여기에서는 외래키를 생성하는것이 아닌, 양방향 연관관계를 만들기위한 코드이다.
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StoreImageURL> storeImageURLS = new ArrayList<>();

    // 외래키 생성하지 않고, 양방향 연관관계를 형성하기 위한 코드
    @OneToOne(mappedBy = "store")
    private StoreReviewInfo storeReviewInfo;

    // 외래키 생성하지 않고, 양방향 연관관계를 형성하기 위한 코드
    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    // 예약 연관관계 생성
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
        // 무한 후프에 빠지지 않기 위해서 작성
        if(reservation.getStore()!=this)
            reservation.updateStore(this);
    }

    // 가게 이미지 연관관계 생성
    public void addStoreImageURL(StoreImageURL storeImageURL) {
        this.storeImageURLS.add(storeImageURL);
        // 무한 후프에 빠지지 않기 위해서 작성
        if(storeImageURL.getStore()!=this)
            storeImageURL.updateStore(this);
    }

    // 리뷰 연관관계 생성
    public void addReview(Review review) {
        this.reviews.add(review);
        // 무한 후프에 빠지지 않기 위해서 작성
        if(review.getStore()!=this)
            review.updateStore(this);
    }

//     예약 더미데이터 생성을 위한 코드
    @Builder
    public Store(StoreResponseDto storeResponseDto) {
        this.storename = storeResponseDto.getStorename();
        this.category = storeResponseDto.getCategory();
        this.region = storeResponseDto.getRegion();
        this.launchPrice = storeResponseDto.getLaunchPrice();
        this.dinnerPrice = storeResponseDto.getDinnerPrice();
        this.phone = storeResponseDto.getPhone();
        this.description = storeResponseDto.getDescription();
        this.lat = storeResponseDto.getLat();
        this.lng = storeResponseDto.getLng();
    }

    public Store(StoreRequestDto storeRequestDto) {
        this.storename = storeRequestDto.getStorename();
        this.category = storeRequestDto.getCategory();
        this.region = storeRequestDto.getRegion();
        this.launchPrice = storeRequestDto.getLaunchPrice();
        this.dinnerPrice = storeRequestDto.getDinnerPrice();
        this.phone = storeRequestDto.getPhone();
        this.description = storeRequestDto.getDescription();
        this.lat = storeRequestDto.getLat();
        this.lng = storeRequestDto.getLng();
    }
}