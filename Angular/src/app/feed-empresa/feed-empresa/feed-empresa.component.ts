import { Component, OnInit } from '@angular/core';
import * as $ from 'jquery'
import {Observable} from "rxjs";
import {Candidato} from "../../feed-candidato/model/candidato";
import {CandidatosService} from "../../feed-candidato/services/candidatos.service";

@Component({
  selector: 'app-feed-empresa',
  templateUrl: './feed-empresa.component.html',
  styleUrls: ['./feed-empresa.component.css']
})
export class FeedEmpresaComponent implements OnInit {
  candidatos:Observable<Candidato[]>;

  constructor(private candidatosService: CandidatosService) {
    this.candidatos = this.candidatosService.listaCandidatos()
  }


  ngOnInit(): void {
    $(document).ready(function() {
      $(".container").click(function() {
        $(".stick").toggleClass(function () {
          return $(this).is('.open, .close') ? 'open close' : 'open';
        });
      });
      $(".candidato").click(function (){
        let formacaoCandidato = $(this).children(".formacao-candidato").text()
        let descricaoCandidato = $(this).children(".descricao-candidato").text()
        $('.formacao-candidato-descricao').text(formacaoCandidato)
        $('.descricao-candidato-box').children('p').text(descricaoCandidato)
      })
      $(document).ready(function() {

        let progress = $('.progressbar .progress')
        // Ele checa a totalidade de skills e declaração de variaveis
        let angularCount = 0
        let javaCount = 0
        let groovyCount = 0
        let pythonCount = 0
        let typeScriptCount = 0
        // @ts-ignore
        let arraySkills = Array.from($('.skills'), e => e.innerText)
        let totalSkills = $('.skills').length
        // Ele faz a contagem geral no documento e adiciona ao contador
        arraySkills.forEach(element =>{
          if (element === "Angular" ){
            angularCount += 1
          } else if(element === "Java") {
            javaCount += 1
          } else if (element === "Groovy") {
            groovyCount += 1
          } else if (element === 'Python') {
            pythonCount += 1
          } else if (element === "TypeScript") {
            typeScriptCount += 1
          }
        })
        function counterInit({count, name}: { count: any, name: any } ) {
          let counter_value = (count/totalSkills)*200;
          $('.bracket-box').append(
            ` <li class="bracket-skills">
                            <p class="count-skills">${name}</p>
                        <div class="progressbar">
                            <span class="progress" id='${name}'></span>
                        </div>
                            <p class="count-skills">Quantidade: ${count}</p>
                    </li>`
          )
          let nomeReal = $('#' + name)
          nomeReal.css({ 'width': counter_value});
        }



        counterInit( {count: angularCount, name: "Angular"});
        counterInit( {count: javaCount, name: "Java"});
        counterInit( {count: groovyCount, name: "Groovy"});
        counterInit( {count: pythonCount, name: "Python"});
        counterInit( {count: typeScriptCount, name: "Typescript"});

      });
    });
  }
  changeBigBox() {
    $(".candidato").click(function (){
      let formacaoCandidato = $(this).children(".formacao-candidato").text()
      let descricaoCandidato = $(this).children(".descricao-candidato").text()
      let angularCandidato = $(this).children(".skills-box").children('#angular').text()
      let pythonCandidato = $(this).children(".skills-box").children('#python').text()
      let groovyCandidato = $(this).children(".skills-box").children('#groovy').text()
      let typescriptCandidato = $(this).children(".skills-box").children('#typescript').text()
      let javaCandidato = $(this).children(".skills-box").children('#java').text()

      $('.formacao-candidato-descricao').text(formacaoCandidato)
      $('.descricao-candidato-box').children('p').text(descricaoCandidato)
      $('.descricao-candidato-box').children('#angular-bigbox').text(angularCandidato)
      $('.descricao-candidato-box').children('#groovy-bigbox').text(groovyCandidato)
      $('.descricao-candidato-box').children('#python-bigbox').text(pythonCandidato)
      $('.descricao-candidato-box').children('#java-bigbox').text(javaCandidato)
      $('.descricao-candidato-box').children('#typescript-bigbox').text(typescriptCandidato)
    })
  }
}

