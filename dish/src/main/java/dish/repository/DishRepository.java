package dish.repository;

import domain.model.Dish;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface DishRepository extends CrudRepository<Dish, Integer> {
    @Transactional
    @Modifying
    @Query("update dish d set d.name = ?1, d.price = ?2 where d.id = ?3")
    void updateNameAndPrice(String newName, int newPrice, int id);

    Optional<Dish> findByName(String name);

    Optional<Dish> findById(int id);
}
