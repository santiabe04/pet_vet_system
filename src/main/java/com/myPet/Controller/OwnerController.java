package com.myPet.Controller;

import com.myPet.Entity.Owner;
import com.myPet.Exception.DuplicateUniqueDataEntry;
import com.myPet.Exception.ResourceNotFoundException;
import com.myPet.Service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    // Create
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Owner owner) {
        try {
            Owner createResult = ownerService.create(owner);
            return ResponseEntity.status(HttpStatus.CREATED).body(createResult);
        }
        catch (DuplicateUniqueDataEntry e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    // Read
    @GetMapping
    public ResponseEntity<List<Owner>> readAll() {
        return ResponseEntity.ok(ownerService.readAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Owner> readByID(@PathVariable Long id) {
        // Check got id (400)
        try {
            return ResponseEntity.ok(ownerService.readByID(id));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Owner owner) {
        try {
            return ResponseEntity.ok(ownerService.update(id, owner));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (DuplicateUniqueDataEntry e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            ownerService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
