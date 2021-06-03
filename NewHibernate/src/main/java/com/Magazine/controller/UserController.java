package com.Magazine.controller;

import com.Magazine.entity.*;
import com.Magazine.service.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceAuthentification userServiceAuthentification;
    @Autowired
    ServiceProduct serviceProduct;
    @Autowired
    ServiceBasketProduct serviceBasketProduct;
    @Autowired
    ServiceBasket serviceBasket;
    @Autowired
    ServiceUser serviceUser;

    @GetMapping("/product")
    public String ProductList(Model model) {
        model.addAttribute("allProduct", serviceProduct.getAll());
        return "product";
    }

    @PostMapping("/product")
    public String deleteProduct(@RequestParam(required = true, defaultValue = "") long productId,
                                @RequestParam(required = true, defaultValue = "") String action,
                                Model model) {
        if (action.equals("addInCart")) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Long userId = userServiceAuthentification.loadUser(auth.getName()).getId();
            User user = serviceUser.get(userId);
            Basket basket = user.getBasket();
            List<BasketProduct> basketProducts = basket.getBasketProducts();
            boolean checkProduct = true;
            for(BasketProduct basketProduct : basketProducts){
                if(basketProduct.getProduct().getArticle() == productId){
                    long quantity = basketProduct.getQuantity();
                    quantity++;
                    basketProduct.setQuantity(quantity);
                    serviceBasketProduct.save(basketProduct);
                    checkProduct = false;
                }
            }
            if (checkProduct){
                BasketProduct basketProductNew = new BasketProduct(user.getBasket(), serviceProduct.get(productId), 1);
                serviceBasketProduct.save(basketProductNew);
            }
            return "redirect:/product";
        }
        return "/product";
    }

    @GetMapping("/cart")
    public String ShowProductList(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long userId = userServiceAuthentification.loadUser(auth.getName()).getId();
        User user = serviceUser.get(userId);
        Basket basket = user.getBasket();
        List<BasketProduct> basketProduct = basket.getBasketProducts();
        model.addAttribute("allBasketProduct", basketProduct);
        return "cart";
    }
}
