package com.amjad.reservation_service.Service;


import com.amjad.reservation_service.Controller.AppartementApiController;
import com.amjad.reservation_service.Entities.Reservation;
import com.amjad.reservation_service.Kafka.ReservationProducer;
import com.amjad.reservation_service.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
@Autowired

    private AppartementApiController appartementFeign;


    public Reservation updateReservation(Long id, Reservation updatedReservation) {
        return reservationRepository.findById(id)
                .map(reservation -> {
                    reservation.setDateDebut(updatedReservation.getDateDebut());
                    reservation.setDateFin(updatedReservation.getDateFin());
                    reservation.setStatut(updatedReservation.getStatut());
                    reservation.setPrixTotal(updatedReservation.getPrixTotal());
                    reservation.setMoyenPaiement(updatedReservation.getMoyenPaiement());
                    reservation.setDateModification(LocalDateTime.now());
                    return reservationRepository.save(reservation);
                })
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation reserveAppartement(Long id, Reservation reservation) {
        // Appeler le client Feign pour obtenir les informations de l'appartement

        String appartementInfo = appartementFeign.getAppartementById(id);

        // Logique pour réserver l'appartement en utilisant les informations obtenues
        return reservationRepository.findById(id)
                .map(reservation1 -> {
                    reservation1.setDateDebut(reservation.getDateDebut());
                    reservation1.setDateFin(reservation.getDateFin());
                    reservation1.setStatut(reservation.getStatut());
                    reservation1.setPrixTotal(reservation.getPrixTotal());
                    reservation1.setMoyenPaiement(reservation.getMoyenPaiement());
                    reservation1.setDateModification(LocalDateTime.now());
                    // Ajouter les informations de l'appartement à la réservation

                    return reservationRepository.save(reservation1);
                })
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    @Autowired
    private ReservationProducer reservationProducer;

    public void createReservation(String reservationDetails) {
        // Logique pour créer une réservation
        reservationProducer.sendMessage("Reservation created: " + reservationDetails);
    }
}