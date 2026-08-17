package com.myPet.Service;

import com.myPet.Entity.Owner;
import com.myPet.Exception.DuplicateUniqueDataEntry;
import com.myPet.Exception.ResourceNotFoundException;
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

    // Utils
    public boolean isPhoneTaken(Long id, String phone) {
        if (id == null) {
            return ownerRepository.existsByPhone(phone);
        }
        return ownerRepository.existsByPhoneAndIdNot(phone, id);
    }

    public boolean isMailTaken(Long id, String mail) {
        if (id == null) {
            return ownerRepository.existsByMail(mail);
        }
        return ownerRepository.existsByMailAndIdNot(mail, id);
    }

    // Create
    public Owner create(Owner owner) {
        // Check unique document
        if(ownerRepository.existsByDocument(owner.getDocument())) {
            throw new DuplicateUniqueDataEntry("Owner with document " + owner.getDocument() + " already exists");
        }
        // Check unique phone
        if(isPhoneTaken(null, owner.getPhone())) {
            throw new DuplicateUniqueDataEntry("Phone " + owner.getPhone() + " already used");
        }
        // Check unique mail
        if(isMailTaken(null, owner.getMail())) {
            throw new DuplicateUniqueDataEntry("Mail " + owner.getMail() + " already used");
        }
        return ownerRepository.save(owner);
    }

    // Read
    public List<Owner> readAll(){
        return ownerRepository.findAll();
    }

    public Owner readByID(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner", id));
    }

    // Update
    public Owner update(Long id, Owner updatedOwner) {
        Owner owner = readByID(id);

        owner.setName(updatedOwner.getName());
        owner.setSurname(updatedOwner.getSurname());
        // Check unique phone
        if(isPhoneTaken(id, updatedOwner.getPhone())) {
            throw new DuplicateUniqueDataEntry("Phone " + updatedOwner.getPhone() + " already used");
        }
        owner.setPhone(updatedOwner.getPhone());
        // Check unique mail
        if(isMailTaken(id, updatedOwner.getMail())) {
            throw new DuplicateUniqueDataEntry("Mail " + updatedOwner.getMail() + " already used");
        }
        owner.setMail(updatedOwner.getMail());

        return ownerRepository.save(owner);
    }

    // Delete
    public void delete(Long id){
        Owner owner = readByID(id);
        ownerRepository.deleteById(id);
    }
}
