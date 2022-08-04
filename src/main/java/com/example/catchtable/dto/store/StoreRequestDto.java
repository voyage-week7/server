package com.example.catchtable.dto.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class StoreRequestDto {
    private String storename;
    private String category;
    private String region;
    private String launchPrice;
    private String dinnerPrice;
    private String phone;
    private String description;
    private Float lat; // 위도
    private Float lng; // 경도 - long은 예약어라 사용 불가능?
}
