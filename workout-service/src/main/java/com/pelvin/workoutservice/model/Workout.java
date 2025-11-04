package com.pelvin.workoutservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

/** Entidad como record (Spring Data soporta records) */
@Table("workouts")
public record Workout(
        @Id Long id,
        String name,
        Integer durationMinutes,
        LocalDate date
) {}
