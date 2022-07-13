package com.cloudjob.controller

import com.cloudjob.model.Candidato

import com.cloudjob.service.CandidatoService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.Put
import jakarta.inject.Inject

import javax.validation.Valid

@Controller("/api/")
class CandidatosController {


    @Inject
    private  CandidatoService candidatoService

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/candidatos")
    List<Candidato> list() {
        return candidatoService.findAll()
    }

    @Consumes(MediaType.ALL)
    @Post("/candidatos")
    HttpResponse<Candidato> save(@Body @Valid Candidato candidato){
        candidatoService.save(candidato)
        return HttpResponse
                .created(candidato)
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Get("/candidatos/{id}")
    Candidato show(Integer id) {
        return candidatoService.findById(id).orElse(null)
    }

    @Consumes(MediaType.ALL)
    @Put("/candidatos/{id}")
    HttpResponse update(@Body @Valid Candidato candidato) {
        int nbrOfUpdated = candidatoService.update(candidato.getId(), candidato);
        return HttpResponse.ok(candidato)
    }




}
