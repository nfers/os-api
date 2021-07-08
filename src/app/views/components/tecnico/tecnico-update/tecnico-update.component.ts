import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Tecnico } from 'src/app/models/Tecnico';
import { TecnicoService } from 'src/app/services/tecnico.service';

@Component({
  selector: 'app-tecnico-update',
  templateUrl: './tecnico-update.component.html',
  styleUrls: ['./tecnico-update.component.css']
})
export class TecnicoUpdateComponent implements OnInit {

  id_tech = '';

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
    private service: TecnicoService, 
    private route: ActivatedRoute
  ) { }


  ngOnInit(): void {
    this.id_tech = this.route.snapshot.paramMap.get('id')!
    this.findById();
  }

  findById(): void {
    this.service.findById(this.id_tech).subscribe((res) => {
      this.tecnico = res;
    })
  }

  cancel(): void {
    this.router.navigate(['tecnicos'])
  }

  update(): void {
    this.service.update(this.tecnico).subscribe((res) => {
      this.router.navigate(['tecnicos'])
      this.service.message('Técnico Criado com Sucesso');
    }, err => {
      console.log(err)
      if (err.message !== '') {
        this.service.message(`Falha ao alterar os dados do Técnico: ${this.tecnico.name},
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
