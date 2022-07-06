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
class CandidatosController {

    CandidatosService candidatosService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond candidatosService.list(params), model:[candidatosCount: candidatosService.count()]
    }

    def show(Long id) {
        respond candidatosService.get(id)
    }

    @Transactional
    def save(Candidatos candidatos) {
        if (candidatos == null) {
            render status: NOT_FOUND
            return
        }
        if (candidatos.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond candidatos.errors
            return
        }

        try {
            candidatosService.save(candidatos)
        } catch (ValidationException e) {
            respond candidatos.errors
            return
        }

        respond candidatos, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Candidatos candidatos) {
        if (candidatos == null) {
            render status: NOT_FOUND
            return
        }
        if (candidatos.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond candidatos.errors
            return
        }

        try {
            candidatosService.save(candidatos)
        } catch (ValidationException e) {
            respond candidatos.errors
            return
        }

        respond candidatos, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null || candidatosService.delete(id) == null) {
            render status: NOT_FOUND
            return
        }

        render status: NO_CONTENT
    }
}
