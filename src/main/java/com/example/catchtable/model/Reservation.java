package com.example.catchtable.model;

import com.example.catchtable.dto.reservation.ReservationRequestDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.

// @AllArgsConstructor
// 클래스에 존재하는 모든 필드에 대한 생성자를 자동으로 생성하는데,
// 인스턴스 멤버의 선언 순서에 영향을 받기 때문에 두 변수의 순서를 바꾸면
// 생성자의 입력 값 순서도 바뀌게 되어 검출되지 않는 치명적인 오류를 발생시킬 수 있습니다.
@AllArgsConstructor
public class Reservation extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user; // 사용자 우선적으로 등록된 다음, 해당 ID값이 있어야 등록이 되는점 기억할것

//     store_id 외래키가 존재함으로, Store,Reservation 의 주인이라 보면 된디.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="STORE_ID")
    private Store store;  // 가게가 우선적으로 등록된 다음, 해당 ID값이 있어야 등록이 되는점 기억할것

    // 외래키를 조회할 수 있도록 필드에 추가했지만, 외래키는 함부로 변경되면 영속 객체의 정합성이 깨지므로, update, insert 옵션 false
//    @Column(name = "STORE_ID", insertable = false, updatable = false)
//    private Long storeId;

    @Column(columnDefinition="TIMESTAMP")
    private String date;

    @Column(nullable = false)
    private Integer members;

    @Builder
    public Reservation(ReservationRequestDto requestDto) {
        this.date = requestDto.getDate();
        this.members = requestDto.getMembers();
    }

    // 연관 관계 설정 - 가게
    public void updateStore(Store store) {
        this.store = store;
        // 무한 루프에 빠지지 않기 위해 작성
        if(!store.getReservations().contains(this))
            store.addReservation(this);
    }

    // 연관 관계 설정 - 사용자
    public void updateUser(User user) {
        this.user = user;
        // 무한 루프에 빠지지 않기 위해 작성
        if(!user.getReservations().contains(this))
            user.addReservation(this);
    }

    // status 값이 있어야 할듯 - 방문예정 / 방문완료 / 취소&노쇼
    // 시간은 어떻게 ? 그냥 예약하면 예약하기로 ?
}
