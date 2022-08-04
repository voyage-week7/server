package com.example.catchtable.dto.review;

import com.example.catchtable.model.Review;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class ReviewResponseDto {
    private Long id;
    private Long storeId;
    private String storename;
    private String title;
    private String content;
    private Float rate;

    //    private List<ImageResponseDto> images;
    private LocalDateTime createdAt;


    public ReviewResponseDto(Review myReview) {
        this.id = myReview.getId();
        this.storeId = myReview.getStore().getId();
        this.storename = myReview.getStore().getStorename();
        this.title = myReview.getTitle();
        this.content = myReview.getContent();
        this.rate = myReview.getRate();
        this.createdAt = myReview.getCreatedAt();
    }

//    @Builder --> 이미지 정해지면 이걸로 수정
//    public ReviewResponseDto(Review myReview, List<ImageResponseDto> images) {
//        this.id = myReview.getId();
//        this.storeId = myReview.getStore().getId();
//        this.storename = myReview.getStore().getStorename();
//        this.title = myReview.getTitle();
//        this.content = myReview.getContent();
//        this.rate = myReview.getRate();
//        this.createdAt = myReview.getCreatedAt();
//        this.images = images;
//    }

}
