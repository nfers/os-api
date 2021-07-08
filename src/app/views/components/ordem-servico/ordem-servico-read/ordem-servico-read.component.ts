import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Os } from 'src/app/models/Ordem-Servico';
import { ClienteService } from 'src/app/services/cliente.service';
import { OrdemServicoService } from 'src/app/services/ordem-servico.service';
import { TecnicoService } from 'src/app/services/tecnico.service';

@Component({
  selector: 'app-ordem-servico-read',
  templateUrl: './ordem-servico-read.component.html',
  styleUrls: ['./ordem-servico-read.component.css']
})
export class OrdemServicoReadComponent implements  AfterViewInit {

  lista: Os[] = []

  displayedColumns: string[] = ['id','created_at','closed_on','priority','client','status','technique', 'action'];
  dataSource = new MatTableDataSource<Os>(this.lista);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private service : OrdemServicoService,
    private router : Router,
    private tecnicoService : TecnicoService,
    private cliService : ClienteService
    ) {
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((res) => {
      this.lista = res;
      this.listTecnicos();
      this.listCli;
      this.dataSource = new MatTableDataSource<Os>(this.lista);
      this.dataSource.paginator = this.paginator;
    })
  }

  navigateToCreate():void {
    this.router.navigate(['ordem-servico/novo'])
  }

  listTecnicos(): void {
    this.lista.forEach(tec => {
      this.tecnicoService.findById(tec.technique).subscribe(res => {
        tec.technique = res.name
      })
    });
  }

   listCli(): void {
    this.lista.forEach(cli => {
      this.cliService.findById(cli.client).subscribe(res => {
        tec.client = res.name
      })
    });
  }

  prioridade(x : any) {
    if(x == 'LOW') {
      return 'baixa'
    } else if (x == 'AVERAGE') {
      return 'media'
    }
  }
}
