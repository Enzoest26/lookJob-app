import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListPostjobsComponent } from './list-postjobs.component';

describe('ListPostjobsComponent', () => {
  let component: ListPostjobsComponent;
  let fixture: ComponentFixture<ListPostjobsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListPostjobsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListPostjobsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
