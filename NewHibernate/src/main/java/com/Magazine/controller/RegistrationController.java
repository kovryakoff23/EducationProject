package com.Magazine.controller;


import com.Magazine.entity.*;
import com.Magazine.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegistrationController {

    @Autowired
    private UserServiceAuthentification userService;
    @Autowired
    private ServiceAddress serviceAddress;
    @Autowired
    ServiceOrderHistory serviceOrderHistory;
    @Autowired
    private ServiceBasket serviceBasket;
    @Autowired
    private ServiceUser serviceUser;
    long id;
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new UserAuthentification());

        return "registration";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }
    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid UserAuthentification userForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
            model.addAttribute("passwordError", "Пароли не совпадают");
            return "registration";
        }
        if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }
        else{
            id = userForm.getId();
            OrderHistory orderHistory = new OrderHistory();
            serviceOrderHistory.save(orderHistory);
            Basket basket = new Basket();
            serviceBasket.save(basket);
            Address address = new Address();
            serviceAddress.save(address);
            serviceUser.save(new User(userForm.getId(), orderHistory, address, basket));
        }

        return "redirect:/registrationUser";
    }
    @GetMapping("/registrationUser")
    public String registrationModer(Model model) {
        model.addAttribute("Form", serviceUser.get(id));
        return "registrationUser";
    }
    @PostMapping("/registrationUser")
    public String addModerator(@ModelAttribute("Form") @Valid User user, Model model){
        Address address = serviceUser.get(id).getAddress();
        Basket basket = serviceUser.get(id).getBasket();
        OrderHistory orderHistory = serviceUser.get(id).getOrder();
        user.setAddress(address);
        user.setBasket(basket);
        user.setOrder(orderHistory);
        serviceUser.save(user);
        return "redirect:/registrationAddress";
    }
    @GetMapping("/registrationAddress")
    public String registrationAddress(Model model) {
        model.addAttribute("Form", serviceUser.get(id).getAddress());
        return "registrationAddress";
    }
    @PostMapping("/registrationAddress")
    public String registrationAddress(@ModelAttribute("Form") @Valid Address address, Model model){
        User user = serviceUser.get(id);
        address.addUser(user);
        serviceAddress.save(address);
        return "redirect:/";
    }
}
