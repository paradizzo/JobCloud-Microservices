import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {VagasService} from "../services/vagas.service";

@Component({
  selector: 'app-register-vaga',
  templateUrl: './register-vaga.component.html',
  styleUrls: ['./register-vaga.component.css']
})
export class RegisterVagaComponent implements OnInit {

  formVaga: FormGroup;
  constructor(private formBuilder: FormBuilder, private service: VagasService, private router:Router) {
    this.formVaga = this.formBuilder.group({
      nome: [null],
      estado:[null],
      cidade: [null],
      descricao: [null],
      angular: [false],
      groovy: [false],
      python: [false],
      java: [false],
      typescript: [false]
    })
  }

  ngOnInit(): void {

  }
  onSubmit() {
    this.service.savevaga(this.formVaga.value).subscribe(result => console.log(result))
    this.router.navigate(['/feedEmpresa'])
  }
}
