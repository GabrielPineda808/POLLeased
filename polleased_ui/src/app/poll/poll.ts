import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PollService } from '../poll';
import { Poll } from '../poll.models';

@Component({
  selector: 'app-poll',
  standalone: true,                    
  imports: [CommonModule, FormsModule],
  templateUrl: './poll.html',
  styleUrls: ['./poll.css']            
})
export class PollComponent implements OnInit {

  newPoll: Poll = {
    id: 0,
    question: '',
    options: [
      {pollOption: '', voteCount: 0},
      {pollOption: '', voteCount: 0}
    ]
  }

  polls: Poll[] = [];
  loading = false;
  errorMsg = '';

  constructor(private pollService: PollService) {}

  ngOnInit(): void {
    this.loadPolls();
  }

  loadPolls(): void {
    this.loading = true;
    this.errorMsg = '';
    this.pollService.getPolls().subscribe({
      next: (data) => {
        this.polls = data;
      },
      error: (err) => {
        console.error('Error fetching polls:', err);
        this.errorMsg = 'Failed to load polls.';
      },
      complete: () => this.loading = false
    });
  }

  createPoll(){
    this.pollService.createPoll(this.newPoll).subscribe({
      next:(createdPoll)=>{
        this.polls.push(createdPoll);
        this.resetPoll();
      },
      error:(error) =>{
        console.error("Error fetching polls: ", error);
      }
    });
  }

  resetPoll(){
    this.newPoll = {
      id: 0,
      question: '',
      options: [
        {pollOption: '', voteCount: 0},
        {pollOption: '', voteCount: 0}
      ]
    };
  }

  vote(pollId: number, optionIndex: number){
    this.pollService.vote(pollId, optionIndex).subscribe({
      next: ()=>{
        const poll = this.polls.find(p => p.id === pollId);
        if(poll){
          poll.options[optionIndex].voteCount++
        }
      },
      error: (error) => {
        console.error("Error voting on poll")
      }
    })
  }

  addOption(){
    this.newPoll.options.push({pollOption: '', voteCount: 0})
  }

}
