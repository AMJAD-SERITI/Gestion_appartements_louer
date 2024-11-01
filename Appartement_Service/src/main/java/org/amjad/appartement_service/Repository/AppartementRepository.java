package org.amjad.appartement_service.Repository;



import org.amjad.appartement_service.Entities.Appartement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppartementRepository extends JpaRepository<Appartement, Long> {
}