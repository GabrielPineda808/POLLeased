package com.poll.POLLeased.service;

import com.poll.POLLeased.model.Poll;
import com.poll.POLLeased.repository.PollRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
public class PollService {
    private PollRepository pr;

    public List<Poll> getAll(){
        return pr.findAll();
    }

    public Poll save(Poll poll){
        return pr.save(poll);
    }

}
