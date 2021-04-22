package com.boot.controller;

import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ModeratorControler {

    @GetMapping("/moderator")
    public String ProductList(Model model) {
        model.addAttribute("allProducts");
        //action
        return "moderator";
    }

    @PostMapping("/moderator")
    public String deleteProduct(Long productId, Model model){
        //action
        return "moderator";
    }

    @GetMapping("/moderator/gt/{ProductId}")
    public String gtProduct(@PathVariable("productId") Long productId, Model model) {
        //action
        return "moderator";
    }
}
