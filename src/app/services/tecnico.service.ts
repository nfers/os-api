import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Tecnico } from '../models/Tecnico';

@Injectable({
  providedIn: 'root'
})
export class TecnicoService {

  baseUrl: String = environment.baseUrl;

  constructor(
    private http: HttpClient,
    private snack: MatSnackBar
  ) { }

  findAll(): Observable<Tecnico[]> {
    const url = this.baseUrl + "/api/v1/technique";

    return this.http.get<Tecnico[]>(url);
  }

  create(tecnico: Tecnico): Observable<Tecnico> {
    const url = this.baseUrl + "/api/v1/technique";

    return this.http.post<Tecnico>(url, tecnico)
  }

  findById(id: any): Observable<Tecnico> {
    const url = this.baseUrl + "/api/v1/technique/" + id;
    console.log("chamou aqui")
    return this.http.get<Tecnico>(url);
  }

  update(tecnico: Tecnico): Observable<Tecnico> {
    const url = this.baseUrl + "/api/v1/technique/" + tecnico.id;

    return this.http.put<Tecnico>(url, tecnico)
  }

  delete(id: any): Observable<void> {
    const url = this.baseUrl + "/api/v1/technique/" + id;

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
