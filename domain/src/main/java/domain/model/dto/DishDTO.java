package domain.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DishDTO {

    private int id;

    @NotBlank(message = "Name must be not blank.")
    private String name;

    @Min(value = 1, message = "Price must be from 1 to 999999.")
    @Max(999999)
    private int price;

}
