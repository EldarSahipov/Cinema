package com.java.cinema.view;

import com.java.cinema.forms.UserForm;
import com.java.cinema.service.RegistrationService;
import com.java.cinema.service.UsersService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
@Log
public class RegistrationController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public String registrationPage(Model model) {
        return "registration";
    }

    @PostMapping
    public String registration(@ModelAttribute("user") UserForm userForm) {
        registrationService.reg(userForm);
        return "redirect:/login";
    }
}
