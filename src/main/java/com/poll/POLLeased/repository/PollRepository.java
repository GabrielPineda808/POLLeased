package com.poll.POLLeased.repository;

import com.poll.POLLeased.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {
    List<Poll> getAll();
    Poll getPollById(Long id);
}
