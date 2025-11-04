package com.pelvin.habitservice.repo;

import com.pelvin.habitservice.model.Habit;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends ReactiveCrudRepository<Habit, Long> {
}


