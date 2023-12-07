package com.temirbayev.kameleoon.repository;

import com.temirbayev.kameleoon.model.dto.VoteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<VoteDto, Long> {
}
