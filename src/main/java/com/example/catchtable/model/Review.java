package com.example.catchtable.model;

import com.example.catchtable.dto.review.ReviewRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
public class Review extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id")
    private Long id;

    @Column(nullable = false)
    private String title;
    private String content;
    private Float rate;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    //== 연관관계 (편의) 메서드==// 양방향 연관관계 세팅을 까먹지않고 할수있는 장점
    public void setUser(User user) {
        this.user = user;
        user.getReviews().add(this);
    }

    public void setStore(Store store) {
        this.store = store;
        store.getReviews().add(this);
    }

    public void updateStore(Store store) {
        this.store = store;
        // 무한 루프에 빠지지 않기 위해 작성
        if(!store.getReviews().contains(this))
            store.addReview(this);
    }

    @Builder
    public Review(String title, String content, Float rate, User user, Store store) {
        this.title = title;
        this.content = content;
        this.rate = rate;
        setUser(user);
        setStore(store);
    }

//    public static Review createReview(Review review, User user, Store store) {
//        return Review.builder()
//                .title(review.getTitle())
//                .content(review.getContent())
//                .rate(review.getRate())
//                .user(user)
//                .store(store)
//                .build();
//    }
    public static Review createReview(ReviewRequestDto reviewRequestDto, User user, Store store) {
        return Review.builder()
                .title(reviewRequestDto.getTitle())
                .content(reviewRequestDto.getContent())
                .rate(reviewRequestDto.getRate())
                .user(user)
                .store(store)
                .build();
    }
}
