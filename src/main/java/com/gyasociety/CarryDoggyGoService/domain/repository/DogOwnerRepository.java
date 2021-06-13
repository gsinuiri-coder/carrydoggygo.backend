package com.gyasociety.carrydoggygoservice.domain.repository;

import com.gyasociety.carrydoggygoservice.domain.model.DogOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogOwnerRepository extends JpaRepository<DogOwner, Long > {
//    public Optional<DogOwner> findByTitle(String title);
}
