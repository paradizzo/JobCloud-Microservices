import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery'
import {MatTableModule} from '@angular/material/table';
import {Candidato} from "../model/candidato";
import {CandidatosService} from "../services/candidatos.service";
import {Observable} from "rxjs";
import {Vaga} from "../../register-vaga/model/vaga";
import {VagasService} from "../../register-vaga/services/vagas.service";




@Component({
  selector: 'app-feed-candidato',
  templateUrl: './feed-candidato.component.html',
  styleUrls: ['./feed-candidato.component.css']
})

export class FeedCandidatoComponent implements OnInit {
  vagas: Observable<Vaga[]>
  displayedColumns = ['name', 'surname', 'country', 'cpf', 'cep']



  constructor(private vagasService: VagasService) {
    this.vagas = this.vagasService.listaVagas()
  }

  ngOnInit(): void {
    $(document).ready(function() {
      $(".container").click(function() {
        $(".stick").toggleClass(function () {
          return $(this).is('.open, .close') ? 'open close' : 'open';
        });
      });
    });
  }

  changeDescBox() {
    $(".vaga").click(function (){
        let formacaoCandidato = $(this).children(".nome-vaga").text()
        let descricaoCandidato = $(this).find('.descricao-vaga-span').text()
        let angularCandidato = $(this).children(".tag-list").children('#angular').text()
        let pythonCandidato = $(this).children(".tag-list").children('#python').text()
        let groovyCandidato = $(this).children(".tag-list").children('#groovy').text()
        let typescriptCandidato = $(this).children(".tag-list").children('#typescript').text()
        let javaCandidato = $(this).children(".tag-list").children('#java').text()
        $('.formacao-candidato-descricao').text(formacaoCandidato)
        $('.vaga-content-descricao').children('p').text(descricaoCandidato)
        $('.vaga-content-descricao').children('#angular-bigbox').text(angularCandidato)
        $('.vaga-content-descricao').children('#groovy-bigbox').text(groovyCandidato)
        $('.vaga-content-descricao').children('#python-bigbox').text(pythonCandidato)
        $('.vaga-content-descricao').children('#java-bigbox').text(javaCandidato)
        $('.vaga-content-descricao').children('#typescript-bigbox').text(typescriptCandidato)
      })
    }
}
