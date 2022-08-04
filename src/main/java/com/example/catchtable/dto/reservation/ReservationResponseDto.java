package com.example.catchtable.dto.reservation;

import com.example.catchtable.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDto {
    private Long id;
    //    private String userId; // 우석님 코드!
    private String userId;
    private Long storeId;
    private String username;
    private String storename;

    private String date;
    private Integer members; // member? members?

    public ReservationResponseDto(Reservation reservation) {
        this.id = reservation.getId();
        this.userId = reservation.getUser().getId();
        this.storeId = reservation.getStore().getId();
        this.username = reservation.getUser().getUsername();
        this.storename = reservation.getStore().getStorename();
        this.storeId = reservation.getStore().getId();
        this.date = reservation.getDate();
        this.members = reservation.getMembers();
    }
}
