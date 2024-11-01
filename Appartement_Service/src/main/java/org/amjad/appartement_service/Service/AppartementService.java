package org.amjad.appartement_service.Service;



import org.amjad.appartement_service.Entities.Appartement;
import org.amjad.appartement_service.Repository.AppartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppartementService {

    @Autowired
    private AppartementRepository repository;

    public List<Appartement> getAllAppartements() {
        return repository.findAll();
    }

    public Optional<Appartement> getAppartementById(Long id) {
        return repository.findById(id);
    }

    public Appartement saveAppartement(Appartement appartement) {
        return repository.save(appartement);
    }

    public void deleteAppartement(Long id) {
        repository.deleteById(id);
    }
}