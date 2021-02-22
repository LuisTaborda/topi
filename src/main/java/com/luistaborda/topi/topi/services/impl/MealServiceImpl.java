package com.luistaborda.topi.topi.services.impl;

import com.luistaborda.topi.topi.model.entity.Meal;
import com.luistaborda.topi.topi.model.repository.MealRepository;
import com.luistaborda.topi.topi.services.MealService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class MealServiceImpl implements MealService {

    private MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    @Transactional
    public Meal save(Meal meal) {
        return this.mealRepository.save(meal);
    }

    @Override
    @Transactional
    public Meal update(Meal meal) {
        Objects.requireNonNull(meal.getId());
        return this.mealRepository.save(meal);
    }

    @Override
    @Transactional
    public void delete(Meal meal) {
        Objects.requireNonNull(meal.getId());
        this.mealRepository.delete(meal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Meal> find(Meal mealFilter) {
        Example example = Example.of(mealFilter, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return this.mealRepository.findAll(example);
    }
}
