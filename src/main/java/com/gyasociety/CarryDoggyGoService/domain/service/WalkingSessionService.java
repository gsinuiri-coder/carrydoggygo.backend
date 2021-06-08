package com.gyasociety.CarryDoggyGoService.domain.service;

import com.gyasociety.CarryDoggyGoService.domain.model.WalkingSession;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WalkingSessionService {

//    List<WalkingSession> getAllWalkingSessions();
//    WalkingSession getWalkingSessionById(Long walkingSessionId);
    WalkingSession createWalkingSession(WalkingSession walkingSession);
//    WalkingSession updateWalkingSession(Long walkingSessionId, WalkingSession walkingSessionRequest);
//    ResponseEntity<?> deleteWalkingSession(Long walkingSessionId);
//    WalkingSession assignWalkingSessionTag(Long walkingSessionId, Long tagId);
//    WalkingSession unassignWalkingSessionTag(Long walkingSessionId, Long tagId);

    List<WalkingSession> getAllWalkingSessionsByDogWalkerId(Long dogWalkerId);
}
