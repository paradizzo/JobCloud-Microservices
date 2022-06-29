import { Injectable } from '@angular/core';
import {Candidato} from "../model/candidato";
import {HttpClient} from "@angular/common/http";
import {first, tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CandidatosService {

  private readonly APICandidatos = 'http://localhost:8080/api/candidatos'
  constructor(private httpClient: HttpClient) { }


  listaCandidatos(){
    return this.httpClient.get<Candidato[]>(this.APICandidatos).pipe(first(),
      tap(candidatos => console.log(candidatos))
    )
  }
  savecandidato(record: Candidato) {
    return this.httpClient.post<Candidato>(this.APICandidatos, record).pipe(first())
  }
}
