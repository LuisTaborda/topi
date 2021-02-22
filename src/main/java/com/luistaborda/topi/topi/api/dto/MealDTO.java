package com.luistaborda.topi.topi.api.dto;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MealDTO {
    private Long id;
    private String name;
    private String category;
    private String thumbnail;
    private String instructions;
}
