package com.gyasociety.CarryDoggyGoService.controller;

import com.gyasociety.CarryDoggyGoService.domain.model.DogWalker;
import com.gyasociety.CarryDoggyGoService.domain.model.WalkingSession;
import com.gyasociety.CarryDoggyGoService.domain.service.DogWalkerService;
import com.gyasociety.CarryDoggyGoService.domain.service.WalkingSessionService;
import com.gyasociety.CarryDoggyGoService.resource.DogWalkerResource;
import com.gyasociety.CarryDoggyGoService.resource.SaveDogWalkerResource;
import com.gyasociety.CarryDoggyGoService.resource.SaveWalkingSessionResource;
import com.gyasociety.CarryDoggyGoService.resource.WalkingSessionResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@Tag(name = "DogWalkers")
@RestController
@RequestMapping("/api")
public class DogWalkerWalkingSessionsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DogWalkerService dogWalkerService;

    @Autowired
    private WalkingSessionService walkingSessionService;

    @GetMapping("/dogWalkers/{dogWalkerId}/walkingSessions")
    public List<WalkingSessionResource> getAllWalkingSessionsByDogWalkerId(@PathVariable(name = "dogWalkerId") Long dogWalkerId) {
        return walkingSessionService.getAllWalkingSessionsByDogWalkerId(dogWalkerId)
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
    }

    private WalkingSession convertToEntity(SaveWalkingSessionResource resource) {
        return mapper.map(resource, WalkingSession.class);
    }
    private WalkingSessionResource convertToResource(WalkingSession entity) {
        return mapper.map(entity, WalkingSessionResource.class);
    }

    private DogWalker convertToEntity(SaveDogWalkerResource resource) {
        return mapper.map(resource, DogWalker.class);
    }
    private DogWalkerResource convertToResource(DogWalker entity) {
        return mapper.map(entity, DogWalkerResource.class);
    }

}
