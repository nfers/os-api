import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Os } from '../models/Ordem-Servico';

@Injectable({
  providedIn: 'root'
})
export class OrdemServicoService {

  baseUrl: String = environment.baseUrl;

  constructor(
    private http: HttpClient,
    private snack: MatSnackBar
  ) { }

  findAll(): Observable<Os[]> {
    const url = this.baseUrl + "/api/v1/serviceorder";

    return this.http.get<Os[]>(url);
  }

  create(tecnico: Os): Observable<Os> {
    const url = this.baseUrl + "/api/v1/technique";

    return this.http.post<Os>(url, tecnico)
  }

  findById(id: any): Observable<Os> {
    const url = this.baseUrl + "/api/v1/serviceorder/" + id;
    
    return this.http.get<Os>(url);
  }

  update(os: Os): Observable<Os> {
    const url = this.baseUrl + "/api/v1/serviceorder/" + tecnico.id;

    return this.http.put<Os>(url, os)
  }

  delete(id: any): Observable<void> {
    const url = this.baseUrl + "/api/v1/serviceorder/" + id;

    return this.http.delete<void>(url);
  }

  message(msg: String): void {
    this.snack.open(`${msg}`, 'OK', {
      horizontalPosition: 'end',
      verticalPosition: 'top',
      duration: 4000
    })
  }
}
