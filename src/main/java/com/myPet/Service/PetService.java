package com.myPet.Service;

import com.myPet.Entity.Pet;
import com.myPet.Repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetService {
    private final PetRepository petRepository;

    public Optional<Pet> searchByID(Long id) {
        return petRepository.findById(id);
    }

    public List<Pet> listAll(){
        return petRepository.findAll();
    }

    public void delete(Long id){
        petRepository.deleteById(id);
    }
}
