import { Component, OnInit } from '@angular/core';
import { Certificat } from '../model/certificat';
import { CertificatService } from '../service/certificat.service';

@Component({
  selector: 'app-certificat-list',
  templateUrl: './certificat-list.component.html',
  styleUrls: ['./certificat-list.component.css']
})
export class CertificatListComponent implements OnInit {

  certificats: Certificat[];

  constructor(private certificatService: CertificatService) { }

  ngOnInit() {
    this.certificatService.findAll().subscribe(data => {
      this.certificats = data;
    });
  }

}
