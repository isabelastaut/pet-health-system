package com.isabelastaut.pethealthsystem.domain;

import lombok.Getter;

import javax.persistence.Entity;
import java.util.UUID;

@Entity
@Getter
public abstract class BaseEntity {
    private String id;

    public BaseEntity() {
        this.id = UUID.randomUUID().toString();
    }
}
