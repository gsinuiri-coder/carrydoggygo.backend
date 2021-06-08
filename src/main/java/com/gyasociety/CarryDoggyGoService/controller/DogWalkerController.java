package com.gyasociety.CarryDoggyGoService.controller;

import com.gyasociety.CarryDoggyGoService.domain.model.DogWalker;
import com.gyasociety.CarryDoggyGoService.domain.service.DogWalkerService;
import com.gyasociety.CarryDoggyGoService.resource.DogWalkerResource;
import com.gyasociety.CarryDoggyGoService.resource.SaveDogWalkerResource;
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
@Tag(name="DogWalkers", description = "DogWalker API")
@RestController
@RequestMapping("/api")
public class DogWalkerController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DogWalkerService dogWalkerService;

    @Operation(summary = "Get All DogWalkers", description = "Get All available DogWalkers", responses = {
            @ApiResponse(
                    description = "All DogWalkers",
                    responseCode = "200",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/dogWalkers")
    public List<DogWalkerResource> getAllDogWalkers() {
        return dogWalkerService.getAllDogWalkers()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
    }

    @GetMapping("/dogWalkers/{dogWalkerId}")
    public DogWalkerResource getDogWalkerById(@PathVariable(value = "dogWalkerId") Long dogWalkerId) {
        return convertToResource(dogWalkerService.getDogWalkerById(dogWalkerId));
    }

    @PostMapping("/dogWalkers")
    public DogWalkerResource createDogWalker( @Valid @RequestBody SaveDogWalkerResource resource) {

        DogWalker dogWalker = convertToEntity(resource);

        return convertToResource(dogWalkerService.createDogWalker(dogWalker));

    }

    @PutMapping("/dogWalkers/{dogWalkerId}")
    public DogWalkerResource updateDogWalker(@PathVariable Long dogWalkerId,
                                           @Valid @RequestBody SaveDogWalkerResource resource) {
        DogWalker dogWalker = convertToEntity(resource);
        return convertToResource(
                dogWalkerService.updateDogWalker(dogWalkerId, dogWalker));
    }

    @DeleteMapping("/dogWalkers/{dogWalkerId}")
    public ResponseEntity<?> deleteDogWalker(@PathVariable Long dogWalkerId) {
        return dogWalkerService.deleteDogWalker(dogWalkerId);
    }


    private DogWalker convertToEntity(SaveDogWalkerResource resource) {
        return mapper.map(resource, DogWalker.class);
    }

    private DogWalkerResource convertToResource(DogWalker entity) {
        return mapper.map(entity, DogWalkerResource.class);
    }
}
