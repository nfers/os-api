import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatListModule } from '@angular/material/list';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSnackBarModule } from '@angular/material/snack-bar';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './views/components/templates/header/header.component';
import { FooterComponent } from './views/components/templates/footer/footer.component';
import { NavComponent } from './views/components/templates/nav/nav.component';
import { HomeComponent } from './views/components/home/home.component';
import { TecnicoReadComponent } from './views/components/tecnico/tecnico-read/tecnico-read.component';
import { ClienteReadComponent } from './views/components/clientes/cliente-read/cliente-read.component';
import { OsReadComponent } from './views/components/ordensServico/os-read/os-read.component';
import { TecnicoCreateComponent } from './views/components/tecnico/tecnico-create/tecnico-create.component';
import { TecnicoUpdateComponent } from './views/components/tecnico/tecnico-update/tecnico-update.component';
import { TecnicoDeleteComponent } from './views/components/tecnico/tecnico-delete/tecnico-delete.component';
import { ClienteCreateComponent } from './views/components/clientes/cliente-create/cliente-create.component';
import { ClienteDeleteComponent } from './views/components/clientes/cliente-delete/cliente-delete.component';
import { OsCreateComponent } from './views/components/ordensServico/os-create/os-create.component';
import { ClienteUpdateComponent } from './views/components/cliente-update/cliente-update.component';
import { OrdemServicoReadComponent } from './views/components/ordem-servico/ordem-servico-read/ordem-servico-read.component';
import { OrdemServicoCreateComponent } from './views/components/ordem-servico-create/ordem-servico-create.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    TecnicoReadComponent,
    ClienteReadComponent,
    OsReadComponent,
    TecnicoCreateComponent,
    TecnicoUpdateComponent,
    TecnicoDeleteComponent,
    ClienteCreateComponent,
    ClienteDeleteComponent,
    OsCreateComponent,
    ClienteUpdateComponent,
    OrdemServicoReadComponent,
    OrdemServicoCreateComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    MatCardModule,
    MatTableModule,
    MatSelectModule,
    MatInputModule,
    MatDatepickerModule,
    MatPaginatorModule,
    MatSnackBarModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
