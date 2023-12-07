package com.temirbayev.kameleoon.controller;

import com.temirbayev.kameleoon.model.Quote;
import com.temirbayev.kameleoon.service.QuoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quotes")
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    // Получение случайной цитаты
    @GetMapping("/random")
    public ResponseEntity<Quote> getRandomQuote() {
        Quote randomQuote = quoteService.getRandomQuote();
        return ResponseEntity.ok(randomQuote);
    }

    // Получение списка 10 лучших цитат
    @GetMapping("/top")
    public ResponseEntity<List<Quote>> getTopQuotes() {
        List<Quote> topQuotes = quoteService.getTopQuotes();
        return ResponseEntity.ok(topQuotes);
    }

    // Получение списка 10 худших цитат
    @GetMapping("/worst")
    public ResponseEntity<List<Quote>> getWorstQuotes() {
        List<Quote> worstQuotes = quoteService.getWorstQuotes();
        return ResponseEntity.ok(worstQuotes);
    }

    // Получение подробной информации о цитате по ID
    @GetMapping("/{quoteId}")
    public ResponseEntity<Quote> getQuoteById(@PathVariable Long quoteId) {
        Quote quote = quoteService.getQuoteById(quoteId);
        return ResponseEntity.ok(quote);
    }

    // Добавление новой цитаты
    @PostMapping("/")
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote) {
        Quote createdQuote = quoteService.createQuote(quote);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuote);
    }

    // Модификация цитаты по ID
    @PutMapping("/{quoteId}")
    public ResponseEntity<Quote> updateQuote(@PathVariable Long quoteId, @RequestBody Quote updatedQuote) {
        Quote modifiedQuote = quoteService.updateQuote(quoteId, updatedQuote);
        return ResponseEntity.ok(modifiedQuote);
    }

    // Удаление цитаты по ID
    @DeleteMapping("/{quoteId}")
    public ResponseEntity<Void> deleteQuote(@PathVariable Long quoteId) {
        quoteService.deleteQuote(quoteId);
        return ResponseEntity.noContent().build();
    }
}
