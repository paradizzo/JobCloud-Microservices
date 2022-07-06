package crudgrails

import grails.gorm.services.Service

@Service(Empresas)
interface EmpresasService {

    Empresas get(Serializable id)

    List<Empresas> list(Map args)

    Long count()

    Empresas delete(Serializable id)

    Empresas save(Empresas empresas)

}
