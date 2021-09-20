package com.example.lb1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class StocksServlet {
    static public ArrayList<Stocks> stocks = new ArrayList<Stocks>() {
        {
            add(new Stocks("Аэрофлот", 66.8));
            add(new Stocks("Сбербанк-п", 311.52));
            add(new Stocks("Татнефть-п", 468.5));
            add(new Stocks("Yandex", 5828.4));
        }
    };
    @GetMapping("/")
    public String homeGet(Model model) {
        model.addAttribute("stocks", stocks);
        return "mainpage";
    }

    @GetMapping("/add")
    public String addGet() {
        return "Add";
    }

    @PostMapping("/add")
    public String addPost(@RequestParam String nameCompany, @RequestParam Double cost) {
        stocks.add(new Stocks(nameCompany, cost));
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editGet(@PathVariable(value = "id") int id, Model model) {
        Stocks stock = stocks.get(id);
        model.addAttribute("stocks", stock);
        return "Edit";
    }

    @PostMapping("/{id}/edit")
    public String addPost(@PathVariable(value = "id") int id,@RequestParam String nameCompany, @RequestParam Double cost) {
        stocks.set(id, new Stocks(nameCompany, cost));
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteGet(@PathVariable(value = "id") int id, Model model) {
        Stocks stock = stocks.get(id);
        model.addAttribute("stocks", stock);
        model.addAttribute("id", id);
        return "Delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteGet(@PathVariable(value = "id") int id) {
        stocks.remove(id);
        return "redirect:/";
    }
}

