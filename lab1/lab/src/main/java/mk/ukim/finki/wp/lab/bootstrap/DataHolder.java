package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Chef> chefs = new ArrayList<>();
    public static List<Dish> dishes = new ArrayList<>();

    @PostConstruct
    public void init() {
        chefs.add(new Chef(1L, "Gordon", "Ramsey", "World-renowned chef with 16 Michelin stars"));
        chefs.add(new Chef(2L, "Jamie", "Oliver", "An English celebrity chef, restaurateur and cookbook author"));
        chefs.add(new Chef(3L, "Guy", "Fieri", "An American restaurateur, author, and an Emmy Award winning television presenter"));
        chefs.add(new Chef(4L, "Bobby", "Flay", "An American celebrity chef, food writer, restaurateur, and television personality"));
        chefs.add(new Chef(5L, "Nigella", "Lawson", "An English food writer and television cook"));

        dishes.add(new Dish("1", "Lasagna", "Italian", 90));
        dishes.add(new Dish("2", "Beef Wellington", "British", 45));
        dishes.add(new Dish("3", "Sticky Toffee Pudding", "British", 30));
        dishes.add(new Dish("4", "Cottage pie", "French", 90));
        dishes.add(new Dish("5", "Pasta Carbonara", "Italian", 30));
    }
}
