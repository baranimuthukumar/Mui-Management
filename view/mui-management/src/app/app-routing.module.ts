import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdditionDetailsComponent } from './components/addition-details/addition-details.component';
import { AdminPortalComponent } from './components/admin-portal/admin-portal.component';

const routes: Routes = [
  { path: '', redirectTo: '/admin-portal', pathMatch: 'full' },
  { path: 'addition-details', component: AdditionDetailsComponent },
  { path: 'admin-portal', component: AdminPortalComponent },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
