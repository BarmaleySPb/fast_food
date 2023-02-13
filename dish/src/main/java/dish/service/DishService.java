package dish.service;

import domain.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {

    Dish add(Dish dish);

    void delete(Dish dish);

    List<Dish> findAll();

    Optional<Dish> findById(int id);
}
