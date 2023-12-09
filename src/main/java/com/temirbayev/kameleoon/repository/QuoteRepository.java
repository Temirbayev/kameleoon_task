package com.temirbayev.kameleoon.repository;

import com.temirbayev.kameleoon.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query("SELECT q FROM Quote q ORDER BY SIZE(q.votes) DESC LIMIT 5")
    List<Quote> findTopQuotesByVotes();

    @Query("SELECT q FROM Quote q ORDER BY SIZE(q.votes) ASC LIMIT 5")
    List<Quote> findWorstQuotesByVotes();

}
