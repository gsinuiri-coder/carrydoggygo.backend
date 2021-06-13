package com.gyasociety.carrydoggygoservice.domain.service;

import com.gyasociety.carrydoggygoservice.domain.model.WalkingSession;

import java.util.List;

public interface WalkingSessionService {

    WalkingSession createWalkingSession(WalkingSession walkingSession);
    List<WalkingSession> getAllWalkingSessionsByDogWalkerId(Long dogWalkerId);

    WalkingSession assignWalkingSessionDog(Long walkingSessionId, Long dogId);
    WalkingSession unAssignWalkingSessionDog(Long walkingSessionId, Long dogId);
    List<WalkingSession> getAllWalkingSessionsByDogId(Long dogId);
}
