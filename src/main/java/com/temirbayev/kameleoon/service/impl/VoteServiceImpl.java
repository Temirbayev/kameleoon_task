package com.temirbayev.kameleoon.service.impl;

import com.temirbayev.kameleoon.repository.VoteRepository;
import com.temirbayev.kameleoon.service.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {
    private final VoteRepository voteRepository;
    @Override
    public void deleteVote(Long voteId) {
        voteRepository.deleteById(voteId);
    }

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
}
