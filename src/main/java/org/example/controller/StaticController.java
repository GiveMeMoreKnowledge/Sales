package org.example.controller;

import org.example.service.StaticService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {

    private final StaticService staticService;

    public StaticController(StaticService staticService) {
        this.staticService = staticService;
    }

    @GetMapping("/statistic")
    public String getStat(Model model) {
        model.addAttribute("sum", staticService.sumAllSales());
        model.addAttribute("avg", staticService.avgAllSales());
        model.addAttribute("count", staticService.countAllSales());
        model.addAttribute("sumDiscount", staticService.sumDiscountAllSales());
        model.addAttribute("sumAllSalesDiscountCost", staticService.sumAllSalesDiscountCost());
        model.addAttribute("avgAllSalesDiscountCost", staticService.avgAllSalesDiscountCost());

        return "statistic";
    }

}
