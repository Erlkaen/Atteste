import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CertificatFormComponent } from './certificat-form.component';

describe('CertificatFormComponent', () => {
  let component: CertificatFormComponent;
  let fixture: ComponentFixture<CertificatFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CertificatFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CertificatFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
