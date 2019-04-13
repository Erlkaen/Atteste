import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Certificat } from '../model/certificat';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class CertificatService {

  private certificatUrl: string;

  constructor(private http: HttpClient) {
    this.certificatUrl = '/api/certificat';
  }

  public findAll(): Observable<Certificat[]> {
    return this.http.get<Certificat[]>(this.certificatUrl);
  }

  public save(Certificat: Certificat) {
    return this.http.post<Certificat>(this.certificatUrl, Certificat);
  }
}
