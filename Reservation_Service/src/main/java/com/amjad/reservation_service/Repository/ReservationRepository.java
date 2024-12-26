package com.amjad.reservation_service.Repository;

import com.amjad.reservation_service.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    //List<Reservation> findByReservationDateBetween(Date from, Date to);
}