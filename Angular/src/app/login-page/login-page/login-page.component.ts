import { Component, OnInit } from '@angular/core';
import * as $ from "jquery"
@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    $(document).ready(function() {
      var toggleCandidato = $(document.querySelectorAll(".toggle-candidato.focus"))
      var toggleEmpresa = $(document.querySelectorAll(".toggle-empresa"))
      $(toggleCandidato).click(function (){
        $(document.querySelectorAll("#login-button-candidato")).show()
        $(document.querySelectorAll("#login-button-empresa")).hide()
      })
      $(document.querySelectorAll(".toggle-empresa")).click(function (){
        $(document.querySelectorAll("#login-button-empresa")).show()
        $(document.querySelectorAll("#login-button-candidato")).hide()
      })
      $(function() {
        toggleEmpresa.click(function (e){
          e.preventDefault();
          toggleEmpresa.removeClass('focus')
          toggleCandidato.addClass('focus')
          $(this).addClass('focus')
          toggleCandidato.removeClass('focus')
          $('#form-login-empresa').show()
          $("#form-login-candidato").hide()
        })
        toggleCandidato.click(function(e) {
          e.preventDefault();

          toggleCandidato.removeClass('focus');
          toggleEmpresa.addClass('focus')
          $(this).addClass('focus');
          toggleEmpresa.removeClass('focus')
          $('#form-login-empresa').hide()
          $("#form-login-candidato").show()

        });
      });
    });
  }

}
