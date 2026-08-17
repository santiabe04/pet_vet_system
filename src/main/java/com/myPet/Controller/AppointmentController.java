package com.myPet.Controller;

import com.myPet.Entity.Appointment;
import com.myPet.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<Optional<Appointment>> searchByID(@RequestParam Long id) {
        Optional<Appointment> searchResult = appointmentService.searchByID(id);

        if(searchResult.isPresent()) {
            return ResponseEntity.ok(searchResult);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
