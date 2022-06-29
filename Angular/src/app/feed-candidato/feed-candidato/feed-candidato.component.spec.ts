import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedCandidatoComponent } from './feed-candidato.component';

describe('FeedCandidatoComponent', () => {
  let component: FeedCandidatoComponent;
  let fixture: ComponentFixture<FeedCandidatoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeedCandidatoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FeedCandidatoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
