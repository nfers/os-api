import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cliente } from 'src/app/models/Cliente';
import { ClienteService } from 'src/app/services/cliente.service';

@Component({
  selector: 'app-cliente-delete',
  templateUrl: './cliente-delete.component.html',
  styleUrls: ['./cliente-delete.component.css']
})
export class ClienteDeleteComponent implements OnInit {

  id_cli = '';

  cliente: Cliente = {
    id: '',
    name: '',
    cpf: '',
    phone: ''
  };

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

  delete(): void {

    this.service.delete(this.id_cli).subscribe((res) => {
      this.router.navigate(['clientes'])
      this.service.message(`Cliente id ${this.id_cli} removido com sucesso!`)
    }, err => {
      console.log(err)
      if (err.message !== '') {
        this.service.message(`Erro ao remover o cliente id: ${this.id_tech},
         mensagem: ${err.message}`)
      }
    })
  }

  cancel(): void {
    this.router.navigate(['clientes'])
  }

}

