package com.luistaborda.topi.topi.model.repository;

import com.luistaborda.topi.topi.model.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MealRepository extends JpaRepository<Meal, Long> {

    Optional<Meal> findByCategory(String category);

    Optional<Meal> findByName(String name);

    Optional<Meal> findByThumbnail(String thumbnail);

    Optional<Meal> findByInstructions(String instructions);

}