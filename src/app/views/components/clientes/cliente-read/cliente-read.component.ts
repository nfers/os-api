import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { FormControl, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Cliente } from 'src/app/models/Cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente-read',
  templateUrl: './cliente-read.component.html',
  styleUrls: ['./cliente-read.component.css']
})

export class ClienteReadComponent implements OnInit {

  
  cliente: Cliente = {
    id: '',
    name: '',
    cpf: '',
    phone: ''
  };

  name = new FormControl('', [Validators.minLength(5)]);
  cpf = new FormControl('', [Validators.minLength(11)]);
  phone = new FormControl('', [Validators.minLength(11)]);

  constructor(
    private router: Router,
    private service: ClienteService
  ) { }

  ngOnInit(): void {
  }

  cancel(): void {
    this.router.navigate(['clientes'])
  }

  create(): void {
    this.service.create(this.cliente).subscribe((res) => {
      this.router.navigate(['clientes'])

      this.service.message('Cliente Criado com Sucesso');
    }, err => {
      console.log(err)
      if (err.message !== '') {
        this.service.message(`Falha ao adicionar Cliente nome: ${this.tecnico.name},
         mensagem: ${err.message}`)
      }
    })
  }

  errorValidName() {
    if (this.name.invalid) {
      return 'O nome deve ter no mínimo 5 carácteres';
    }
    return false;
  }

  errorValidPhone() {
    if (this.phone.invalid) {
      return 'O Telefone deve ter no mínimo 11 carácteres';
    }
    return false;
  }

  errorValidCpf() {
    if (this.cpf.invalid) {
      return 'O cpf deve ter no mínimo 11 carácteres';
    }
    return false;
  }
}