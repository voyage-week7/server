package com.example.catchtable.dto.review;

import com.example.catchtable.model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class ReviewRequestDto {
   private String title;   // 제목
   private String content; // 내용
   private Float rate;     // 평점

   // private List<ImageResponseDto> image;


   public Review toEntity() {
      return Review.builder()
              .title(title)
              .content(content)
              .rate(rate)
              .build();
   }
}
