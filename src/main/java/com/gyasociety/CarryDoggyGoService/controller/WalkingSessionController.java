package com.gyasociety.carrydoggygoservice.controller;

import com.gyasociety.carrydoggygoservice.domain.model.WalkingSession;
import com.gyasociety.carrydoggygoservice.domain.service.WalkingSessionService;
import com.gyasociety.carrydoggygoservice.resource.SaveWalkingSessionResource;
import com.gyasociety.carrydoggygoservice.resource.WalkingSessionResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@Tag(name = "WalkingSessions", description = "WalkingSessions API")
@RestController
@RequestMapping("/api")
public class WalkingSessionController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private WalkingSessionService walkingSessionService;

    @PostMapping("/walkingsessions")
    public WalkingSessionResource createWalkingSession(@Valid @RequestBody SaveWalkingSessionResource resource) {
        WalkingSession walkingSession = convertToEntity(resource);
        return convertToResource(walkingSessionService.createWalkingSession(walkingSession));
    }

    private WalkingSession convertToEntity(SaveWalkingSessionResource resource) {
        return mapper.map(resource, WalkingSession.class);
    }
    private WalkingSessionResource convertToResource(WalkingSession entity) {
        return mapper.map(entity, WalkingSessionResource.class);
    }
}
