import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Cliente } from '../models/Cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  baseUrl: String = environment.baseUrl;

  constructor(
    private http: HttpClient,
    private snack: MatSnackBar
  ) { }

  findAll(): Observable<Cliente[]> {
    const url = this.baseUrl + "/api/v1/client";

    return this.http.get<Cliente[]>(url);
  }

  create(Cliente: Cliente): Observable<Cliente> {
    const url = this.baseUrl + "/api/v1/client";

    return this.http.post<Cliente>(url, Cliente)
  }

  findById(id: any): Observable<Cliente> {
    const url = this.baseUrl + "/api/v1/client/" + id;
    console.log("chamou aqui")
    return this.http.get<Cliente>(url);
  }

  update(Cliente: Cliente): Observable<Cliente> {
    const url = this.baseUrl + "/api/v1/client/" + Cliente.id;

    return this.http.put<Cliente>(url, Cliente)
  }

  delete(id: any): Observable<void> {
    const url = this.baseUrl + "/api/v1/client/" + id;

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
