package com.gyasociety.CarryDoggyGoService.domain.service;

import com.gyasociety.CarryDoggyGoService.domain.model.Dog;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DogService {
    List<Dog> getAllDogsByDogOwnerId(Long dogOwnerId);
    Dog getDogByIdAndDogOwnerId(Long dogOwnerId, Long dogId);
    Dog createDog(Long dogOwnerId, Dog dog);
    Dog updateDog(Long dogOwnerId, Long dogId, Dog dogDetails);
    ResponseEntity<?> deleteDog(Long dogOwnerId, Long dogId);
}
