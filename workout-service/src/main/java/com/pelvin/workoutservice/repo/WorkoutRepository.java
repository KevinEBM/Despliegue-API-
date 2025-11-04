package com.pelvin.workoutservice.repo;

import com.pelvin.workoutservice.model.Workout;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface WorkoutRepository extends ReactiveCrudRepository<Workout, Long> {
    // 🔹 Método personalizado para buscar por nombre
    Flux<Workout> findByNameContainingIgnoreCase(String name);
}

