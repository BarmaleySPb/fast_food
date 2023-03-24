package dish.service.impl;

import dish.repository.DishRepository;
import dish.service.DishService;
import domain.model.Dish;
import domain.model.dto.DishDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void save(DishDTO dishDTO) {
        String name = dishDTO.getName();
        checkUniqName(name);
        try {
            dishRepository.save(modelMapper.map(dishDTO, Dish.class));
        } catch (Exception e) {
            log.error("Dish not saved.", e);
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        if (!dishRepository.existsById(id)) {
            throw new NoSuchElementException("Dish with id:[%s] not found.".formatted(id));
        }
        try {
            dishRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Dish not deleted.", e);
        }
    }

    @Override
    public Iterable<DishDTO> findAll() {
        List<DishDTO> dishes = new ArrayList<>();
        dishRepository.findAll().forEach(dish -> dishes.add(modelMapper.map(dish, DishDTO.class)));
        return dishes;
    }

    @Override
    public DishDTO findById(int id) {
        return modelMapper.map(dishRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Dish with id:[%s] not found.".formatted(id))
        ), DishDTO.class);
    }

    @Override
    @Transactional
    public void update(int id, DishDTO newDish) {
        checkUniqName(newDish.getName());
        try {
            dishRepository.updateNameAndPrice(
                    newDish.getName(), newDish.getPrice(), id
            );
        } catch (Exception e) {
            log.error("Dish not updated.", e);
        }
    }

    private void checkUniqName(String name) {
        if (dishRepository.findByName(name).isPresent()) {
            throw new IllegalArgumentException(
                    "Dish with name:[%s] already exists.".formatted(name)
            );
        }
    }
}
