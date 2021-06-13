package com.gyasociety.carrydoggygoservice.controller;

import com.gyasociety.carrydoggygoservice.domain.model.DogOwner;
import com.gyasociety.carrydoggygoservice.domain.service.DogOwnerService;
import com.gyasociety.carrydoggygoservice.resource.DogOwnerResource;
import com.gyasociety.carrydoggygoservice.resource.SaveDogOwnerResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@Tag(name="DogOwners", description = "DogOwner API")
@RestController
@RequestMapping("/api")
public class DogOwnerController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DogOwnerService dogOwnerService;

    @Operation(summary = "Get All DogOwners", description = "Get All available DogOwners", responses = {
            @ApiResponse(
                    description = "All DogOwners",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/dogowners")
    public List<DogOwnerResource> getAllDogOwners() {
        return dogOwnerService.getAllDogOwners()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
    }

    @GetMapping("/dogowners/{dogOwnerId}")
    public DogOwnerResource getDogOwnerById(@PathVariable(value = "dogOwnerId") Long dogOwnerId) {
        return convertToResource(dogOwnerService.getDogOwnerById(dogOwnerId));
    }

    @PostMapping("/dogowners")
    public DogOwnerResource createDogOwner( @Valid @RequestBody SaveDogOwnerResource resource) {

        DogOwner dogOwner = convertToEntity(resource);
        return convertToResource(dogOwnerService.createDogOwner(dogOwner));

    }

    @PutMapping("/dogowners/{dogOwnerId}")
    public DogOwnerResource updateDogOwner(@PathVariable Long dogOwnerId,
                                           @Valid @RequestBody SaveDogOwnerResource resource) {
        DogOwner dogOwner = convertToEntity(resource);
        return convertToResource(
                dogOwnerService.updateDogOwner(dogOwnerId, dogOwner));
    }

    @DeleteMapping("/dogowners/{dogOwnerId}")
    public ResponseEntity<?> deleteDogOwner(@PathVariable Long dogOwnerId) {
        return dogOwnerService.deleteDogOwner(dogOwnerId);
    }

    private DogOwner convertToEntity(SaveDogOwnerResource resource) {
        return mapper.map(resource, DogOwner.class);
    }

    private DogOwnerResource convertToResource(DogOwner entity) {
        return mapper.map(entity, DogOwnerResource.class);
    }
}
