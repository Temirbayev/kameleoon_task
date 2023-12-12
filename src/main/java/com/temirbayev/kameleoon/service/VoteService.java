package com.temirbayev.kameleoon.service;

import com.temirbayev.kameleoon.model.dto.VoteDto;
import com.temirbayev.kameleoon.model.dto.VoteType;

public interface VoteService {

    void deleteVote(Long voteId);
   // void vote(Long quoteId, VoteType voteType, Long userId);

}
