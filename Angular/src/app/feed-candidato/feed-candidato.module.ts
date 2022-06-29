import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FeedCandidatoComponent } from './feed-candidato/feed-candidato.component';
import {RouterModule} from "@angular/router";
import {MatTableModule} from '@angular/material/table';
import {MatToolbarModule} from '@angular/material/toolbar';
import {ReactiveFormsModule} from "@angular/forms";




@NgModule({
  declarations: [
    FeedCandidatoComponent
  ],
    imports: [
        CommonModule,
        RouterModule,
        MatTableModule,
        MatToolbarModule,
        ReactiveFormsModule
    ]
})
export class FeedCandidatoModule { }
