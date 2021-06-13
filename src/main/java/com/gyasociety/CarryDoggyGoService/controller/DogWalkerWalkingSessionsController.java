package com.gyasociety.carrydoggygoservice.controller;

import com.gyasociety.carrydoggygoservice.domain.model.DogWalker;
import com.gyasociety.carrydoggygoservice.domain.model.WalkingSession;
import com.gyasociety.carrydoggygoservice.domain.service.DogWalkerService;
import com.gyasociety.carrydoggygoservice.domain.service.WalkingSessionService;
import com.gyasociety.carrydoggygoservice.resource.DogWalkerResource;
import com.gyasociety.carrydoggygoservice.resource.SaveDogWalkerResource;
import com.gyasociety.carrydoggygoservice.resource.SaveWalkingSessionResource;
import com.gyasociety.carrydoggygoservice.resource.WalkingSessionResource;
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

    @GetMapping("/dogwalkers/{dogWalkerId}/walkingsessions")
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
