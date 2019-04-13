import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CertificatService } from '../service/certificat.service';
import { Certificat } from '../model/certificat';

@Component({
  selector: 'app-certificat-form',
  templateUrl: './certificat-form.component.html',
  styleUrls: ['./certificat-form.component.css']
})
export class CertificatFormComponent {

  certificat: Certificat;

  constructor(private route: ActivatedRoute, private router: Router, private certificatService: CertificatService) {
    this.certificat = new Certificat();
  }

  onSubmit() {
    this.certificatService.save(this.certificat).subscribe(result => this.goToCertificatList());
  }

  goToCertificatList() {
    this.router.navigate(['/certificats']);
  }

}
