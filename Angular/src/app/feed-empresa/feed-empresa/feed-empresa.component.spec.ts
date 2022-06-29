import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedEmpresaComponent } from './feed-empresa.component';

describe('FeedEmpresaComponent', () => {
  let component: FeedEmpresaComponent;
  let fixture: ComponentFixture<FeedEmpresaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeedEmpresaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FeedEmpresaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
