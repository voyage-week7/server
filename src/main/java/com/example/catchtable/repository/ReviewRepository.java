package com.example.catchtable.repository;

import com.example.catchtable.model.Review;
import com.example.catchtable.model.Store;
import com.example.catchtable.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

//    List<Review> findByUserOrderByCreatedAtDesc(User foundUer);
    Page<Review> findByUserOrderByCreatedAtDesc(User foundUer, Pageable pageable);
    List<Review> findByStoreOrderByCreatedAtDesc(Store sotre);

    Page<Review> findAllByUser(User user, Pageable pageable);

    // 가게의 평균 평점 계산을 위한 rate 조회
    List<Review> findByStoreOrderByRate(Store store);
}

