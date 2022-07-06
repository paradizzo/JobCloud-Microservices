package crudgrails

import grails.gorm.services.Service

@Service(Vagas)
interface VagasService {

    Vagas get(Serializable id)

    List<Vagas> list(Map args)

    Long count()

    Vagas delete(Serializable id)

    Vagas save(Vagas vagas)

}
