package com.gyasociety.carrydoggygoservice.domain.repository;

import com.gyasociety.carrydoggygoservice.domain.model.WalkingSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalkingSessionRepository extends JpaRepository<WalkingSession, Long > {
}
