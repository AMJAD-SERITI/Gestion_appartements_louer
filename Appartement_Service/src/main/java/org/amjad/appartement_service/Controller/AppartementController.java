package org.amjad.appartement_service.Controller;

import org.amjad.appartement_service.Entities.Appartement;
import org.amjad.appartement_service.Service.AppartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appartements")
public class AppartementController {

    @Autowired
    private AppartementService service;

    @GetMapping("/getAll")
    public List<Appartement> getAllAppartements() {
        return service.getAllAppartements();
    }

    @GetMapping("/getAppartement/{id}")
    public ResponseEntity<Appartement> getAppartementById(@PathVariable Long id) {
        return service.getAppartementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

@PostMapping(value = "/create")
public ResponseEntity<Appartement> createAppartement(@RequestBody Appartement appartement) {
    Appartement savedAppartement = service.saveAppartement(appartement);
    return ResponseEntity.ok(savedAppartement);
}


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAppartement(@PathVariable Long id) {
        service.deleteAppartement(id);
        return ResponseEntity.noContent().build();
    }
}
