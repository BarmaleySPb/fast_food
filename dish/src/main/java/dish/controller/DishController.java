package dish.controller;

import dish.service.impl.DishServiceImpl;
import domain.model.dto.DishDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dishes")
@AllArgsConstructor
public class DishController {

    private final DishServiceImpl dishService;

    @GetMapping
    public ResponseEntity<Iterable<DishDTO>> findAll() {
        return ResponseEntity.ok(dishService.findAll());
    }

    @PostMapping("/save")
            public ResponseEntity<HttpStatus> addDish(@RequestBody @Valid DishDTO dishDTO) {
        dishService.save(dishDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DishDTO> findDishById(@PathVariable("id") int dishId) {
        return ResponseEntity.ok(dishService.findById(dishId));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteDishById(@PathVariable("id") int dishId) {
        dishService.deleteById(dishId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateDishById(@PathVariable("id") int dishId,
                                       @RequestBody @Valid DishDTO newDish) {
        dishService.update(dishId, newDish);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
