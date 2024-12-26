package com.amjad.reservation_service.Controller;

import com.amjad.reservation_service.Entities.Reservation;
import com.amjad.reservation_service.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/create")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.createReservation(reservation);
    }

    @PostMapping("/reserveappartement/{id}")

    public Reservation reserveAppartement(@PathVariable Long id, @RequestBody Reservation reservation) {
        return reservationService.reserveAppartement(id, reservation);
    }


    @GetMapping("findReserv/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    @GetMapping("/findAllReserv")
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

//    @GetMapping("/findDateBetween")
//    public List<Reservation> getReservationByDate(Date from, Date to) {
//        return reservationService.getReservationByDate(from, to);
//    }

    @PutMapping("/update/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation updatedReservation) {
        return reservationService.updateReservation(id, updatedReservation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
    }

}
