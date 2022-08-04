package com.example.catchtable.controller;

import com.example.catchtable.dto.RestApi;
import com.example.catchtable.dto.reservation.ReservationRequestDto;
import com.example.catchtable.dto.reservation.ReservationResponseDto;
import com.example.catchtable.service.ReservationService;
import com.example.catchtable.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.catchtable.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final StoreService storeService;

    // 예약 하기
    @PostMapping("/api/reservation/store/{storeId}")
    public RestApi postReservation(@RequestBody ReservationRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails ,@PathVariable Long storeId) {
        System.out.println("userDetails = " + userDetails);
        if(userDetails == null) {
            throw new IllegalArgumentException("로그인이 필요한 기능입니다.");
        }
        String userId = userDetails.getUser().getId();
        return reservationService.createReservation(requestDto, storeId, userId);
    }

    // 사용자 그동안 예약 목록 불러오기 //
    @GetMapping("/api/users/reservations")
    public List<ReservationResponseDto> getUserReservations(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return reservationService.getUserReservations(userDetails.getUser().getId());
    }

    // 예약 상세 보기 //
    @GetMapping("/api/users/reservations/{reservationId}")
    public ReservationResponseDto getReservationDtl(@PathVariable Long reservationId,
                                                    @AuthenticationPrincipal UserDetailsImpl userDetails) {
        String userId = userDetails.getUser().getId();
        return reservationService.getReservationDtl(reservationId, userId);
    }

    // 가게 예악된 목록 불러오기 //
    @GetMapping("/api/store/reservations/{storeId}")
    public List<ReservationResponseDto> getStoreReservations(@PathVariable Long storeId,
                                                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return reservationService.getStoreReservations(storeId, userDetails.getUser().getId());
    }

   //예약 취소
    @DeleteMapping("/api/reservation/{id}")
    public RestApi deleteReservation(@PathVariable Long id) {
         return reservationService.deleteReservation(id);
    }
}