package com.cloudjob.controller

import com.cloudjob.model.Candidato
import com.cloudjob.model.Empresa
import com.cloudjob.service.EmpresaService
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
class EmpresasController {


    @Inject
    private  EmpresaService empresaService

    @Produces(MediaType.APPLICATION_JSON)
    @Get("/empresas")
    List<Empresa> list() {
        return empresaService.findAll()
    }

    @Consumes(MediaType.ALL)
    @Post("/empresas")
    HttpResponse<Empresa> save(@Body @Valid Empresa empresa){
        empresaService.save(empresa)
        return HttpResponse
                .created(empresa)
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Get("/empresas/{id}")
    Empresa show(Integer id) {
        return empresaService.findById(id).orElse(null)
    }

    @Consumes(MediaType.ALL)
    @Put("/empresas/{id}")
    HttpResponse update(@Body @Valid Empresa empresa) {
        int nbrOfUpdated = empresaService.update(empresa.getId(), empresa);
        return HttpResponse.ok(empresa)
    }

}
