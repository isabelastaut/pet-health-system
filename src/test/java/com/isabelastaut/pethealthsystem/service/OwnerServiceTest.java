package com.isabelastaut.pethealthsystem.service;

import com.isabelastaut.pethealthsystem.domain.Owner;
import com.isabelastaut.pethealthsystem.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceTest {

    @Mock
    private OwnerRepository repository;

    @InjectMocks
    private OwnerService service;

    @Test
    void createOwnerTest() {
        Owner dummyOwner = new Owner("Bela", "dummy address", 123456789);

        when(repository.save(any(Owner.class))).thenReturn(dummyOwner);

        Owner savedOwner = service.create(dummyOwner);
        assertThat(savedOwner).isNotNull();
    }

    @Test
    void findAllTest() {
        Owner dummyOwner = new Owner("Bela", "dummy address", 123456789);
        List<Owner> ownersList = new ArrayList<>();
        ownersList.add(dummyOwner);

        when(repository.findAll()).thenReturn(ownersList);

        List<Owner> fetchedOwners = service.findAll();
        assertThat(fetchedOwners.size()).isGreaterThan(0);
    }

    @Test
    void findByIdTest() {
        Owner dummyOwner = new Owner("Bela", "dummy address", 123456789);
        String ownerId = dummyOwner.getId();

        when(repository.findById(ownerId)).thenReturn(Optional.of(dummyOwner));

        Owner fetchedOwner = service.findById(ownerId);
        assertThat(fetchedOwner).isEqualTo(dummyOwner);
    }

    @Test
    void updateTest() {
        Owner dummyOwner = new Owner("Bela", "dummy address", 123456789);
        String ownerId = dummyOwner.getId();
        Owner updatedOwner = new Owner("Isabela", "dummy address", 123456789);

        when(repository.findById(ownerId)).thenReturn(Optional.of(dummyOwner));
        when(repository.save(any(Owner.class))).thenReturn(updatedOwner);

        Owner savedOwner = service.update(ownerId, updatedOwner);
        assertThat(savedOwner).isEqualTo(updatedOwner);
    }

    @Test
    void deleteByIdTest() {
        Owner dummyOwner = new Owner("Bela", "dummy address", 123456789);
        String ownerId = dummyOwner.getId();

        when(repository.findById(ownerId)).thenReturn(Optional.of(dummyOwner));

        service.deleteById(ownerId);
        verify(repository, times(1)).deleteById(ownerId);
    }
}