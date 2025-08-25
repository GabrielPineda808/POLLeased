import { Component, OnInit } from '@angular/core';
import { PollService } from '../poll';
import { Poll } from '../poll.models';

@Component({
  selector: 'app-poll',
  imports: [],
  templateUrl: './poll.html',
  styleUrl: './poll.css'
})
export class PollComponent implements OnInit{

  polls: Poll[] = [];

  constructor(private pollService: PollService){};

  ngOnInit(): void {
    this.loadPolls();
  };

  loadPolls(){
    this.pollService.getPolls().subscribe({
      next: (data)=>{
        this.polls;
      },
      error: (error) =>{
        console.error("Error fetching polls: ", error);
      }
    });
  };
}
