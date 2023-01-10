import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePostjobComponent } from './create-postjob.component';

describe('CreatePostjobComponent', () => {
  let component: CreatePostjobComponent;
  let fixture: ComponentFixture<CreatePostjobComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatePostjobComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatePostjobComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
