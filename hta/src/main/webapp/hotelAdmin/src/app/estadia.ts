import { Hospede } from './hospede';

export class Estadia {
  id: number = 0;
  hospede: Hospede = new Hospede();
  dataEntrada: string = '';
  dataSaida: string = '';
  adicionalVeiculo: boolean = false;
  valor: number = 0;
}
