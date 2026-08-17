package com.myPet.Service;

import com.myPet.Entity.Vet;
import com.myPet.Repository.VetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class VetService {
    private final VetRepository vetRepository;

    public Vet register(Vet vet) {
        return vetRepository.save(vet);
    }

    public Optional<Vet> searchByID(Long id){
        return vetRepository.findById(id);
    }

    public List<Vet> listAll(){
        return vetRepository.findAll();
    }

    public void delete(Long id){
        vetRepository.deleteById(id);
    }
}
