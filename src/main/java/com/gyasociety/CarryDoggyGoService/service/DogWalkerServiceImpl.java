package com.gyasociety.carrydoggygoservice.service;

import com.gyasociety.carrydoggygoservice.domain.model.DogWalker;
import com.gyasociety.carrydoggygoservice.domain.repository.DogWalkerRepository;
import com.gyasociety.carrydoggygoservice.domain.service.DogWalkerService;
import com.gyasociety.carrydoggygoservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogWalkerServiceImpl implements DogWalkerService {

    @Autowired
    private DogWalkerRepository dogWalkerRepository;

    @Override
    public List<DogWalker> getAllDogWalkers() {
        return dogWalkerRepository.findAll();
    }

    @Override
    public DogWalker getDogWalkerById(Long dogWalkerId) {
        return dogWalkerRepository.findById(dogWalkerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DogWalker", "Id", dogWalkerId));
    }

    @Override
    public DogWalker createDogWalker(DogWalker dogWalker) {
        return dogWalkerRepository.save(dogWalker);
    }

    @Override
    public DogWalker updateDogWalker(Long dogWalkerId, DogWalker dogWalkerRequest) {
        DogWalker dogWalker = dogWalkerRepository.findById(dogWalkerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DogWalker", "Id", dogWalkerId));

        return dogWalkerRepository.save(
                dogWalker.setDescription(dogWalkerRequest.getDescription())
        );
    }

    @Override
    public ResponseEntity<?> deleteDogWalker(Long dogWalkerId) {
        DogWalker dogWalker = dogWalkerRepository.findById(dogWalkerId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DogWalker", "Id", dogWalkerId));
        dogWalkerRepository.delete(dogWalker);
        return ResponseEntity.ok().build();
    }
}
