package com.cloudjob.controller

import com.cloudjob.model.Empresa
import com.cloudjob.model.Vaga
import com.cloudjob.service.VagaService
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.Put
import jakarta.inject.Inject

import javax.validation.Valid

@Controller("/api/")
class VagasController {


    @Inject
    private  VagaService vagaService

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/vagas")
    List<Vaga> list() {
        return vagaService.findAll()
    }

    @Consumes(MediaType.ALL)
    @Post("/vagas")
    HttpResponse<Vaga> save(@Body @Valid Vaga vaga){
        vagaService.save(vaga)
        Kafka.enviaInfo(vaga)
        return HttpResponse
                .created(vaga)
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Get("/vagas/{id}")
    Vaga show(Integer id) {
        return vagaService.findById(id).orElse(null)
    }


    @Consumes(MediaType.ALL)
    @Put("/vagas/{id}")
    HttpResponse update(@Body @Valid Vaga vaga) {
        int nbrOfUpdated = vagaService.update(vaga.getId(), vaga);
        return HttpResponse.ok(vaga)
    }

}
