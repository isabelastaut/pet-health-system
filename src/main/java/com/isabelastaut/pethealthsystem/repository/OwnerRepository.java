package com.isabelastaut.pethealthsystem.repository;

import com.isabelastaut.pethealthsystem.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, String> {
}
