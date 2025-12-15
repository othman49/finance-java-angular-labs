import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PortfolioService, Holding } from './portfolio.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <h1>Portfolio Dashboard</h1>

    <h3>Ajouter un holding</h3>
    <form (ngSubmit)="add()">
      <input [(ngModel)]="symbol" name="symbol" placeholder="Symbol (ex: AAPL)" required>
      <input [(ngModel)]="quantity" name="quantity" type="number" placeholder="Quantity" required>
      <input [(ngModel)]="avgCost" name="avgCost" type="number" placeholder="Avg Cost" required>
      <button type="submit">Ajouter</button>
    </form>

    <h3>Holdings</h3>
    <button (click)="load()">Recharger</button>

    <ul>
      <li *ngFor="let h of holdings">
        {{h.symbol}} — Qty: {{h.quantity}} — Avg: {{h.avgCost}}
      </li>
    </ul>
  `
})
export class AppComponent {
  holdings: Holding[] = [];

  symbol = 'AAPL';
  quantity = 1;
  avgCost = 150;

  constructor(private api: PortfolioService) {
    this.load();
  }

  load() {
    this.api.getHoldings().subscribe(data => this.holdings = data);
  }

  add() {
    this.api.addHolding(this.symbol, this.quantity, this.avgCost)
      .subscribe(() => this.load());
  }
}
