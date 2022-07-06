package crudgrails

class Empresas {
    Integer id
    String nome
    String email
    String cnpj
    String pais
    String cep
    String senha
    static constraints = {
    }
    static mapping = {
        id column: "id", type: "integer", sqlType: "int", generator: 'identity'
        version false
    }
}
