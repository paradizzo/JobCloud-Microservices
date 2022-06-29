import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { } from "./landing-page/homepage/homepage.component"
import {RouterModule, Routes} from "@angular/router";
import {LoginPageComponent} from "./login-page/login-page/login-page.component";
import {RegisterPageComponent} from "./register-page/register-page/register-page.component";
import {FeedCandidatoComponent} from "./feed-candidato/feed-candidato/feed-candidato.component";
import {FeedEmpresaComponent} from "./feed-empresa/feed-empresa/feed-empresa.component";
import {HomepageComponent} from "./landing-page/homepage/homepage.component";
import {RegisterVagaComponent} from "./register-vaga/register-vaga/register-vaga.component";

const routes: Routes = [
  {
    path: '', component: HomepageComponent
  },
  {
    path: 'login', component: LoginPageComponent,
    loadChildren: () => import('./login-page/login-page.module').then(m => m.LoginPageModule)
  },
  {
    path: 'register', component: RegisterPageComponent,
    loadChildren: () => import('./register-page/register-page.module').then(m => m.RegisterPageModule)
  },
  {
    path: 'feedCandidato', component: FeedCandidatoComponent,
    loadChildren: () => import('./feed-candidato/feed-candidato.module').then(m => m.FeedCandidatoModule)
  },
  {
    path: 'feedEmpresa', component: FeedEmpresaComponent,
    loadChildren: () => import('./feed-empresa/feed-empresa.module').then(m => m.FeedEmpresaModule)
  },
  {
    path: 'criacaoVaga', component: RegisterVagaComponent,
    loadChildren: () => import('./register-vaga/register-vaga.module').then(m => m.RegisterVagaModule)
  }
]

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    [RouterModule.forRoot(routes)]
  ]
})
export class AppRoutingModule { }
