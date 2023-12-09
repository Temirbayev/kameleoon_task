package com.temirbayev.kameleoon.service.impl;

import com.temirbayev.kameleoon.model.Quote;
import com.temirbayev.kameleoon.repository.QuoteRepository;
import com.temirbayev.kameleoon.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class QuoteServiceImpl implements QuoteService {
    private final QuoteRepository quoteRepository;

    @Override
    public Quote getRandomQuote() {
        // Реализуйте логику получения случайной цитаты
        // Пример: вернуть случайную цитату из базы данных
        List<Quote> allQuotes = quoteRepository.findAll();
        if (!allQuotes.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(allQuotes.size());
            return allQuotes.get(randomIndex);
        } else {
            return null;
        }
    }
    @Override
    public List<Quote> getTopQuotes() {
        // Реализуйте логику получения топ цитат
        // Пример: вернуть топ цитат из базы данных по количеству голосов
        return quoteRepository.findTopQuotesByVotes();
    }
    @Override
    public List<Quote> getWorstQuotes() {
        // Реализуйте логику получения худших цитат
        // Пример: вернуть худшие цитаты из базы данных по количеству голосов
        return quoteRepository.findWorstQuotesByVotes();
    }
    @Override
    public Quote getQuoteById(Long quoteId) {
        return quoteRepository.findById(quoteId).orElse(null);
    }
    @Override
    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }
    @Override
    public Quote updateQuote(Long quoteId, Quote updatedQuote) {
        Quote existingQuote = quoteRepository.findById(quoteId).orElse(null);
        if (existingQuote != null) {
            existingQuote.setContent(updatedQuote.getContent());
            existingQuote.setModifiedDate(LocalDate.from(LocalDateTime.now()));
            return quoteRepository.save(existingQuote);
        } else {
            return null;
        }
    }
    @Override
    public void deleteQuote(Long quoteId) {
        quoteRepository.deleteById(quoteId);
    }
}
