import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { MlService, PredictResponse } from './ml.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <h1>Model Serving</h1>

    <h3>Entrer des features</h3>
    <label>Income norm:
      <input [(ngModel)]="income" name="income" type="number">
    </label><br>

    <label>Debt ratio:
      <input [(ngModel)]="debt" name="debt" type="number">
    </label><br>

    <label>Late payments:
      <input [(ngModel)]="late" name="late" type="number">
    </label><br>

    <button (click)="run()">Predict</button>

    <div *ngIf="result">
      <h3>Résultat</h3>
      <p>Model: {{result.modelName}} v{{result.version}}</p>
      <p>Probability: {{result.probability}}</p>
    </div>
  `
})
export class AppComponent {
  income = 0.6;
  debt = 0.3;
  late = 1.0;

  result?: PredictResponse;

  constructor(private api: MlService) {}

  run() {
    this.api.predict({
      modelName: 'credit_model',
      features: [this.income, this.debt, this.late]
    }).subscribe(res => this.result = res);
  }
}
