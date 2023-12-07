package com.temirbayev.kameleoon.repository;

import com.temirbayev.kameleoon.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query("SELECT q FROM Quote q ORDER BY SIZE(q.votes) DESC")
    List<Quote> findTopQuotesByVotes();

    @Query("SELECT q FROM Quote q ORDER BY SIZE(q.votes) ASC")
    List<Quote> findWorstQuotesByVotes();

}
