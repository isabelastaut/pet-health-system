package com.isabelastaut.pethealthsystem.domain;

import com.isabelastaut.pethealthsystem.domain.enums.DogBreed;
import com.isabelastaut.pethealthsystem.domain.enums.Sex;
import com.isabelastaut.pethealthsystem.domain.enums.Species;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="vaccination_cards")
@Getter
@Setter
public class VaccinationCard {

    @Setter(AccessLevel.NONE)
    @Id
    private String id;

    @Column(name="pet-name")
    private String petName;

    private Species species;

    @Column(name="microchip-no")
    private Integer microchipNo;

    @Column(name="birth-date")
    private Date birthDate; // check Date from SQL package

    private Sex sex;

    private DogBreed breed;

    private String color;

    @ManyToOne
    @JoinColumn(name="OwnerID")
    private Owner owner;

    public VaccinationCard() {
        this.id = UUID.randomUUID().toString();
    }

    public VaccinationCard(String petName, Species species, Integer microchipNo, Date birthDate, Sex sex, DogBreed breed, String color, Owner owner) {
        this.id = UUID.randomUUID().toString();
        this.petName = petName;
        this.species = species;
        this.microchipNo = microchipNo;
        this.birthDate = birthDate;
        this.sex = sex;
        this.breed = breed;
        this.color = color;
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccinationCard that = (VaccinationCard) o;
        return id.equals(that.id) && owner.equals(that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, owner);
    }
}
