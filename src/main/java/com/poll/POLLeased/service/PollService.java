package com.poll.POLLeased.service;

import com.poll.POLLeased.model.Poll;
import com.poll.POLLeased.repository.PollRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PollService {
    private PollRepository pr;

    public List<Poll> getAllPolls(){
        return pr.getAllPoll();
    }
}
