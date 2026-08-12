package com.myPet.Controller;

import com.myPet.Entity.Owner;
import com.myPet.Service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @GetMapping
    public ResponseEntity<Optional<Owner>> searchByID(@RequestParam Long id) {
        Optional<Owner> searchResult = ownerService.searchByID(id);

        if(searchResult.isPresent()) {
            return ResponseEntity.ok(searchResult);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
