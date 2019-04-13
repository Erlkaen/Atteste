import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CertificatListComponent } from './certificat-list.component';

describe('CertificatListComponent', () => {
  let component: CertificatListComponent;
  let fixture: ComponentFixture<CertificatListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CertificatListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CertificatListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
