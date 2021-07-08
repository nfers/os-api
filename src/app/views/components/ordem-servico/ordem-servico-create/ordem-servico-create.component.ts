import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Os } from 'src/app/models/Ordem-Servico';
import { OrdemServicoService } from 'src/app/services/ordem-servico.service';

@Component({
  selector: 'app-ordem-servico-create',
  templateUrl: './ordem-servico-create.component.html',
  styleUrls: ['./ordem-servico-create.component.css']
})
export class OrdemServicoCreateComponent implements  OnInit {

  os: Os = {
    id: '',
    created_at: '',
    closed_on: '',
    priority: '',
    obeservations: '',
    client: '',
    status: '',
    technique: ''
  };

  name = new FormControl('', [Validators.minLength(5)]);
  cpf = new FormControl('', [Validators.minLength(11)]);
  phone = new FormControl('', [Validators.minLength(11)]);

  constructor(
    private router: Router,
    private service: OrdemServicoService
  ) { }

  ngOnInit(): void {
  }

  cancel(): void {
    this.router.navigate(['tecnicos'])
  }

  create(): void {
    this.service.create(this.os).subscribe((res) => {
      this.router.navigate(['ordem-servico'])

      this.service.message('Ordem de Servico Criado com Sucesso');
    }, err => {
      console.log(err)
      if (err.message !== '') {
        this.service.message(`Falha ao adicionar Ordem de Servico nome: ${this.os.name},
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
