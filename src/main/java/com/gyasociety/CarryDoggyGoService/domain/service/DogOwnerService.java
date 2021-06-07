package com.gyasociety.CarryDoggyGoService.domain.service;

import com.gyasociety.CarryDoggyGoService.domain.model.DogOwner;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DogOwnerService {

    List<DogOwner> getAllDogOwners();
    DogOwner getDogOwnerById(Long dogOwnerId);
    DogOwner createDogOwner(DogOwner dogOwner);
    DogOwner updateDogOwner(Long dogOwnerId, DogOwner dogOwnerRequest);
    ResponseEntity<?> deleteDogOwner(Long dogOwnerId);
//    DogOwner assignDogOwnerTag(Long dogOwnerId, Long tagId);
//    DogOwner unassignDogOwnerTag(Long dogOwnerId, Long tagId);
//    Page<DogOwner> getAllDogOwnersByTagId(Long tagId, Pageable pageable);
//    DogOwner getDogOwnerByTitle(String title);
}
