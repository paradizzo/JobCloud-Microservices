import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {first, tap} from "rxjs";
import {Empresa} from "../model/empresa";

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  private readonly APIEmpresas = 'http://localhost:8080/api/empresas'
  constructor(private httpClient: HttpClient) { }


  listaEmpresas(){
    return this.httpClient.get<Empresa[]>(this.APIEmpresas).pipe(first(),
      tap(empresas => console.log(empresas))
    )
  }
  saveempresa(record: Empresa) {
    return this.httpClient.post<Empresa>(this.APIEmpresas, record).pipe(first())
  }
}
