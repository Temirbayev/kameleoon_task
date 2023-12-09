package com.temirbayev.kameleoon.service;

import com.temirbayev.kameleoon.model.Quote;

import java.util.List;

public interface QuoteService {

    Quote getRandomQuote();
    List<Quote> getTopQuotes();
    List<Quote> getWorstQuotes();
    Quote getQuoteById(Long quoteId);
    Quote createQuote(Quote quote);
    Quote updateQuote(Long quoteId, Quote updatedQuote);
    void deleteQuote(Long quoteId);

}
