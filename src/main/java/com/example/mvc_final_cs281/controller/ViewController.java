package com.example.mvc_final_cs281.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.mvc_final_cs281.model.Stock;
import com.example.mvc_final_cs281.repository.StockRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {
    @Autowired
    private StockRepository stockRepository;
    @GetMapping("/view")
    public String view(Model model) {
        List<Stock> stocks = stockRepository.findAll();
        if (stocks.isEmpty()) {
            model.addAttribute("message", "No records found.");
        } else {
            model.addAttribute("stocks", stocks);
        }
        return "view";
    }
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteStock(@PathVariable String name) {
        try {
            stockRepository.deleteByName(name);
            return ResponseEntity.ok().body("Stock record for " + name + " deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting stock record: " + e.getMessage());
        }
    }
}
