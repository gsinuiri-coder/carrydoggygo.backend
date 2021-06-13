package com.gyasociety.carrydoggygoservice.service;

import com.gyasociety.carrydoggygoservice.domain.model.Dog;
import com.gyasociety.carrydoggygoservice.domain.repository.DogOwnerRepository;
import com.gyasociety.carrydoggygoservice.domain.repository.DogRepository;
import com.gyasociety.carrydoggygoservice.domain.service.DogService;
import com.gyasociety.carrydoggygoservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private DogOwnerRepository dogOwnerRepository;

    @Override
    public List<Dog> getAllDogsByDogOwnerId(Long dogOwnerId) {
        return dogRepository.findByDogOwnerId(dogOwnerId);
    }

    @Override
    public Dog getDogByIdAndDogOwnerId(Long dogOwnerId, Long dogId) {
        return dogRepository.findByIdAndDogOwnerId(dogId, dogOwnerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Dog not found with Id " + dogId +
                                " and DogOwnerId " + dogOwnerId));
    }

    @Override
    public Dog createDog(Long dogOwnerId, Dog dog) {
        return dogOwnerRepository.findById(dogOwnerId).map(dogOwner -> {
            dog.setDogOwner(dogOwner);
            return dogRepository.save(dog);
        }).orElseThrow(() -> new ResourceNotFoundException(
                "DogOwner", "Id", dogOwnerId));
    }

    @Override
    public Dog updateDog(Long dogOwnerId, Long dogId, Dog dogDetails) {
        if(!dogOwnerRepository.existsById(dogOwnerId))
            throw new ResourceNotFoundException("DogOwner", "Id", dogOwnerId);

        return dogRepository.findById(dogId).map(dog -> {
            dog.setName(dogDetails.getName());
            return dogRepository.save(dog);
        }).orElseThrow(() -> new ResourceNotFoundException("Dog", "Id", dogId));
    }

    @Override
    public ResponseEntity<?> deleteDog(Long dogOwnerId, Long dogId) {
        return dogRepository.findByIdAndDogOwnerId(dogId, dogOwnerId).map(dog -> {
            dogRepository.delete(dog);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(
                "Dog not found with Id " + dogId + " and DogOwnerId " + dogOwnerId));
    }
}
