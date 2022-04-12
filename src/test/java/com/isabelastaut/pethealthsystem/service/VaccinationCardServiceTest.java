package com.isabelastaut.pethealthsystem.service;

import com.isabelastaut.pethealthsystem.domain.Owner;
import com.isabelastaut.pethealthsystem.domain.VaccinationCard;
import com.isabelastaut.pethealthsystem.repository.VaccinationCardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VaccinationCardServiceTest {

    @Mock
    private VaccinationCardRepository repository;

    @InjectMocks
    private VaccinationCardService service;
    
}