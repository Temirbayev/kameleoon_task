package com.temirbayev.kameleoon.service.impl;

import com.temirbayev.kameleoon.model.Quote;
import com.temirbayev.kameleoon.model.Users;
import com.temirbayev.kameleoon.model.dto.VoteDto;
import com.temirbayev.kameleoon.model.dto.VoteType;
import com.temirbayev.kameleoon.repository.QuoteRepository;
import com.temirbayev.kameleoon.repository.UserRepository;
import com.temirbayev.kameleoon.repository.VoteRepository;
import com.temirbayev.kameleoon.service.VoteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;
    private final QuoteRepository quoteRepository;
    private final UserRepository userRepository;
    @Override
    public void deleteVote(Long voteId) {
        voteRepository.deleteById(voteId);
    }

//    @Transactional
//    public void vote(Long quoteId, VoteType voteType, Long userId) {
//        // Fetch the quote from the database
//        Quote quote = quoteRepository.findById(quoteId)
//                .orElseThrow(() -> new NotFoundException("Quote not found with id: " + quoteId));
//
//        // Fetch the user from the database
//        Users user = userRepository.findById(userId)
//                .orElseThrow(() -> new NotFoundException("User not found with id: " + userId));
//
//        // Check if the user has already voted on this quote
//        boolean hasVoted = quote.getVotes().stream()
//                .anyMatch(voteDto -> voteDto.getQuote().getId().equals(quoteId) && voteDto.getUserId().getId().equals(userId));
//
//        if (!hasVoted) {
//            // Create a new VoteDto
//            VoteDto vote = new VoteDto();
//            vote.setVoteType(voteType);
//            vote.setQuote(quote);
//            vote.setUserId(user);
//
//            // Add the vote to the quote and save the changes
//            quote.getVotes().add(vote);
//            quoteRepository.save(quote);
//        } else {
//            // Handle the case where the user has already voted on this quote
//            throw new RuntimeException("User has already voted on this quote");
//        }
//    }
}
