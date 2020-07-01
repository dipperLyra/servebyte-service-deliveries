package com.delivery.servebyte.controllers;

import com.delivery.servebyte.controllers.data.restaurant.RestaurantRequest;
import com.delivery.servebyte.controllers.data.restaurant.RestaurantResponse;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.persistence.entities.Restaurant;
import com.delivery.servebyte.persistence.repositories.MealRepository;
import com.delivery.servebyte.persistence.repositories.RestaurantRepository;
import com.delivery.servebyte.services.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@RestController
@RequestMapping(path = "/api/v1/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    MealRepository mealRepository;

    private static String UPLOADED_FOLDER = "F://temp//";

    @GetMapping(path = "/")
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Restaurant>> getRestaurant(
            @PathVariable(value = "id") Long restaurantId
    ) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        return ResponseEntity.ok().body(restaurant);
    }

    @PostMapping(path = "/")
    @ResponseBody
    public Restaurant newRestaurant(@RequestBody Restaurant restaurant)
    {
        return  restaurantRepository.save(restaurant);
    }

    @PostMapping(path = "/meal")
    @ResponseBody
    public Meal newMeal(@RequestBody Meal meal)
    {
        return mealRepository.save(meal);
    }

    @PostMapping(path = "/meal/photo")
    @ResponseBody
    public String newRestaurant(@RequestParam("file") MultipartFile file,
                                RedirectAttributes redirectAttributes)
    {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
