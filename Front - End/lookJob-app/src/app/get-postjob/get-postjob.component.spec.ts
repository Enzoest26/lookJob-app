import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetPostjobComponent } from './get-postjob.component';

describe('GetPostjobComponent', () => {
  let component: GetPostjobComponent;
  let fixture: ComponentFixture<GetPostjobComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetPostjobComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetPostjobComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
