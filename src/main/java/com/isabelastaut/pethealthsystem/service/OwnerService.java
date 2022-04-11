package com.isabelastaut.pethealthsystem.service;

import com.isabelastaut.pethealthsystem.domain.Owner;
import com.isabelastaut.pethealthsystem.repository.OwnerRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository repository;

    @Transactional
    public Owner create(Owner owner) {
        return repository.save(owner);
    }

    @Transactional(readOnly = true)
    public List<Owner> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Owner findById(String id) {
        Optional<Owner> owner = repository.findById(id);
        return owner.orElseThrow(() -> new ObjectNotFoundException("Object not found", "owner"));
    }

    @Transactional
    public Owner update(String id, Owner updatedOwner) {
        Owner existingOwner = findById(id);
        updateData(existingOwner, updatedOwner);
        return repository.save(existingOwner);
    }

    private void updateData(Owner existingOwner, Owner updatedOwner) {
        existingOwner.setAddress(updatedOwner.getAddress());
        existingOwner.setName(updatedOwner.getName());
        existingOwner.setPersonnummer(updatedOwner.getPersonnummer());
    }

    @Transactional
    public void deleteById(String id) {
        findById(id);
        repository.deleteById(id);
    }
}