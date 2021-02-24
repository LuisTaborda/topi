package com.luistaborda.topi.topi.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "meal", schema = "meals")
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "meals")
public class Meal {

    @Id
    @Column(name = "id_meal")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SerializedName("idMeal")
    private Long id;

    @Column(name = "name_meal")
    @SerializedName("strMeal")
    private String name;

    @Column(name = "category")
    @SerializedName("strCategory")
    private String category;

    @Column(name = "thumbnail")
    @SerializedName("strMealThumb")
    private String thumbnail;

    @Column(name = "instructions")
    @SerializedName("strInstructions")
    private String instructions;


}
