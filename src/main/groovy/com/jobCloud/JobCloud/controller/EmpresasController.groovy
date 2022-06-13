package com.jobCloud.JobCloud.controller

import com.jobCloud.JobCloud.model.InserirCandidatos
import com.jobCloud.JobCloud.model.InserirEmpresas
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class EmpresasController {
    @RequestMapping(value = "/empresas",
            method = RequestMethod.GET)
    @ResponseBody
    public String empresasApi(){
        return "Get ta pegando empresas"
    }

    @PostMapping("/empresas/add")
    @ResponseBody
    String inserirCandidatos(@RequestParam(name = "nomeSobrenomeEmpresa") String nomeSobrenomeEmpresa, @RequestParam(name = "CNPJ") String CNPJ, @RequestParam(name = "paisEmpresa") String paisEmpresa, @RequestParam(name = "emailEmpresa") String emailEmpresa, @RequestParam(name = "CEPempresa") String cepEmpresa, @RequestParam(name = "descricaoEmpresa") String descricaoEmpresa, @RequestParam(name = "passwordEmpresa") String senhaEmpresa) {

        InserirEmpresas.registrarEmpresas(nomeSobrenomeEmpresa, emailEmpresa, CNPJ, paisEmpresa , cepEmpresa, descricaoEmpresa, senhaEmpresa)

    }
}
