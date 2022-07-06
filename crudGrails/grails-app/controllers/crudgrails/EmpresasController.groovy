package crudgrails

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class EmpresasController {

    EmpresasService empresasService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond empresasService.list(params), model:[empresasCount: empresasService.count()]
    }

    def show(Long id) {
        respond empresasService.get(id)
    }

    @Transactional
    def save(Empresas empresas) {
        if (empresas == null) {
            render status: NOT_FOUND
            return
        }
        if (empresas.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond empresas.errors
            return
        }

        try {
            empresasService.save(empresas)
        } catch (ValidationException e) {
            respond empresas.errors
            return
        }

        respond empresas, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Empresas empresas) {
        if (empresas == null) {
            render status: NOT_FOUND
            return
        }
        if (empresas.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond empresas.errors
            return
        }

        try {
            empresasService.save(empresas)
        } catch (ValidationException e) {
            respond empresas.errors
            return
        }

        respond empresas, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || empresasService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
