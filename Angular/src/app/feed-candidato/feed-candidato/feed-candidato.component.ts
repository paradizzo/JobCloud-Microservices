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
        $('.formacao-candidato-descricao').text(formacaoCandidato)
        $('.descricao-vaga-big-box').text(descricaoCandidato)
      })
    }
}
