package com.messanalytics.controller;

import com.messanalytics.model.MessWaste;
import com.messanalytics.repository.MessWasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MessWasteController {

    @Autowired
    private MessWasteRepository repository;

    @GetMapping("/")
    public String showForm(Model model) {
        List<MessWaste> allWaste = repository.findAll();
        double totalWaste = allWaste.stream().mapToDouble(MessWaste::getFoodWastedKg).sum();

        // Analyze all 4 meals to find the one with the highest average waste
        String[] meals = {"Breakfast", "Lunch", "Snacks", "Dinner"};
        String worstMeal = "None";
        double highestAvg = 0;

        for (String meal : meals) {
            Double avg = repository.getAverageWasteByMealType(meal);
            if (avg != null && avg > highestAvg) {
                highestAvg = avg;
                worstMeal = meal;
            }
        }

        // Get current date/day for the recommendation
        java.time.LocalDate tomorrow = java.time.LocalDate.now().plusDays(1);
        String dayOfWeek = tomorrow.getDayOfWeek().toString();

        String suggestion = "Insufficient data for multi-meal analysis.";
        if (!worstMeal.equals("None")) {
            double reductionAmt = highestAvg * 0.1;
            suggestion = String.format("Trend Alert: Highest waste detected in %s. For %s (%s), recommend reducing production by %.2f kg.",
                    worstMeal, dayOfWeek, tomorrow, reductionAmt);
        }

        model.addAttribute("wasteList", allWaste);
        model.addAttribute("totalWaste", String.format("%.2f", totalWaste));
        model.addAttribute("prediction", suggestion);
        return "index";
    }

    @PostMapping("/add")
    public String addWasteFromForm(@ModelAttribute MessWaste waste) {
        repository.save(waste);
        return "redirect:/";
    }
}