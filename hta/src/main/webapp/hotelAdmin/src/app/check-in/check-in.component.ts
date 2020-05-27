import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Estadia } from '../estadia';
import { Hospede } from '../hospede';

@Component({
  selector: 'app-check-in',
  templateUrl: './check-in.component.html',
  styleUrls: ['./check-in.component.scss'],
})
export class CheckInComponent implements OnInit {
  estadia: Estadia;
  hospedes: Array<Hospede>;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.estadia = new Estadia();

    this.http
      .get('http://localhost:8080/hotelAdmin/hospede/getHospedes')
      .subscribe((response) => {
        this.hospedes = response as Array<Hospede>;
      });
  }

  testeVar() {
    console.log(this.estadia);
  }

  salvarCheckin() {
    this.http
      .post('http://localhost:8080/hotelAdmin/estadia/createEstadia', {
        hospede: this.estadia.hospede,
        dataEntrada: this.estadia.dataEntrada + ':00',
        dataSaida: this.estadia.dataSaida + ':00',
        adicionalVeiculo: this.estadia.adicionalVeiculo,
      })
      .subscribe((response) => {
        this.estadia = new Estadia();
      });
  }
}
