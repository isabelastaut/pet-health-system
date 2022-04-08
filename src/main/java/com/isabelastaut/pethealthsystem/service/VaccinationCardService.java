package com.isabelastaut.pethealthsystem.service;

import com.isabelastaut.pethealthsystem.domain.VaccinationCard;
import com.isabelastaut.pethealthsystem.repository.VaccinationCardRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VaccinationCardService {

    @Autowired
    private VaccinationCardRepository repository;

    @Transactional
    public VaccinationCard create(VaccinationCard card) {
        return repository.save(card);
    }

    @Transactional(readOnly = true)
    public List<VaccinationCard> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public VaccinationCard findById(String id) {
        Optional<VaccinationCard> card = repository.findById(id);
        return card.orElseThrow(() -> new ObjectNotFoundException("Object not found", "vaccination card"));
    }

    @Transactional
    public VaccinationCard update(String id, VaccinationCard updatedCard) {
        VaccinationCard existingCard = findById(id);
        updateData(existingCard, updatedCard);
        return repository.save(existingCard);
    }

    private void updateData(VaccinationCard existingCard, VaccinationCard updatedCard) {
        existingCard.setBirthDate(updatedCard.getBirthDate());
        existingCard.setBreed(updatedCard.getBreed());
        existingCard.setColor(updatedCard.getColor());
        existingCard.setMicrochipNo(updatedCard.getMicrochipNo());
        existingCard.setOwner(updatedCard.getOwner());
        existingCard.setPetName(updatedCard.getPetName());
        existingCard.setSex(updatedCard.getSex());
        existingCard.setSpecies(updatedCard.getSpecies());
    }

    @Transactional
    public void deleteById(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
