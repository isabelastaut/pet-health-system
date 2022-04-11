package com.isabelastaut.pethealthsystem.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="owners")
@Getter
@Setter
public class Owner extends BaseEntity {

    @Setter(AccessLevel.NONE)
    @Id
    private String id;

    private String name;

    private String address;

    private Integer personnummer;

    public Owner(String name, String address, Integer personnummer) {
        super();
        this.name = name;
        this.address = address;
        this.personnummer = personnummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id.equals(owner.id) && personnummer.equals(owner.personnummer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, personnummer);
    }
}
