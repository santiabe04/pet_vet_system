package com.myPet.Controller;

import com.myPet.Entity.Pet;
import com.myPet.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/pet")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<Optional<Pet>> searchByID(@RequestParam Long id) {
        Optional<Pet> searchResult = petService.searchByID(id);

        if(searchResult.isPresent()) {
            return ResponseEntity.ok(searchResult);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
