package kz.runtime.springproject.controller;

import kz.runtime.springproject.pojo.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/practice_controller")

public class PracticeController {
    @GetMapping(path = "/practice_page")
    public Object practicePage(@RequestParam(name = "categoryName", required = false) String categoryName)
    {
        List<Product> products = List.of(new Product("Smartphone", "Samsung", 250000),
                new Product("Smartphone", "IPhone", 650000),
                new Product("Laptop", "Asus", 450000));
        for (Product product : products) {
            if (product.getCategory().equals(categoryName)) {
                return products;
            }
        }
        return null;
    }
}
