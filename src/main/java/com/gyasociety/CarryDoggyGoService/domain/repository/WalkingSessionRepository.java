package com.gyasociety.CarryDoggyGoService.domain.repository;

import com.gyasociety.CarryDoggyGoService.domain.model.WalkingSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalkingSessionRepository extends JpaRepository<WalkingSession, Long > {
}
