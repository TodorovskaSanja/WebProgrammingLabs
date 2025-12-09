package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.repository.ChefRepository;
import mk.ukim.finki.wp.lab.repository.DishRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
public class DataHolder {
    private final ChefRepository chefRepository;
    private final DishRepository dishRepository;

    public DataHolder(ChefRepository chefRepository, DishRepository dishRepository) {
        this.chefRepository = chefRepository;
        this.dishRepository = dishRepository;
    }

//    @PostConstruct
    public void init() {
        if (chefRepository.findAll().isEmpty()) {
            List<Chef> chefs = new ArrayList<>();
            chefs.add(new Chef("Gordon", "Ramsey", "World-renowned chef with 16 Michelin stars"));
            chefs.add(new Chef("Jamie", "Oliver", "An English celebrity chef, restaurateur and cookbook author"));
            chefs.add(new Chef("Guy", "Fieri", "An American restaurateur, author, and an Emmy Award winning television presenter"));
            chefs.add(new Chef("Bobby", "Flay", "An American celebrity chef, food writer, restaurateur, and television personality"));
            chefs.add(new Chef("Nigella", "Lawson", "An English food writer and television cook"));
            chefRepository.saveAll(chefs);
        }

//        if (dishRepository.findAll().isEmpty()) {
//            List<Dish> dishes = new ArrayList<>();
//            dishes.add(new Dish("1", "Lasagna", "Italian", 90, 1));
//            dishes.add(new Dish("2", "Beef Wellington", "British", 45, 1));
//            dishes.add(new Dish("3", "Sticky Toffee Pudding", "British", 30, 1));
//            dishes.add(new Dish("4", "Cottage pie", "French", 90, 1));
//            dishes.add(new Dish("5", "Pasta Carbonara", "Italian", 30, 1));
//            dishRepository.saveAll(dishes);
//        }

    }
}
