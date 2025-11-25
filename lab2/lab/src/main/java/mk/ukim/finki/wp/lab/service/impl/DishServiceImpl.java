package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.model.exceptions.DishNotFoundException;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<Dish> listDishes() {
        return dishRepository.findAll();
    }

    @Override
    public Dish findByDishId(String dishId) {
        return dishRepository.findByDishId(dishId);
    }

    @Override
    public Dish findById(Long id) {
//        return dishRepository.findById(id).orElseThrow(() -> new DishNotFoundException(id));
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    public Dish create(String dishId, String name, String cuisine, int preparationTime) {
        if (dishId == null || dishId.isEmpty() ||
                name == null || name.isEmpty() ||
                cuisine == null || cuisine.isEmpty() ||
                preparationTime < 0) {
            throw new IllegalArgumentException();
        }

        Dish dish = new Dish(dishId, name, cuisine, preparationTime);
        return this.dishRepository.save(dish);
    }

    @Override
    public Dish update(Long id, String dishId, String name, String cuisine, int preparationTime) {
        if (dishId == null || dishId.isEmpty() ||
                name == null || name.isEmpty() ||
                cuisine == null || cuisine.isEmpty() ||
                preparationTime < 0) {
            throw new IllegalArgumentException();
        }

        Dish dish = dishRepository.findById(id).orElseThrow(() -> new DishNotFoundException(id));
        dish.setDishId(dishId);
        dish.setName(name);
        dish.setCuisine(cuisine);
        dish.setPreparationTime(preparationTime);

        return dishRepository.save(dish);
    }

    @Override
    public void delete(Long id) {
        dishRepository.deleteById(id);
    }
}
