import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterVagaComponent } from './register-vaga.component';

describe('RegisterVagaComponent', () => {
  let component: RegisterVagaComponent;
  let fixture: ComponentFixture<RegisterVagaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterVagaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterVagaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
