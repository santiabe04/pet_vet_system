package com.myPet.Service;

import com.myPet.Entity.Appointment;
import com.myPet.Repository.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Optional<Appointment> searchByID(Long id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> listAll(){
        return appointmentRepository.findAll();
    }

    public void delete(Long id){
        appointmentRepository.deleteById(id);
    }
}
