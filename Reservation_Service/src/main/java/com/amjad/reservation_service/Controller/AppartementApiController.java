package com.amjad.reservation_service.Controller;


import com.amjad.reservation_service.OpenFeign.AppartementFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RequestMapping("/api/reservations/appartements")
@RestController
public class AppartementApiController {

    @Autowired
    private AppartementFeign appartementFeign;

    @GetMapping("/getAll")
    public String getAppartements() {
        return appartementFeign.getAppartements();
    }

    @GetMapping("/getAppartement/{id}")
    public String getAppartementById(Long id) {
        return appartementFeign.getAppartementById(id);

    }
}