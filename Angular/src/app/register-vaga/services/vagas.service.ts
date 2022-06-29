import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {first, tap} from "rxjs";
import {Vaga} from "../model/vaga";

@Injectable({
  providedIn: 'root'
})
export class VagasService {

  private readonly APIVaga = 'http://localhost:8080/api/vagas'
  constructor(private httpClient: HttpClient) { }


  listaVagas(){
    return this.httpClient.get<Vaga[]>(this.APIVaga).pipe(first(),
      tap(vagas => console.log(vagas))
    )
  }
  savevaga(record: Vaga) {
    return this.httpClient.post<Vaga>(this.APIVaga, record).pipe(first())
  }
}
