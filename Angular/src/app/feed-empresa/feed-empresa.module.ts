import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeedEmpresaComponent } from './feed-empresa/feed-empresa.component';
import {RouterModule} from "@angular/router";
import {FeedCandidatoComponent} from "../feed-candidato/feed-candidato/feed-candidato.component";
import {FeedCandidatoModule} from "../feed-candidato/feed-candidato.module";



@NgModule({
  declarations: [
    FeedEmpresaComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    FeedCandidatoModule,
  ]
})
export class FeedEmpresaModule { }
