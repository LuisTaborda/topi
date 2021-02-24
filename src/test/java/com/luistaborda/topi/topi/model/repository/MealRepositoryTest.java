package com.luistaborda.topi.topi.model.repository;

import com.luistaborda.topi.topi.model.entity.Meal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MealRepositoryTest {

    @Autowired
    MealRepository repository;
    @Autowired
    TestEntityManager entityManager;

    @Test
    public void saveMeal() {
        Meal meal = createMeal();
        meal = repository.save(meal);
        assertThat(meal.getId()).isNotNull();
    }

    @Test
    public void findMeal() {
        Meal meal = createMeal();
        meal = repository.save(meal);
        Meal meal2 = repository.getOne(meal.getId());
        assertThat(meal.getId()).isEqualTo(meal2.getId());
    }

    @Test
    public void deleteMeal() {

        Meal meal = createAndPersistMeal();
        meal = entityManager.find(Meal.class, meal.getId());

        repository.delete(meal);

        Meal mealNotExist = entityManager.find(Meal.class, meal.getId());
        assertThat(mealNotExist).isNull();

    }

    public Meal createMeal() {
        Meal meal = new Meal();
        meal.setCategory("test category");
        meal.setInstructions("test instructions");
        meal.setName("test Name");
        meal.setThumbnail("test thumbnail");
        return meal;
    }

    public Meal createAndPersistMeal() {
        Meal meal = createMeal();
        entityManager.persist(meal);
        return meal;
    }
}
