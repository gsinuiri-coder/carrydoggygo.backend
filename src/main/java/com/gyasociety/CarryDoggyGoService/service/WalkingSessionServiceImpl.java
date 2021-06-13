package com.gyasociety.carrydoggygoservice.service;

import com.gyasociety.carrydoggygoservice.domain.model.Dog;
import com.gyasociety.carrydoggygoservice.domain.model.DogWalker;
import com.gyasociety.carrydoggygoservice.domain.model.PaymentType;
import com.gyasociety.carrydoggygoservice.domain.model.WalkingSession;
import com.gyasociety.carrydoggygoservice.domain.repository.DogRepository;
import com.gyasociety.carrydoggygoservice.domain.repository.DogWalkerRepository;
import com.gyasociety.carrydoggygoservice.domain.repository.PaymentTypeRepository;
import com.gyasociety.carrydoggygoservice.domain.repository.WalkingSessionRepository;
import com.gyasociety.carrydoggygoservice.domain.service.WalkingSessionService;
import com.gyasociety.carrydoggygoservice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalkingSessionServiceImpl implements WalkingSessionService {

    @Autowired
    private WalkingSessionRepository walkingSessionRepository;

    @Autowired
    private DogWalkerRepository dogWalkerRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Autowired
    private DogRepository dogRepository;

    @Override
    public WalkingSession createWalkingSession(WalkingSession walkingSession) {
        DogWalker dogWalker = dogWalkerRepository.findById(walkingSession.getDogWalkerId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "DogWalker", "Id", walkingSession.getDogWalkerId()));
        walkingSession.setDogWalker(dogWalker);

        PaymentType paymentType = paymentTypeRepository.findById(walkingSession.getPaymentTypeId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "PaymentType", "Id", walkingSession.getPaymentTypeId()));
        walkingSession.setPaymentType(paymentType);

        return walkingSessionRepository.save(walkingSession);
    }

    @Override
    public List<WalkingSession> getAllWalkingSessionsByDogWalkerId(Long dogWalkerId) {
        return dogWalkerRepository.findById(dogWalkerId).map(DogWalker::getWalkingSessions)
                .orElseThrow(() -> new ResourceNotFoundException("DogWalker", "Id", dogWalkerId));
    }

    @Override
    public WalkingSession assignWalkingSessionDog(Long walkingSessionId, Long dogId) {
        Dog dog = dogRepository.findById(dogId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Dog", "Id", dogId));

        return walkingSessionRepository.findById(walkingSessionId).map(walkingSession -> {
            return walkingSessionRepository.save(walkingSession.assignDogWith(dog));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "WalkingSession", "Id", walkingSessionId));
    }

    @Override
    public WalkingSession unAssignWalkingSessionDog(Long walkingSessionId, Long dogId) {
        Dog dog = dogRepository.findById(dogId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Dog", "Id", dogId));

        return walkingSessionRepository.findById(walkingSessionId).map(walkingSession -> {
            return walkingSessionRepository.save(walkingSession.unAssignDogWith(dog));
        }).orElseThrow(() -> new ResourceNotFoundException(
                "WalkingSession", "Id", walkingSessionId));
    }

    @Override
    public List<WalkingSession> getAllWalkingSessionsByDogId(Long dogId) {
        return dogRepository.findById(dogId).map(Dog::getWalkingSessions)
                .orElseThrow(() -> new ResourceNotFoundException("Dog", "Id", dogId));
    }
}
