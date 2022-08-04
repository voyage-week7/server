package com.example.catchtable.repository;

import com.example.catchtable.model.Reservation;
import com.example.catchtable.model.Store;
import com.example.catchtable.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUserOrderByCreatedAtDesc(User foundUer);
    List<Reservation> findByStoreOrderByCreatedAtDesc(Store store);

    Optional<Reservation> findByUser(User user);

}
