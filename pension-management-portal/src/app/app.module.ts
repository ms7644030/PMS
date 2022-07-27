import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PensionPortalComponent } from './components/pension-portal/pension-portal.component';
import { AddPensionerComponent } from './components/add-pensioner/add-pensioner.component';
import { ViewPensionerComponent } from './components/view-pensioner/view-pensioner.component';
import { SpinnerComponent } from './components/spinner/spinner.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PensionPortalComponent,
    AddPensionerComponent,
    ViewPensionerComponent,
    SpinnerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
