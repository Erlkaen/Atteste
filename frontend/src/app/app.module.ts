import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CertificatListComponent } from './certificat-list/certificat-list.component';
import { CertificatFormComponent } from './certificat-form/certificat-form.component';
import { FormsModule } from '@angular/forms';
import { CertificatService } from './service/certificat.service';
import { NavmenuComponent } from './navmenu/navmenu.component';

@NgModule({
  declarations: [
    AppComponent,
    CertificatListComponent,
    CertificatFormComponent,
    NavmenuComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [CertificatService],
  bootstrap: [AppComponent]
})
export class AppModule { }
