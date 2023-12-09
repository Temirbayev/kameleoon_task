package com.temirbayev.kameleoon.repository;

import com.temirbayev.kameleoon.model.dto.VoteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface VoteRepository extends JpaRepository<VoteDto, Long> {
}
