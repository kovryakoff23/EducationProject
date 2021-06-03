package com.Magazine.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.Magazine.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.Magazine.service.ServiceProduct;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ModeratorControler {
    @Autowired
    ServiceProduct serviceProduct;

    @GetMapping("/moderator")
    public String ProductList(Model model) {
        model.addAttribute("allProduct", serviceProduct.getAll());
        return "moderator";
    }

    @PostMapping("/moderator")
    public String deleteProduct(@RequestParam(required = true, defaultValue = "") long productId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            serviceProduct.delete(productId);
        }
        return "redirect:/moderator";
    }

    @GetMapping("/moderator/gt/{ProductId}")
    public String gtProduct(@PathVariable("productId") long productId, Model model) {
        model.addAttribute("allProduct", serviceProduct.get(productId));
        return "moderator";
    }
    @GetMapping("/moderator/update")
    public String gtProduct(Model model) {
        try {
            Type listAddProduct = new TypeToken<ArrayList<Product>>(){}.getType();
            List<Product> addProducts = new Gson()
                    .fromJson(new BufferedReader(new FileReader("Data.txt")), listAddProduct);
            List<Product> products = serviceProduct.getAll();
            for (Product product : addProducts){
                for(Product productSave : products){
                    if (product.equals(productSave)){
                        int quantity = product.getQuantity() + productSave.getQuantity();
                        product.setQuantity(quantity);
                        product.setArticle(productSave.getArticle());
                    }
                }
                serviceProduct.save(product);
            }
        } catch (
                FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
        return "redirect:/moderator";
    }
}
