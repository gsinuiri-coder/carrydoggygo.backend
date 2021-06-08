package com.gyasociety.CarryDoggyGoService.service;

import com.gyasociety.CarryDoggyGoService.domain.model.DogWalker;
import com.gyasociety.CarryDoggyGoService.domain.model.WalkingSession;
import com.gyasociety.CarryDoggyGoService.domain.repository.DogWalkerRepository;
import com.gyasociety.CarryDoggyGoService.domain.repository.WalkingSessionRepository;
import com.gyasociety.CarryDoggyGoService.domain.service.WalkingSessionService;
import com.gyasociety.CarryDoggyGoService.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalkingSessionServiceImpl implements WalkingSessionService {

    @Autowired
    private WalkingSessionRepository walkingSessionRepository;

    @Autowired
    private DogWalkerRepository dogWalkerRepository;

    @Override
    public WalkingSession createWalkingSession(WalkingSession walkingSession) {
        DogWalker dogWalker = dogWalkerRepository.findById(walkingSession.getDogWalkerId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DogWalker", "Id", walkingSession.getDogWalkerId()));


        walkingSession.setDogWalker(dogWalker);

        return walkingSessionRepository.save(walkingSession);
    }

    @Override
    public List<WalkingSession> getAllWalkingSessionsByDogWalkerId(Long dogWalkerId) {
        return dogWalkerRepository.findById(dogWalkerId).map(DogWalker::getWalkingSessions)
                .orElseThrow(() -> new ResourceNotFoundException("DogWalker", "Id", dogWalkerId));
    }
}
