package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Chef;
import mk.ukim.finki.wp.lab.model.Dish;
import mk.ukim.finki.wp.lab.service.ChefService;
import mk.ukim.finki.wp.lab.service.DishService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/chefs")
public class ChefController {
    private final ChefService chefService;
    private final DishService dishService;

    public ChefController(ChefService chefService, DishService dishService) {
        this.chefService = chefService;
        this.dishService = dishService;
    }

    @GetMapping("/listChefs")
    public String getAllChefs(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", error);
        }

        List<Chef> chefs = chefService.listChefs();

        model.addAttribute("chefs", chefs);
        return "listChefs";
    }

    @GetMapping("/chefDetails")
    public String getChefDetails(@RequestParam Long chefId, Model model) {
        Chef chef = chefService.findById(chefId);
        List<Dish> dishes = chef.getDishes();

        model.addAttribute("chef", chef);
        model.addAttribute("dishes", dishes);

        return "chefDetails";
    }

    @PostMapping("/chefDetails")
    private String doPost(@RequestParam Long chefId, @RequestParam String dishId, Model model) {
        Chef chef = chefService.findById(chefId);
        Dish dish = dishService.findByDishId(dishId);

        if (chef == null || dish == null) {
            throw new RuntimeException("Chef or Dish not found");
        }

        chefService.addDishToChef(chefId, dishId);

        model.addAttribute("chef", chef);
        model.addAttribute("dish", dish);

        return "chefDetails";
    }
}
