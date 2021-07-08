import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/app/models/Cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente-update',
  templateUrl: './cliente-update.component.html',
  styleUrls: ['./cliente-update.component.css']
})
export class ClienteUpdateComponent implements OnInit {

  id_cli = '';

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
    private service: ClienteService, 
    private route: ActivatedRoute
  ) { }


  ngOnInit(): void {
    this.id_cli = this.route.snapshot.paramMap.get('id')!
    this.findById();
  }

  findById(): void {
    this.service.findById(this.id_cli).subscribe((res) => {
      this.cliente = res;
    })
  }

  cancel(): void {
    this.router.navigate(['clientes'])
  }

  update(): void {
    this.service.update(this.cliente).subscribe((res) => {
      this.router.navigate(['clientes'])
      this.service.message('Cliente alterado com Sucesso');
    }, err => {
      console.log(err)
      if (err.message !== '') {
        this.service.message(`Falha ao alterar os dados do Cliente: ${this.cliente.name},
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
