import { Component } from '@angular/core';
import {TransactionsService} from './transactions.service';
import {Transaction} from './transaction';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  transactions: Transaction[];

  constructor(
    private transactionsService: TransactionsService
  ) {
    this.transactionsService = transactionsService;
  }

  // tslint:disable-next-line:use-lifecycle-interface
  ngOnInit() {
    this.transactionsService.getTransactions().subscribe(
      transactions => {
        this.transactions = transactions;
      }, error => {
        console.log(error.message);
      }
    );
  }
}
