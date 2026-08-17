package com.myPet.Controller;

import com.myPet.Entity.Vet;
import com.myPet.Service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/vet")
public class VetController {
    @Autowired
    private VetService vetService;

    @GetMapping
    public ResponseEntity<Optional<Vet>> searchByID(@RequestParam Long id) {
        Optional<Vet> searchResult = vetService.searchByID(id);

        if(searchResult.isPresent()) {
            return ResponseEntity.ok(searchResult);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
