package domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private int id;

    private int total;

    private String address;

    private final LocalDateTime created = LocalDateTime.now();

    private Customer customer;

    private Courier courier;

    private List<Dish> dishList;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return id == order.id && total == order.total;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total);
    }

    @Override
    public String toString() {
        return "Order{"
                + "id=" + id
                + ", total=" + total
                + ", address='" + address + '\''
                + '}';
    }
}
