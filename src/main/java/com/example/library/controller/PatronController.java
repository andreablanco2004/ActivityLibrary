package com.example.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.model.Patron;
import com.example.library.repository.PatronRepository;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {

    @Autowired
    private PatronRepository patronRepository;

    @GetMapping
    public List<Patron> getAllPatrons() {
        return patronRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Patron> getPatronById(@PathVariable Long id) {
        return patronRepository.findById(id);
    }

    @PostMapping
    public Patron createPatron(@RequestBody Patron patron) {
        return patronRepository.save(patron);
    }

    @PutMapping("/{id}")
    public Patron updatePatron(@PathVariable Long id, @RequestBody Patron patronDetails) {
        return patronRepository.findById(id).map(patron -> {
            patron.setFirstName(patronDetails.getFirstName());
            patron.setLastName(patronDetails.getLastName());
            patron.setEmail(patronDetails.getEmail());
            patron.setPhoneNumber(patronDetails.getPhoneNumber());
            patron.setState(patronDetails.getState());
            patron.setZipCode(patronDetails.getZipCode());
            patron.setDateOfBirth(patronDetails.getDateOfBirth());
            patron.setMembershipStatus(patronDetails.getMembershipStatus());
            patron.setLastVisit(patronDetails.getLastVisit());
            return patronRepository.save(patron);
        }).orElseGet(() -> {
            patronDetails.setPatronId(id);
            return patronRepository.save(patronDetails);
        });
    }

    @DeleteMapping("/{id}")
    public void deletePatron(@PathVariable Long id) {
        patronRepository.deleteById(id);
    }
}
