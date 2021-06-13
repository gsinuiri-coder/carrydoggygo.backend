package com.gyasociety.carrydoggygoservice.domain.repository;


import com.gyasociety.carrydoggygoservice.domain.model.DogWalker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogWalkerRepository extends JpaRepository<DogWalker, Long> {
}
