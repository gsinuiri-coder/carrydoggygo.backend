package com.gyasociety.CarryDoggyGoService.domain.repository;

import com.gyasociety.CarryDoggyGoService.domain.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DogRepository extends JpaRepository<Dog, Long> {
    List<Dog> findByDogOwnerId(Long dogOwnerId);
    Optional<Dog> findByIdAndDogOwnerId(Long id, Long dogOwnerId);
}