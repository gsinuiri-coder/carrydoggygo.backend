package com.gyasociety.CarryDoggyGoService.domain.repository;

import com.gyasociety.CarryDoggyGoService.domain.model.DogOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogOwnerRepository extends JpaRepository<DogOwner, Long > {
//    public Optional<DogOwner> findByTitle(String title);
}
