package com.pelvin.workoutservice.service;

import com.pelvin.workoutservice.model.Workout;
import com.pelvin.workoutservice.repo.WorkoutRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WorkoutService {

    private final WorkoutRepository repository;

    public WorkoutService(WorkoutRepository repository) {
        this.repository = repository;
    }

    // 🔹 Obtener todos los workouts
    public Flux<Workout> findAll() {
        return repository.findAll();
    }

    // 🔹 Buscar por nombre
    public Flux<Workout> searchByName(String q) {
        return repository.findByNameContainingIgnoreCase(q);
    }

    // 🔹 Buscar por ID
    public Mono<Workout> findById(Long id) {
        return repository.findById(id);
    }

    // 🔹 Crear nuevo
    public Mono<Workout> create(Workout workout) {
        return repository.save(workout);
    }

    // 🔹 Actualizar
    public Mono<Workout> update(Long id, Workout workout) {
        return repository.findById(id)
                .flatMap(existing -> {
                    Workout updated = new Workout(
                            existing.id(),
                            workout.name(),
                            workout.durationMinutes(),
                            workout.date()
                    );
                    return repository.save(updated);
                });
    }

    // 🔹 Eliminar
    public Mono<Void> delete(Long id) {
        return repository.deleteById(id);
    }
}
