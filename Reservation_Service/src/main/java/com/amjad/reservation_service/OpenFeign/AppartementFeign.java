package com.amjad.reservation_service.OpenFeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "appartement-service")
public interface AppartementFeign {

    @GetMapping("/api/appartements/getAll")
    public String getAppartements();

    @GetMapping("/api/appartements/getAppartement/{id}")
    public String getAppartementById(Long id);


}
