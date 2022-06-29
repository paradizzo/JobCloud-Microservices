import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import {LandingPageModule} from "./landing-page/landing-page.module";
import { AppRoutingModule } from './app-routing.module';
import {FeedCandidatoModule} from "./feed-candidato/feed-candidato.module";
import {FeedEmpresaModule} from "./feed-empresa/feed-empresa.module";
import {LoginPageModule} from "./login-page/login-page.module";
import {RegisterPageModule} from "./register-page/register-page.module";
import {RouterModule} from "@angular/router";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LandingPageModule,
    FeedEmpresaModule,
    FeedCandidatoModule,
    LoginPageModule,
    RegisterPageModule,
    RouterModule,
    LandingPageModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
