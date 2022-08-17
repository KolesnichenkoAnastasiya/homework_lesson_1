package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.persist.product.Product;
import ru.geekbrains.persist.product.ProductRepository;


@RequestMapping("/product")
@Controller
public class ProductController {
    private final ProductRepository productRepository;
    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @GetMapping
    public String listPage(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product";
    }
    @GetMapping("/{id}")
    public String form(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productRepository.findById(id));
        return "product_form";
    }
    /*удаление при нажатии на кнопку*/
    @GetMapping("/del/{id}")
    public String form2(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", productRepository.delete(id));
        return "redirect:/product";
    }
    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("product", new Product());
        return "product_form";
    }
    @PostMapping
    public String save(@Validated Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()||product.getTitle().isEmpty()||product.getCost()==0){
            return "product_form";
        }
            productRepository.save(product);
            return "redirect:/product";
    }
}
