package com.myPet.Service;

import com.myPet.Entity.Owner;
import com.myPet.Repository.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public Owner register(Owner owner) {
        return ownerRepository.save(owner);
    }

    public Optional<Owner> searchByID(Long id){
        return ownerRepository.findById(id);
    }

    public List<Owner> listAll(){
        return ownerRepository.findAll();
    }

    public void delete(Long id){
        ownerRepository.deleteById(id);
    }
}
