package com.luistaborda.topi.topi.model.repository;

import com.luistaborda.topi.topi.model.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {

}