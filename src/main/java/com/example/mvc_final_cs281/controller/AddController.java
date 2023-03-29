package com.example.mvc_final_cs281.controller;

import com.example.mvc_final_cs281.model.Stock;
import com.example.mvc_final_cs281.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {

    @Autowired
    private StockRepository stockRepository;

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("stock", new Stock("", 0.0, 0.0));
        return "add";
    }

    @PostMapping("/add")
    public String addSubmit(@RequestParam String name, @RequestParam double openingPrice, @RequestParam double closingPrice, Model model) {
        Stock newStock = new Stock(name, openingPrice, closingPrice);
        stockRepository.save(newStock);
        model.addAttribute("stock", newStock);

        return "add";
    }
}
