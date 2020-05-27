import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Hospede } from '../hospede';
import { HttpClient } from '@angular/common/http';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-cadastro-hospede',
  templateUrl: './cadastro-hospede.component.html',
  styleUrls: ['./cadastro-hospede.component.scss'],
  providers: [NgbModalConfig, NgbModal],
})
export class CadastroHospedeComponent implements OnInit {
  hospede: Hospede;

  constructor(
    private http: HttpClient,
    config: NgbModalConfig,
    private modalService: NgbModal
  ) {
    config.backdrop = 'static';
    config.keyboard = false;
  }

  @Output() reloadTable = new EventEmitter<boolean>();

  open(content) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' });
  }

  ngOnInit(): void {
    this.hospede = new Hospede();
  }

  salvarHospede() {
    this.http
      .post('http://localhost:8080/hotelAdmin/hospede/createHospede', {
        nome: this.hospede.nome,
        documento: this.hospede.documento,
        telefone: this.hospede.telefone,
      })
      .subscribe((response) => {
        this.hospede = new Hospede();
        this.reloadTable.emit(true);
        this.modalService.dismissAll();
      });
  }
}
