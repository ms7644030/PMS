import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPensionerComponent } from './components/add-pensioner/add-pensioner.component';
import { PensionPortalComponent } from './components/pension-portal/pension-portal.component';
import { ViewPensionerComponent } from './components/view-pensioner/view-pensioner.component';

const routes: Routes = [

  {path : '',redirectTo: 'pensioner/admin', pathMatch: 'full'},
  {path :'pensioner/admin', component : PensionPortalComponent},
  {path : 'pensioner/add', component : AddPensionerComponent},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
