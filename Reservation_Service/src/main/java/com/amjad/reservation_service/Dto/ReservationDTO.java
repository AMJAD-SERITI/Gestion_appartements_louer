package com.amjad.reservation_service.Dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ReservationDTO {

    private Long id;
    private Long appartementId;
    private Long locataireId;
    private LocalDateTime dateReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String statut;
    private BigDecimal prixTotal;
    private String moyenPaiement;
    private LocalDateTime dateAnnulation;
    private String commentaires;

}
