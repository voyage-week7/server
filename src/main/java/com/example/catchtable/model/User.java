package com.example.catchtable.model;

import com.example.catchtable.dto.user.MyPageUpdateDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
public class User extends Timestamped{

    @Id
    @Column(name = "user_id",nullable = false, unique = true) // 이건가? 생각하고있습니다
    private String id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String pw;
    private String profileUrl;
    private String description;
    private String region;
    private Integer phone;
    private String gender;
    private Date birth;
    private Integer priceMin;
    private Integer priceMax;

    @Column(nullable = false)
    private String role;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public User(String id, String pw, String username, String role) {
        this.id = id;
        this.pw = pw;
        this.username = username;
        this.role = role;
    }

    public void updateUser(MyPageUpdateDto myPageUpdateDto) {
        this.username = myPageUpdateDto.getUsername();
        this.profileUrl = myPageUpdateDto.getProfileUrl();
        this.description = myPageUpdateDto.getDescription();
        this.region = myPageUpdateDto.getRegion();
        this.phone = myPageUpdateDto.getPhone();
        this.gender = myPageUpdateDto.getGender();
        this.birth = myPageUpdateDto.getBirth();
        this.priceMin = myPageUpdateDto.getPriceMin();
        this.priceMax = myPageUpdateDto.getPriceMax();
    }

    // 예약 연관관계
    public void addReservation(Reservation reservation) {
        this.reservations.add(reservation);
        // 무한 후프에 빠지지 않기 위해서 작성
        if(reservation.getUser()!=this)
            reservation.updateUser(this);
    }
}
