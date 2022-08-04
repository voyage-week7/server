package com.example.catchtable.model;

import com.example.catchtable.dto.StoreImageDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@AllArgsConstructor
public class StoreImageURL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 1000) // 주소길이가 너무 길어 넣지 못하는 상황 발생
    private String imagePath;

    // store_id 외래키가 존재함으로, Store,Reservation 의 주인이라 보면 된디.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="STORE_ID")
    private Store store;  // 가게가 우선적으로 등록된 다음, 해당 ID값이 있어야 등록이 되는점 기억할것

    @Builder
    public StoreImageURL(StoreImageDto storeImageDto) {
        this.imagePath = storeImageDto.getImagePath();
    }

    // 연관 관계 설정
    public void updateStore(Store store) {
        this.store = store;
        // 무한 루프에 빠지지 않기 위해 작성
        if(!store.getStoreImageURLS().contains(this))
            store.addStoreImageURL(this);
    }
}
