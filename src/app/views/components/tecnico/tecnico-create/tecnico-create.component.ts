import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Tecnico } from 'src/app/models/Tecnico';
import { TecnicoService } from 'src/app/services/tecnico.service';

@Component({
  selector: 'app-tecnico-create',
  templateUrl: './tecnico-create.component.html',
  styleUrls: ['./tecnico-create.component.css']
})

export class TecnicoCreateComponent implements OnInit {

  tecnico: Tecnico = {
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
    private service: TecnicoService
  ) { }

  ngOnInit(): void {
  }

  cancel(): void {
    this.router.navigate(['tecnicos'])
  }

  create(): void {
    this.service.create(this.tecnico).subscribe((res) => {
      this.router.navigate(['tecnicos'])

      this.service.message('Técnico Criado com Sucesso');
    }, err => {
      console.log(err)
      if (err.message !== '') {
        this.service.message(`Falha ao adicionar Técnico nome: ${this.tecnico.name},
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
