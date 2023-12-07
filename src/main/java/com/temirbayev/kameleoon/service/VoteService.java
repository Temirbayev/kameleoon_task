package com.temirbayev.kameleoon.service;

import com.temirbayev.kameleoon.repository.VoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;

//    public VoteDto vote(Long quoteId, VoteType voteType) {
//        // Проверяем, существует ли цитата
//        Quote quote = quoteRepository.findById(quoteId).orElse(null);
//
//        if (quote != null) {
//            // Проверяем, голосовал ли пользователь ранее (пример)
//            // Дополнительная логика может потребоваться
//            boolean hasVoted = voteRepository.existsByQuoteIdAndUserId(quoteId, /*userId*/);
//            if (!hasVoted) {
//                VoteDto vote = new VoteDto();
//                vote.setQuote(quote);
//                vote.setVoteType(voteType);
//                return voteRepository.save(vote);
//            } else {
//                // Обработка случая, когда пользователь уже голосовал
//                throw new RuntimeException("Вы уже голосовали по этой цитате");
//            }
//        } else {
//            // Обработка случая, когда цитата не существует
//            throw new RuntimeException("Цитата не найдена");
//        }
//    }

    public void deleteVote(Long voteId) {
        voteRepository.deleteById(voteId);
    }
}
