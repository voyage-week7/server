package com.example.catchtable.repository;

import com.example.catchtable.model.Store;
import com.example.catchtable.model.StoreImageURL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreImageRepository extends JpaRepository<StoreImageURL, Long> {
}
