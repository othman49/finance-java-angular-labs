import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DealsService, Deal } from './deals.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <h1>Angel Deal Flow</h1>

    <h3>Ajouter un deal</h3>
    <form (ngSubmit)="add()">
      <input [(ngModel)]="startupName" name="startupName" placeholder="Startup name" required>
      <input [(ngModel)]="sector" name="sector" placeholder="Sector (Fintech)" required>
      <input [(ngModel)]="stage" name="stage" placeholder="Stage (Seed)" required>
      <input [(ngModel)]="country" name="country" placeholder="Country" required>
      <input [(ngModel)]="ticketSize" name="ticketSize" type="number" placeholder="Ticket size" required>
      <button type="submit">Ajouter</button>
    </form>

    <h3>Deals</h3>
    <button (click)="load()">Recharger</button>

    <ul>
      <li *ngFor="let d of deals">
        {{d.startupName}} — {{d.sector}} — {{d.stage}} — Ticket: {{d.ticketSize}} — Score: {{d.score}}
      </li>
    </ul>
  `
})
export class AppComponent {
  deals: Deal[] = [];

  startupName = 'FintechX';
  sector = 'Fintech';
  stage = 'Seed';
  country = 'Morocco';
  ticketSize = 25000;

  constructor(private api: DealsService) {
    this.load();
  }

  load() {
    this.api.list().subscribe(data => this.deals = data);
  }

  add() {
    this.api.create({
      startupName: this.startupName,
      sector: this.sector,
      stage: this.stage,
      country: this.country,
      ticketSize: this.ticketSize
    }).subscribe(() => this.load());
  }
}
