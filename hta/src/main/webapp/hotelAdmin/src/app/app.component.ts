import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'hotelAdmin';

  public reloadTable: boolean;

  confereCarregarTabela(recarregar: boolean) {
    this.reloadTable = recarregar;
  }
}
