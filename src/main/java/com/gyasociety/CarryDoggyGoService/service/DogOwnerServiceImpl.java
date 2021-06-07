package com.gyasociety.CarryDoggyGoService.service;

import com.gyasociety.CarryDoggyGoService.domain.model.DogOwner;
import com.gyasociety.CarryDoggyGoService.domain.repository.DogOwnerRepository;
import com.gyasociety.CarryDoggyGoService.domain.service.DogOwnerService;
import com.gyasociety.CarryDoggyGoService.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogOwnerServiceImpl implements DogOwnerService {
    
    @Autowired
    private DogOwnerRepository dogOwnerRepository;
    
    @Override
    public List<DogOwner> getAllDogOwners() {
        return dogOwnerRepository.findAll();
    }

    @Override
    public DogOwner getDogOwnerById(Long dogOwnerId) {
        return dogOwnerRepository.findById(dogOwnerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DogOwner", "Id", dogOwnerId));
    }

    @Override
    public DogOwner createDogOwner(DogOwner dogOwner) {
        return dogOwnerRepository.save(dogOwner);
    }

    @Override
    public DogOwner updateDogOwner(Long dogOwnerId, DogOwner dogOwnerRequest) {
        DogOwner dogOwner = dogOwnerRepository.findById(dogOwnerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DogOwner", "Id", dogOwnerId));

        return dogOwnerRepository.save(
                dogOwner.setAddress(dogOwnerRequest.getAddress())
        );
    }

    @Override
    public ResponseEntity<?> deleteDogOwner(Long dogOwnerId) {
        DogOwner dogOwner = dogOwnerRepository.findById(dogOwnerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DogOwner", "Id", dogOwnerId));
        dogOwnerRepository.delete(dogOwner);
        return ResponseEntity.ok().build();
    }

}
