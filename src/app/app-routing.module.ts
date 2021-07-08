import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ClienteCreateComponent } from './views/components/clientes/cliente-create/cliente-create.component';
import { ClienteDeleteComponent } from './views/components/clientes/cliente-delete/cliente-delete.component';
import { ClienteReadComponent } from './views/components/clientes/cliente-read/cliente-read.component';
import { ClienteUpdateComponent } from './views/components/clientes/cliente-update/cliente-update.component';
import { HomeComponent } from './views/components/home/home.component';
import { OrdemServicoCreateComponent } from './views/components/ordem-servico/ordem-servico-create/ordem-servico-create.component';
import { OrdemServicoReadComponent } from './views/components/ordem-servico/ordem-servico-read/ordem-servico-read.component';
import { TecnicoCreateComponent } from './views/components/tecnico/tecnico-create/tecnico-create.component';
import { TecnicoDeleteComponent } from './views/components/tecnico/tecnico-delete/tecnico-delete.component';
import { TecnicoReadComponent } from './views/components/tecnico/tecnico-read/tecnico-read.component';
import { TecnicoUpdateComponent } from './views/components/tecnico/tecnico-update/tecnico-update.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'tecnicos',
    component: TecnicoReadComponent
  },
  {
    path: 'tecnicos/novo',
    component: TecnicoCreateComponent
  },
  {
    path: 'tecnicos/alterar/:id',
    component: TecnicoUpdateComponent
  },
  {
    path: 'tecnicos/delete/:id',
    component: TecnicoDeleteComponent
  },
  {
    path: 'clientes',
    component: ClienteReadComponent
  },
  {
    path: 'clientes/novo',
    component: ClienteCreateComponent
  },
  {
    path: 'clientes/alterar/:id',
    component: ClienteUpdateComponent
  },
  {
    path: 'clientes/delete/:id',
    component: ClienteDeleteComponent  
  },
  {
    path: 'ordem-servico',
    component: OrdemServicoReadComponent
  },
  {
    path: 'ordem-servico/novo',
    component: OrdemServicoCreateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
