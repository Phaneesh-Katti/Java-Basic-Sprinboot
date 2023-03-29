package com.example.mvc_final_cs281.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.example.mvc_final_cs281.model.Stock;
@Repository
public class StockRepository {
    private List<Stock> stocks;
    public StockRepository() {
        this.stocks = new ArrayList<>();
    }
    public void addStock(Stock stock) {
        stocks.add(stock);
    }
    public List<Stock> getStocks() {
        return stocks;
    }
    public List<Stock> findAll() {
        return stocks;
    }
    public void save(Stock stock) {
        stocks.add(stock);
    }
    public void deleteByName(String name) {
        stocks.removeIf(stock -> stock.getName().equals(name));
    }
}
