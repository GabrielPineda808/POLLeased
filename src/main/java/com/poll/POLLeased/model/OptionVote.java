package com.poll.POLLeased.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class OptionVote {
    private String pollOption;
    private Long voteCount = 0L;

    public OptionVote() {
    }

    public OptionVote(String pollOption, Long voteCount) {
        this.pollOption = pollOption;
        this.voteCount = voteCount;
    }

    public String getPollOption() {
        return pollOption;
    }

    public void setPollOption(String pollOption) {
        this.pollOption = pollOption;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }
}
