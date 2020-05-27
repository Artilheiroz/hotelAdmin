import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroHospedeComponent } from './cadastro-hospede.component';

describe('CadastroHospedeComponent', () => {
  let component: CadastroHospedeComponent;
  let fixture: ComponentFixture<CadastroHospedeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CadastroHospedeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroHospedeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
