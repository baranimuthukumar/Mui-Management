import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdditionDetailsComponent } from './components/addition-details/addition-details.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import {MatDialogModule} from '@angular/material/dialog';
import { EditDialogComponent } from './components/edit-dialog/edit-dialog.component';
import { MatIconModule } from '@angular/material/icon';
import { AdminPortalComponent } from './components/admin-portal/admin-portal.component';
import { AdminService } from './services/admin.service';
import { AdditionDetailsService } from './services/addition-details.service'
import { HttpClientModule } from '@angular/common/http';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTabsModule } from '@angular/material/tabs';
import {MatSelectModule} from '@angular/material/select';
import { ReactiveFormsModule } from '@angular/forms';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatCardModule} from '@angular/material/card';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatDatepickerModule} from '@angular/material/datepicker';



@NgModule({
  declarations: [
    AppComponent,
    AdditionDetailsComponent,
    EditDialogComponent,
    AdminPortalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatDialogModule,
    MatIconModule,
    MatToolbarModule,
    HttpClientModule,
    MatTabsModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatPaginatorModule,
    MatSortModule,
    MatExpansionModule,
    MatCardModule,
    MatProgressSpinnerModule,
    MatDatepickerModule,
  ],
  providers: [
    AdminService,
    AdditionDetailsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
