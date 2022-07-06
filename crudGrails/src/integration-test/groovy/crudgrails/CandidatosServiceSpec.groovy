package crudgrails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import org.grails.datastore.mapping.core.Datastore
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

@Integration
@Rollback
class CandidatosServiceSpec extends Specification {

    CandidatosService candidatosService
    @Autowired Datastore datastore

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Candidatos(...).save(flush: true, failOnError: true)
        //new Candidatos(...).save(flush: true, failOnError: true)
        //Candidatos candidatos = new Candidatos(...).save(flush: true, failOnError: true)
        //new Candidatos(...).save(flush: true, failOnError: true)
        //new Candidatos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //candidatos.id
    }

    void cleanup() {
        assert false, "TODO: Provide a cleanup implementation if using MongoDB"
    }

    void "test get"() {
        setupData()

        expect:
        candidatosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Candidatos> candidatosList = candidatosService.list(max: 2, offset: 2)

        then:
        candidatosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        candidatosService.count() == 5
    }

    void "test delete"() {
        Long candidatosId = setupData()

        expect:
        candidatosService.count() == 5

        when:
        candidatosService.delete(candidatosId)
        datastore.currentSession.flush()

        then:
        candidatosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Candidatos candidatos = new Candidatos()
        candidatosService.save(candidatos)

        then:
        candidatos.id != null
    }
}
