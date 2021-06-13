package com.gyasociety.carrydoggygoservice.domain.service;

import com.gyasociety.carrydoggygoservice.domain.model.DogWalker;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DogWalkerService {

    List<DogWalker> getAllDogWalkers();
    DogWalker getDogWalkerById(Long dogWalkerId);
    DogWalker createDogWalker(DogWalker dogWalker);
    DogWalker updateDogWalker(Long dogWalkerId, DogWalker dogWalkerRequest);
    ResponseEntity<?> deleteDogWalker(Long dogWalkerId);
}
