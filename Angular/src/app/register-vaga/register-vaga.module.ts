import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegisterVagaComponent } from './register-vaga/register-vaga.component';
import {RouterModule} from "@angular/router";
import {ReactiveFormsModule} from "@angular/forms";



@NgModule({
  declarations: [
    RegisterVagaComponent
  ],
    imports: [
        CommonModule,
        RouterModule,
        ReactiveFormsModule
    ]
})
export class RegisterVagaModule { }
