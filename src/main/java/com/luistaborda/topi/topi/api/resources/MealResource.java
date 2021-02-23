package com.luistaborda.topi.topi.api.resources;

import com.luistaborda.topi.topi.api.dto.MealDTO;
import com.luistaborda.topi.topi.exception.MealException;
import com.luistaborda.topi.topi.model.entity.Meal;
import com.luistaborda.topi.topi.model.response.Meals;
import com.luistaborda.topi.topi.services.MealService;
import com.luistaborda.topi.topi.services.TheMealDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/meals")
@RequiredArgsConstructor
public class MealResource {

    private final MealService mealService;

    @PostMapping
    public ResponseEntity save(@RequestBody MealDTO dto) {
        try {
            Meal entity = converter(dto);
            entity = this.mealService.save(entity);
            return new ResponseEntity(entity, HttpStatus.CREATED);
        } catch (MealException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity buscar(@RequestParam(value = "name", required = false) String name) throws Exception {
        try {
            Meals meals = TheMealDBService.findByName(name);
            if(meals.getMeals() == null) {
                throw new MealException("No meals found.");
            }
            return new ResponseEntity(meals, HttpStatus.CREATED);
        } catch (MealException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private Meal converter(MealDTO dto) {
        Meal meal = new Meal();
        meal.setId(dto.getId());
        meal.setName(dto.getName());
        meal.setCategory(dto.getCategory());
        meal.setThumbnail(dto.getThumbnail());
        meal.setInstructions(dto.getInstructions());
        return meal;
    }

    private MealDTO converter(Meal meal) {
        MealDTO dto = new MealDTO();
        dto.setId(dto.getId());
        dto.setName(dto.getName());
        dto.setCategory(dto.getCategory());
        dto.setThumbnail(dto.getThumbnail());
        dto.setInstructions(dto.getInstructions());
        return dto;
    }
}
