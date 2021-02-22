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
        Meal meal = new Meal();
        meal.setCategory("test category");
        meal.setInstructions("test instructions");
        meal.setName("test Name");
        meal.setThumbnail("test thumbnail");
        meal = repository.save(meal);
        assertThat(meal.getId()).isNotNull();
    }
}
