package domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Timestamp;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "dish")
@Table(
        name = "dish",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "dish_name_unique",
                        columnNames = "name"
                )
        })
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dish_id")
    private int id;

    @Column(name = "name")
    @NotBlank(message = "Name must be not blank")
    private String name;

    @Min(value = 1, message = "Price must be from 1 to 999999")
    @Max(999999)
    private int price;

    @Timestamp
    private final LocalDateTime created = LocalDateTime.now();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dish dish = (Dish) o;
        return id == dish.id && name.equals(dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
