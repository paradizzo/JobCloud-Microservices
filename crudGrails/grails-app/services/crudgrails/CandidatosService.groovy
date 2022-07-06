package crudgrails

import grails.gorm.services.Service

@Service(Candidatos)
interface CandidatosService {

    Candidatos get(Serializable id)

    List<Candidatos> list(Map args)

    Long count()

    Candidatos delete(Serializable id)

    Candidatos save(Candidatos candidatos)

}
