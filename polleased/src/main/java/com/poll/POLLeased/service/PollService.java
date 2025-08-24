package com.poll.POLLeased.service;

import com.poll.POLLeased.dto.Vote;
import com.poll.POLLeased.model.OptionVote;
import com.poll.POLLeased.model.Poll;
import com.poll.POLLeased.repository.PollRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PollService {
    private PollRepository pr;

    public PollService(PollRepository pr) {
        this.pr = pr;
    }

    public List<Poll> getAll(){
        return pr.findAll();
    }

    public Poll save(Poll poll){
        return pr.save(poll);
    }

    public Optional<Poll> getPoll(Long id){
        return pr.findById(id);
    }

    public void vote(Long pollId, int optionIndex){
        Poll poll = pr.findById(pollId).orElseThrow(() -> new RuntimeException("Poll Not Found"));

        List<OptionVote> options = poll.getOptions();

        if(optionIndex < 0 || optionIndex >= options.size()){
           throw new IllegalArgumentException("Invalid Option Index");
        }

        OptionVote optionVote = options.get(optionIndex);
        optionVote.setVoteCount(optionVote.getVoteCount()+1);

        pr.save(poll);
    }
}
