import {
  Component,
  OnInit,
  Input,
  OnChanges,
  SimpleChanges,
} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Hospede } from '../hospede';

@Component({
  selector: 'app-tabela-hospede',
  templateUrl: './tabela-hospede.component.html',
  styleUrls: ['./tabela-hospede.component.scss'],
})
export class TabelaHospedeComponent implements OnInit, OnChanges {
  hospedes: Array<Hospede>;
  searchType: string = 'a';
  searchPresentes: boolean = false;
  searchPassados: boolean = false;
  page: number = 1;
  pageSize: number = 10;

  @Input() recarregarTabela: boolean;

  ngOnChanges(changes: SimpleChanges) {
    console.log(changes);
  }

  constructor(private http: HttpClient) {}

  getTodosHospedes = function () {
    this.http
      .get('http://localhost:8080/hotelAdmin/hospede/getHospedes')
      .subscribe((response) => {
        this.hospedes = response as Array<Hospede>;
      });
  };

  getHospedesPresentes = function () {
    this.searchPassados = false;
    this.http
      .get('http://localhost:8080/hotelAdmin/hospede/getHospedesAtivos')
      .subscribe((response) => {
        this.hospedes = response as Array<Hospede>;
      });
  };

  getHospedesPassados = function () {
    this.searchPresentes = false;
    this.http
      .get('http://localhost:8080/hotelAdmin/hospede/getHospedesAnteriores')
      .subscribe((response) => {
        this.hospedes = response as Array<Hospede>;
      });
  };

  ngOnInit(): void {
    this.getTodosHospedes();
  }
}
