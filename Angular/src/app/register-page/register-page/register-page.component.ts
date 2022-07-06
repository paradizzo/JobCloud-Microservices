import { Component, OnInit } from '@angular/core';
import * as $ from "jquery";
import {FormBuilder, FormGroup} from "@angular/forms";
import {CandidatosService} from "../../feed-candidato/services/candidatos.service";
import { Router } from '@angular/router';
import {EmpresasService} from "../../feed-empresa/feed-empresa/services/empresas.service";

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  formCandidato: FormGroup;
  formEmpresa: FormGroup;
  constructor(private formBuilder: FormBuilder, private service: CandidatosService, private serviceEmpresa: EmpresasService, private router:Router) {
    this.formCandidato = this.formBuilder.group({
      nome: [null],
      sobrenome:[null],
      dataDeNascimento:[null],
      email: [null],
      cpf: [null],
      descricao: [null],
      formacao: [null],
      cep: [null],
      pais: [null],
      senha: [null],
      angular: [false],
      groovy: [false],
      python: [false],
      java: [false],
      typescript: [false]
    })
    this.formEmpresa = this.formBuilder.group( {
      nome: [null],
      email: [null],
      cnpj: [null],
      pais: [null],
      cep: [null],
      descricao: [null],
      senha: [null],
    })
  }

  onSubmit() {
    this.service.savecandidato(this.formCandidato.value).subscribe(result => console.log(result))
    this.router.navigate(['/login'])
  }
  registerEmpresa() {
    this.serviceEmpresa.saveempresa(this.formEmpresa.value).subscribe(result => console.log(result))
    this.router.navigate(['/login'])
  }

  ngOnInit(): void {
    $(document).ready(function () {
      var toggleEmpresa = $(".toggle-empresa");
      var toggleCandidato = $(".toggle-candidato");
      $(function () {
        toggleEmpresa.click(function (e) {
          e.preventDefault();
          toggleEmpresa.removeClass('focus');
          toggleCandidato.addClass('focus');
          $(this).addClass('focus');
          toggleCandidato.removeClass('focus');
          $("#login-button-candidato").hide();
          $("#form-register-candidato").hide();
          $("#form-register-empresa").show();
          $("#login-button-empresa").show();
        });
        toggleCandidato.click(function (e) {
          e.preventDefault();
          toggleCandidato.removeClass('focus');
          toggleEmpresa.addClass('focus');
          $(this).addClass('focus');
          toggleEmpresa.removeClass('focus');
          $("#login-button-candidato").show();
          $("#form-register-candidato").show();
          $("#form-register-empresa").hide();
          $("#login-button-empresa").hide();
        });
      });
      var formCandidato = $("#form-register-candidato");
      formCandidato.submit(function (e) {
        e.preventDefault();
        var emailCandidato = $("#email").val();
        var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        // @ts-ignore
        var valid = regex.test(emailCandidato);
        if (valid == false) {
          $('#error-email').show();
        }
        else {
          $('#error-email').hide();
        }

      });
      $(document).ready(function () {
        validate();
        $('#nomeSobrenome, #dataDeNascimento, #email , #CPF , #pais ,  #formacao, #descricaoCandidato, #cep , #password').change(validate);
      });
      function validate() {
        // @ts-ignore
        if ($('#nome').val().length > 0 &&
          // @ts-ignore
          $('#Sobrenome').val().length > 0 &&
          // @ts-ignore
          $('#dataDeNascimento').val().length > 0 &&
          // @ts-ignore
          $('#CPF').val().length > 0 &&
          // @ts-ignore
          $('#pais').val().length > 0 &&
          // @ts-ignore
          $('#formacao').val().length > 0 &&
          // @ts-ignore
          $('#descricaoCandidato').val().length > 0 &&
          // @ts-ignore
          $('#cep').val().length > 0 &&
          // @ts-ignore
          $('#password').val().length > 0 &&
          // @ts-ignore
          $('#email').val().length > 0) {
          $("#login-button-candidato").prop("disabled", false);
        }
        else {
          $("#login-button-candidato").prop("disabled", true);
        }
      }
    });
  }
}

