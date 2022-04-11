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
public class VaccinationCard extends BaseEntity {

    @Setter(AccessLevel.NONE)
    @Id
    private String id;

    private String petName;

    private Species species;

    private Integer microchipNo;

    private Date birthDate;

    private Sex sex;

    private DogBreed breed;

    private String color;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    public VaccinationCard(String petName, Species species, Integer microchipNo, Date birthDate, Sex sex, DogBreed breed, String color, Owner owner) {
        super();
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
