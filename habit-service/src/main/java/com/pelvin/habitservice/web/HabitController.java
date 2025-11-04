package com.pelvin.habitservice.web;

import com.pelvin.habitservice.model.Habit;
import com.pelvin.habitservice.service.HabitService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public Flux<Habit> getAllHabits() {
        return habitService.getAllHabits();
    }

    @GetMapping("/{id}")
    public Mono<Habit> getHabitById(@PathVariable Long id) {
        return habitService.getHabitById(id);
    }

    @PostMapping
    public Mono<Habit> createHabit(@RequestBody Habit habit) {
        return habitService.createHabit(habit);
    }

    @PutMapping("/{id}")
    public Mono<Habit> updateHabit(@PathVariable Long id, @RequestBody Habit habit) {
        return habitService.updateHabit(id, habit);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteHabit(@PathVariable Long id) {
        return habitService.deleteHabit(id);
    }
}
