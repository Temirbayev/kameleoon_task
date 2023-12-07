package com.temirbayev.kameleoon.controller;

import com.temirbayev.kameleoon.model.Quote;
import com.temirbayev.kameleoon.model.User;
import com.temirbayev.kameleoon.service.QuoteService;
import com.temirbayev.kameleoon.service.UserService;
import com.temirbayev.kameleoon.service.VoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/")
public class MainController {
    private final QuoteService quoteService;
    private final UserService userService;
    private final VoteService voteService;

    public MainController(QuoteService quoteService, UserService userService, VoteService voteService) {
        this.quoteService = quoteService;
        this.userService = userService;
        this.voteService = voteService;
    }

    @GetMapping("/")
    public String getIndex(Model model) {
        List<User> users = userService.userList();
        Quote randomQuote = quoteService.getRandomQuote();
        List<Quote> topQuote = quoteService.getTopQuotes();

        model.addAttribute("users", users);
        model.addAttribute("randomQuote", randomQuote);
        model.addAttribute("topQuote", topQuote);

        return "index";
    }
}
