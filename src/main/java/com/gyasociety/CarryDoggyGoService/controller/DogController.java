package com.gyasociety.CarryDoggyGoService.controller;

import com.gyasociety.CarryDoggyGoService.domain.model.Dog;
import com.gyasociety.CarryDoggyGoService.domain.service.DogService;
import com.gyasociety.CarryDoggyGoService.resource.DogResource;
import com.gyasociety.CarryDoggyGoService.resource.SaveDogResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@Tag(name = "Dogs", description = "Dogs API")
@RestController
@RequestMapping("/api")
public class DogController {

    @Autowired
    private DogService dogService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/dogOwners/{dogOwnerId}/dogs")
    public List<DogResource> getAllDogsByDogOwnerId( @PathVariable (value = "dogOwnerId") Long dogOwnerId) {
        return dogService.getAllDogsByDogOwnerId(dogOwnerId)
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
    }

    @GetMapping("/dogOwners/{dogOwnerId}/dogs/{dogId}")
    public DogResource getDogByIdAndDogOwnerId(
            @PathVariable(name = "dogOwnerId") Long dogOwnerId,
            @PathVariable(name = "dogId") Long dogId) {
        return convertToResource(dogService.getDogByIdAndDogOwnerId(dogOwnerId, dogId));
    }

    @PostMapping("/dogOwners/{dogOwnerId}/dogs")
    public DogResource createDog(
            @PathVariable(value = "dogOwnerId") Long dogOwnerId,
            @Valid @RequestBody SaveDogResource resource) {
        return convertToResource(dogService.createDog(dogOwnerId,
                convertToEntity(resource)));
    }

    @PutMapping("/dogOwners/{dogOwnerId}/dogs/{dogId}")
    public DogResource updateDog(
            @PathVariable (value = "dogOwnerId") Long dogOwnerId,
            @PathVariable (value = "dogId") Long dogId,
            @Valid @RequestBody SaveDogResource resource) {
        return convertToResource(dogService.updateDog(dogOwnerId, dogId,
                convertToEntity(resource)));
    }

    @DeleteMapping("/dogOwners/{dogOwnerId}/dogs/{dogId}")
    public ResponseEntity<?> deleteDog(
            @PathVariable (value = "dogOwnerId") Long dogOwnerId,
            @PathVariable (value = "dogId") Long dogId) {
        return dogService.deleteDog(dogOwnerId, dogId);
    }

    private Dog convertToEntity(SaveDogResource resource) {
        return mapper.map(resource, Dog.class);
    }

    private DogResource convertToResource(Dog entity) {
        return mapper.map(entity, DogResource.class);
    }
}
