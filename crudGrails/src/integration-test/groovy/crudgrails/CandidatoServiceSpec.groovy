package crudgrails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class CandidatoServiceSpec extends Specification {

    CandidatoService candidatoService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Candidato(...).save(flush: true, failOnError: true)
        //new Candidato(...).save(flush: true, failOnError: true)
        //Candidato candidato = new Candidato(...).save(flush: true, failOnError: true)
        //new Candidato(...).save(flush: true, failOnError: true)
        //new Candidato(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //candidato.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        candidatoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Candidato> candidatoList = candidatoService.list(max: 2, offset: 2)

        then:
        candidatoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        candidatoService.count() == 5
    }

    void "test delete"() {
        Long candidatoId = setupData()

        expect:
        candidatoService.count() == 5

        when:
        candidatoService.delete(candidatoId)
        datastore.currentSession.flush()

        then:
        candidatoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Candidato candidato = new Candidato()
        candidatoService.save(candidato)

        then:
        candidato.id != null
    }
}
