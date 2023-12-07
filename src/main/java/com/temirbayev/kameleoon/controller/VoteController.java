package com.temirbayev.kameleoon.controller;

import com.temirbayev.kameleoon.service.VoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/votes")
public class VoteController {
    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    /*
 Голосование по цитате
    @PostMapping("/vote")
    public ResponseEntity<VoteDto> vote(@RequestParam Long quoteId, @RequestParam VoteType voteType) {
        VoteDto vote = voteService.vote(quoteId, voteType);
        return ResponseEntity.status(HttpStatus.CREATED).body(vote);
    }
*/

    // Удаление голоса по ID
    @DeleteMapping("/{voteId}")
    public ResponseEntity<Void> deleteVote(@PathVariable Long voteId) {
        voteService.deleteVote(voteId);
        return ResponseEntity.noContent().build();
    }
}

