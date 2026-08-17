package com.myPet.Repository;

import com.myPet.Entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
    boolean existsByDocument(String document);

    boolean existsByPhone(String phone);

    boolean existsByPhoneAndIdNot(String phone, Long id);

    boolean existsByMail(String mail);

    boolean existsByMailAndIdNot(String mail, Long id);

    Optional<Owner> findByMail(String mail);
}
