import { Estadia } from './estadia';

export class Hospede {
  id: number = 0;
  nome: string = '';
  documento: string = '';
  telefone: string = '';
  estadias: Array<Estadia> = [];
  valorUltimaEstadia: number = 0;
  valorTotalEstadias: number = 0;
}
