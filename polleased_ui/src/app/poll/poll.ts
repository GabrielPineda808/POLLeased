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
}
