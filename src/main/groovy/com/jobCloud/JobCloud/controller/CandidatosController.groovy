package com.jobCloud.JobCloud.controller

import com.jobCloud.JobCloud.model.InserirCandidatos
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CandidatosController {


    @RequestMapping(value = "/candidatos",
            method = RequestMethod.GET)
    @ResponseBody
    public String candidatosApi(){
        return "Get ta pegando candidatos"
    }

    @PostMapping("/candidatos/add")
    @ResponseBody
    String inserirCandidatos(@RequestParam(name = "nomeSobrenome") String nomeSobrenome,@RequestParam(name = "dataDeNascimento") String nascimentoCandidato, @RequestParam(name = "CPF") String cpfCandidato, @RequestParam(name = "pais") String paisCandidato, @RequestParam(name = "email") String emailCandidato, @RequestParam(name = "cep") String cepCandidato, @RequestParam(name = "descricaoCandidato") String descricaoCandidato, @RequestParam(name = "password") String senhaCandidato, @RequestParam(name = "angular") String angularCandidato, @RequestParam(name = "java") String javaCandidato, @RequestParam(name = "groovy") String groovyCandidato, @RequestParam(name = "python") String pythonCandidato, @RequestParam(name = "typescript") String typescriptCandidato) {

        String[] arrayNomeSobrenome = nomeSobrenome.split(" ", 2)
        String nomeCandidato = arrayNomeSobrenome[0]
        String sobrenome = arrayNomeSobrenome[1]
        String formacaoCandidato = "W/E"
        InserirCandidatos.registrarCandidatos(nomeCandidato, sobrenome, nascimentoCandidato, emailCandidato, cpfCandidato, paisCandidato, cepCandidato, formacaoCandidato, descricaoCandidato, senhaCandidato, angularCandidato, javaCandidato, groovyCandidato, pythonCandidato, typescriptCandidato)

    }
}
