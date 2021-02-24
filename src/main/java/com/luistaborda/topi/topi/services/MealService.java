package com.luistaborda.topi.topi.services;

import com.luistaborda.topi.topi.model.entity.Meal;

import java.util.List;

public interface MealService {

    Meal save(Meal meal);
    Meal update(Meal meal);
    void delete(Meal meal);
    List<Meal> find(Meal mealFilter);

}
