package com.isabelastaut.pethealthsystem.controller;

import com.isabelastaut.pethealthsystem.domain.Owner;
import com.isabelastaut.pethealthsystem.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService service;


    @PostMapping
    public ResponseEntity<Owner> create(@RequestBody Owner owner, HttpServletResponse response) {
        Owner newOwner = service.create(owner);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOwner);
    }

    @GetMapping
    public ResponseEntity<List<Owner>> findAll() {
        List<Owner> owners = service.findAll();
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable String id) {
        Owner owner = service.findById(id);
        return ResponseEntity.ok(owner);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Owner> update(@PathVariable String id, @RequestBody Owner updatedOwner) {
        Owner owner = service.update(id, updatedOwner);
        return ResponseEntity.ok(owner);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
}
