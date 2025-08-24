package com.poll.POLLeased.controller;

import com.poll.POLLeased.model.Poll;
import com.poll.POLLeased.service.PollService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poll")
public class PollController {
    private PollService ps;

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        return ps.save(poll);
    }

    @GetMapping
    public List<Poll> getAll(){
        return ps.getAll();
    }
}
