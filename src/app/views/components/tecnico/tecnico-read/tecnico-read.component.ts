import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Tecnico } from 'src/app/models/Tecnico';
import { TecnicoService } from 'src/app/services/tecnico.service';

//url: https://os-api-nfers.herokuapp.com/api/v1/technique

@Component({
  selector: 'app-tecnico-read',
  templateUrl: './tecnico-read.component.html',
  styleUrls: ['./tecnico-read.component.css']
})

export class TecnicoReadComponent implements AfterViewInit {

  tecnicos: Tecnico[] = []

  displayedColumns: string[] = ['id', 'name', 'cpf', 'phone', 'action'];
  dataSource = new MatTableDataSource<Tecnico>(this.tecnicos);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(
    private service : TecnicoService,
    private router : Router
    ) {
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.findAll();
  }

  findAll(): void {
    this.service.findAll().subscribe((res) => {
      this.tecnicos = res;
      this.dataSource = new MatTableDataSource<Tecnico>(this.tecnicos);
      this.dataSource.paginator = this.paginator;
    })
  }

  navigateToCreate():void {
    this.router.navigate(['tecnicos/novo'])
  }
}
