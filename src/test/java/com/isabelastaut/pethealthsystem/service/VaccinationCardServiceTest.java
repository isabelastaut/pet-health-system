package com.isabelastaut.pethealthsystem.service;

import com.isabelastaut.pethealthsystem.domain.Owner;
import com.isabelastaut.pethealthsystem.domain.VaccinationCard;
import com.isabelastaut.pethealthsystem.domain.enums.DogBreed;
import com.isabelastaut.pethealthsystem.domain.enums.Sex;
import com.isabelastaut.pethealthsystem.domain.enums.Species;
import com.isabelastaut.pethealthsystem.repository.VaccinationCardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VaccinationCardServiceTest {

    @Mock
    private VaccinationCardRepository repository;

    @InjectMocks
    private VaccinationCardService service;

    @Test
    void createCardTest() {
        Owner dummyOwner = new Owner("Bela", "dummy address", 123456789);
        VaccinationCard dummyCard = new VaccinationCard ("Nelson", Species.DOG, 123456, new Date(2007-11-01), Sex.M, DogBreed.MIX, "Beige", dummyOwner);

        when(repository.save(any(VaccinationCard.class))).thenReturn(dummyCard);

        VaccinationCard savedCard = service.create(dummyCard);
        assertThat(savedCard).isNotNull();
    }

    @Test
    void findAllTest() {
        Owner dummyOwner = new Owner("Bela", "dummy address", 123456789);
        VaccinationCard dummyCard = new VaccinationCard ("Nelson", Species.DOG, 123456, new Date(2007-11-01), Sex.M, DogBreed.MIX, "Beige", dummyOwner);
        List<VaccinationCard> cardsList = new ArrayList<>();
        cardsList.add(dummyCard);

        when(repository.findAll()).thenReturn(cardsList);

        List<VaccinationCard> fetchedCards = service.findAll();
        assertThat(fetchedCards.size()).isGreaterThan(0);
    }

    @Test
    void findByIdTest() {
        Owner dummyOwner = new Owner("Bela", "dummy address", 123456789);
        VaccinationCard dummyCard = new VaccinationCard ("Nelson", Species.DOG, 123456, new Date(2007-11-01), Sex.M, DogBreed.MIX, "Beige", dummyOwner);
        String cardId = dummyCard.getId();

        when(repository.findById(cardId)).thenReturn(Optional.of(dummyCard));

        VaccinationCard fetchedCard = service.findById(cardId);
        assertThat(fetchedCard).isEqualTo(dummyCard);
    }

    @Test
    void updateTest() {
        Owner dummyOwner = new Owner("Bela", "dummy address", 123456789);
        VaccinationCard dummyCard = new VaccinationCard ("Nelson", Species.DOG, 123456, new Date(2007-11-01), Sex.M, DogBreed.MIX, "Beige", dummyOwner);
        VaccinationCard updatedCard = new VaccinationCard ("Badmilton", Species.DOG, 123456, new Date(2007-11-01), Sex.M, DogBreed.MIX, "Beige", dummyOwner);
        String cardId = dummyCard.getId();

        when(repository.findById(cardId)).thenReturn(Optional.of(dummyCard));
        when(repository.save(any(VaccinationCard.class))).thenReturn(updatedCard);

        VaccinationCard savedCard = service.update(cardId, updatedCard);
        assertThat(savedCard).isEqualTo(updatedCard);
    }

    @Test
    void deleteByIdTest() {
        Owner dummyOwner = new Owner("Bela", "dummy address", 123456789);
        VaccinationCard dummyCard = new VaccinationCard ("Nelson", Species.DOG, 123456, new Date(2007-11-01), Sex.M, DogBreed.MIX, "Beige", dummyOwner);
        String cardId = dummyCard.getId();

        when(repository.findById(cardId)).thenReturn(Optional.of(dummyCard));

        service.deleteById(cardId);
        verify(repository, times(1)).deleteById(cardId);
    }

}