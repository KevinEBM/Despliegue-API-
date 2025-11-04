package com.pelvin.habitservice.service;

import com.pelvin.habitservice.model.Habit;
import com.pelvin.habitservice.repo.HabitRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HabitService {

    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public Flux<Habit> getAllHabits() {
        return habitRepository.findAll();
    }

    public Mono<Habit> getHabitById(Long id) {
        return habitRepository.findById(id);
    }

    public Mono<Habit> createHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public Mono<Habit> updateHabit(Long id, Habit habit) {
        return habitRepository.findById(id)
                .flatMap(existing -> {
                    existing.setName(habit.getName());
                    existing.setDescription(habit.getDescription());
                    return habitRepository.save(existing);
                });
    }

    public Mono<Void> deleteHabit(Long id) {
        return habitRepository.deleteById(id);
    }
}

