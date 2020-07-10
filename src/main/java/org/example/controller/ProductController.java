package org.example.controller;

import org.example.domain.Product;
import org.example.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String listProduct(Model model) {
        model.addAttribute("products", productService.findAll());
        return "/productList";
    }

    @GetMapping("product/{product}")
    public String editProductForm(
            @PathVariable Product product, Model model) {
        model.addAttribute("product", product);

        return "/productEdit";
    }

    @PostMapping("/prodEdit")
    public String saveProduct(
            @RequestParam String name,
            @RequestParam Double cost,
            @RequestParam("productId") Product product) {
        product.setName(name);
        product.setCost(cost);

        productService.productSave(product);

        return "redirect:/product";
    }

    @GetMapping("/delete/{product}")
    public String deleteProductForm(@PathVariable Product product, Model model) {
        model.addAttribute("product", product);

        return "/productDelete";
    }

    @PostMapping("/prodDelete")
    public String deleteProduct(@RequestParam("productId") Product product) {
        productService.productDelete(product);

        return "redirect:/product";
    }

    @PostMapping("/product")
    public String addProduct(
            @RequestParam String name,
            @RequestParam Double cost,
            Model model) {
        Product product = new Product(name, cost);

        productService.productAdd(product);

        model.addAttribute("products", productService.findAll());

        return "/productList";
    }

}
