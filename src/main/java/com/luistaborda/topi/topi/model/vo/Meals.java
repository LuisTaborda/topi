package com.luistaborda.topi.topi.model.vo;

import com.luistaborda.topi.topi.model.entity.Meal;

import java.util.ArrayList;
import java.util.List;

public class Meals {

    private List<Meal> meals = new ArrayList<>();

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
