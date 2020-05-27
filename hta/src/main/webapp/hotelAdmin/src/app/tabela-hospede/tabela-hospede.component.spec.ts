import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TabelaHospedeComponent } from './tabela-hospede.component';

describe('TabelaHospedeComponent', () => {
  let component: TabelaHospedeComponent;
  let fixture: ComponentFixture<TabelaHospedeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabelaHospedeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabelaHospedeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
