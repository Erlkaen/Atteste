import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CertificatListComponent } from './certificat-list/certificat-list.component';
const routes: Routes = [
  {
    path: 'certificats',
    component: CertificatListComponent
  },
  {
    path: 'home',
    redirectTo: '/'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
