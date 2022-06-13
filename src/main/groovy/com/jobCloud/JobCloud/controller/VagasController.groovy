package com.jobCloud.JobCloud.controller

import com.jobCloud.JobCloud.model.InserirEmpresas
import com.jobCloud.JobCloud.model.InserirVagas
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class VagasController {
    @RequestMapping(value = "/vagas",
            method = RequestMethod.GET)
    @ResponseBody
    public String vagasApi(){
        return "Get ta pegando vagas"
    }
    @PostMapping("/vagas/add")
    @ResponseBody
    String inserirVagas(@RequestParam(name = "nomeVaga") String nomeVaga, @RequestParam(name = "localVaga") String cidadeVaga, @RequestParam(name = "estadoVaga") String estadoVaga, @RequestParam(name = "salarioVaga") String salarioVaga, @RequestParam(name = "nivelVaga") String nivelVaga, @RequestParam(name = "outsideWork") String outsideWork, @RequestParam(name = "descricaoVaga") String descricaoVaga, @RequestParam(name = "angular") String angularVaga, @RequestParam(name = "java") String javaVaga, @RequestParam(name = "groovy") String groovyVaga, @RequestParam(name = "python") String pythonVaga, @RequestParam(name = "typescript") String typescriptVaga) {
        InserirVagas.registrarVagas(nomeVaga, cidadeVaga, estadoVaga, descricaoVaga, angularVaga , javaVaga, groovyVaga, pythonVaga, typescriptVaga)

    }
}
