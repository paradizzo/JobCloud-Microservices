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
class VagasController {

    VagasService vagasService
    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vagasService.list(params), model:[vagasCount: vagasService.count()]
    }

    def show(Long id) {
        respond vagasService.get(id)
    }

    @Transactional
    def save(Vagas vagas) {
        if (vagas == null) {
            render status: NOT_FOUND
            return
        }
        if (vagas.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond vagas.errors
            return
        }

        try {
            vagasService.save(vagas)
        } catch (ValidationException e) {
            respond vagas.errors
            return
        }

        respond vagas, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Vagas vagas) {
        if (vagas == null) {
            render status: NOT_FOUND
            return
        }
        if (vagas.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond vagas.errors
            return
        }

        try {
            vagasService.save(vagas)
        } catch (ValidationException e) {
            respond vagas.errors
            return
        }

        respond vagas, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || vagasService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
