package com.cloudjob.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cloudjob.connection.connection;
import com.cloudjob.model.Empresa;
import com.cloudjob.model.InserirEmpresas;
import com.cloudjob.repository.EmpresaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/empresas")
@AllArgsConstructor
public class EmpresaController {

    private final EmpresaRepository empresaRepository;

    @GetMapping
    public @ResponseBody
    Object list() {
        String BUSCAR_EMPRESAS = "SELECT JSON_AGG(empresas) AS empresa FROM(SELECT empresas.id, empresas.nome, empresas.email, empresas.cnpj, empresas.pais, empresas.cep, empresas.senha FROM empresas) empresas";
        try {
            Connection conn = connection.conexao();
            PreparedStatement empresa = conn.prepareStatement(BUSCAR_EMPRESAS, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resEmpresa = empresa.executeQuery();
            resEmpresa.last();
            int quantidadeEmpresas = resEmpresa.getRow();
            resEmpresa.beforeFirst();

            if (quantidadeEmpresas == 0) {
                System.out.println("Não existem Empresas");
            }
            while (resEmpresa.next() )
            {
                return resEmpresa.getString(1);
            }

        } catch(Exception e){
            e.printStackTrace();
            System.err.println("Erro buscando empresas");
            System.exit(-42);
        }
        return empresaRepository.findAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public Empresa create(@RequestBody Empresa empresa) {
        String nomeEmpresa = empresa.getNome();
        String emailEmpresa = empresa.getEmail();
        String cnpjEmpresa = empresa.getCnpj();
        String paisEmpresa = empresa.getPais();
        String cepEmpresa = empresa.getCep();
        String senhaEmpresa = empresa.getSenha();
        InserirEmpresas.registrarEmpresas(nomeEmpresa, emailEmpresa, cnpjEmpresa, paisEmpresa, cepEmpresa, senhaEmpresa);

        return empresaRepository.save(empresa);
    }

}
