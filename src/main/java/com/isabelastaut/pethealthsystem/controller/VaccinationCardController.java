package com.isabelastaut.pethealthsystem.controller;

import com.isabelastaut.pethealthsystem.domain.VaccinationCard;
import com.isabelastaut.pethealthsystem.service.VaccinationCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/vaccinationcards")
public class VaccinationCardController {

    @Autowired
    VaccinationCardService service;

    @PostMapping
    public ResponseEntity<VaccinationCard> create(@RequestBody VaccinationCard card, HttpServletResponse response) {
        VaccinationCard newCard = service.create(card);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCard);
    }

    @GetMapping
    ResponseEntity<List<VaccinationCard>> findAll() {
        List<VaccinationCard> cards = service.findAll();
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        VaccinationCard card = service.findById(id);
        return ResponseEntity.ok(card);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VaccinationCard> update(@PathVariable String id, @RequestBody VaccinationCard updatedCard) {
        VaccinationCard card = service.update(id, updatedCard);
        return ResponseEntity.ok(card);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
