package com.temirbayev.kameleoon.controller;

import com.temirbayev.kameleoon.model.Quote;
import com.temirbayev.kameleoon.model.Users;
import com.temirbayev.kameleoon.service.QuoteService;
import com.temirbayev.kameleoon.service.UsersService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    private final QuoteService quoteService;
    private final UsersService userService;
    private final PasswordEncoder passwordEncoder;

    public MainController(QuoteService quoteService, UsersService userService, PasswordEncoder passwordEncoder) {
        this.quoteService = quoteService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/")
    public String getIndex(Model model) {
        List<Users> users = userService.userList();
        Quote randomQuote = quoteService.getRandomQuote();
        List<Quote> topQuote = quoteService.getTopQuotes();
        List<Quote> flopQuote = quoteService.getWorstQuotes();
        model.addAttribute("users", users);
        model.addAttribute("randomQuote", randomQuote);
        model.addAttribute("topQuote", topQuote);
        model.addAttribute("flopQuote", flopQuote);

        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userEntity", new Users());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationUser(@ModelAttribute("userEntity") Users user) {
        String hashPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPwd);
        user.setCreatedDate(LocalDate.now());
        userService.createUser(user);
        return "redirect:/login";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
}
