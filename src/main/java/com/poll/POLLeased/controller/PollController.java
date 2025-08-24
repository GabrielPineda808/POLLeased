package com.poll.POLLeased.controller;

import com.poll.POLLeased.model.Poll;
import com.poll.POLLeased.service.PollService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/poll")
public class PollController {
    private PollService ps;

    public PollController(PollService ps) {
        this.ps = ps;
    }

    @PostMapping
    public Poll createPoll(@RequestBody Poll poll){
        return ps.save(poll);
    }

    @GetMapping
    public List<Poll> getAll(){
        return ps.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable long id){
        return ps.getPoll(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
