package com.example.catchtable.repository;

import com.example.catchtable.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
//    List<Store> findAllByOrderByCreatedAtDesc();

    // 추천순, 별점순, 리뷰 많은 순, 가격 높은 순, 가격 낮은 순
    
    // 필터없을시 전체 조회 - 내림차순 (기본값)
    List<Store> findAllByOrderByIdDesc();
    // 오름차순
    List<Store> findAllByOrderByIdAsc();
    // 리뷰 평점 순
    List<Store> findAllByOrderByReviewAvgDesc();
    // 리뷰 갯수 순
    List<Store> findAllByOrderByReviewCountDesc();

    // 카테고리별 가게 조회
    List<Store> findByCategoryIsContaining(String category);

    // 가게 이름 검색 - Like 적용
    List<Store> findByStorenameIsContaining(String storename);
    // minPrice, maxPrice 사이값 조회 - 가게의 minPrice, maxPrice값이 없으므로 사용할 필요가 없어짐
//    List<Store> findAllByIdBetween(Integer minPrice, Integer maxPrice);
    Optional<Store> findById(Long id);

    // 점포 조회
    Optional<Store> findByStorename(String storename);
}