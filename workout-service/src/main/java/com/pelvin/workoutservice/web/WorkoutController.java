package com.pelvin.workoutservice.web;

import com.pelvin.workoutservice.model.Workout;
import com.pelvin.workoutservice.service.WorkoutService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private final WorkoutService service;

    public WorkoutController(WorkoutService service) {
        this.service = service;
    }

    // 🔹 Obtener todos o buscar por nombre
    @GetMapping
    public Flux<Workout> all(@RequestParam(value = "q", required = false) String q) {
        return (q == null || q.isBlank()) ? service.findAll() : service.searchByName(q);
    }

    // 🔹 Buscar por ID
    @GetMapping("/{id}")
    public Mono<Workout> byId(@PathVariable Long id) {
        return service.findById(id);
    }

    // 🔹 Crear
    @PostMapping
    public Mono<Workout> create(@Valid @RequestBody Workout workout) {
        return service.create(workout);
    }

    // 🔹 Actualizar
    @PutMapping("/{id}")
    public Mono<Workout> update(@PathVariable Long id, @Valid @RequestBody Workout workout) {
        return service.update(id, workout);
    }

    // 🔹 Eliminar
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
