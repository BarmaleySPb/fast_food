package dish.service;

import domain.model.dto.DishDTO;

public interface DishService {

    void save(DishDTO dishDTO);

    Iterable<DishDTO> findAll();

    DishDTO findById(int id);

    void deleteById(int id);

    void update(int id, DishDTO dishDto);
}
