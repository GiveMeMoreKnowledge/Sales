package org.example.controller;

import org.example.domain.Product;
import org.example.domain.SalePosition;
import org.example.service.ProductService;
import org.example.service.SaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SaleController {

    private final SaleService saleService;
    private final ProductService productService;

    public SaleController(SaleService saleService, ProductService productService) {
        this.saleService = saleService;
        this.productService = productService;
    }

    @GetMapping("/cartList")
    public String addCartList(Model model) {
        model.addAttribute("salePosition", saleService.findAllSalePosition());
        model.addAttribute("products", productService.findAll());

        return "/cart";
    }

    @GetMapping("/cart")
    public String getCartList(Model model) {
        model.addAttribute("salePosition", saleService.findAllSalePosition());
        model.addAttribute("products", productService.findAll());

        return "/cart";
    }

    @PostMapping("/cart")
    public String addCart(@RequestParam Product product,
                       @RequestParam Integer count) {
        SalePosition salePosition = new SalePosition(product, count);
        saleService.formingSale(salePosition);

        return "redirect:/cartList";
    }

    @GetMapping("/sales")
    public String salesList(Model model) {
        model.addAttribute("sales", saleService.findAll());

        return "salesList";
    }

    @GetMapping("/sale")
    public String cartList(Model model) {
        model.addAttribute("salePosition", saleService.findAllSalePosition());

        return "/cartList";
    }

    @PostMapping("/sale")
    public String addSale() {
        saleService.addSale();

        return "redirect:/sales";
    }

    @GetMapping("/history")
    public String getHistory(Model model) {
        model.addAttribute("history", saleService.getHistory());

        return "history";
    }

}
