package crudgrails


class Candidatos {
    Integer id
    String nome
    String sobrenome
    String dataDeNascimento
    String email
    String cpf
    String pais
    String cep
    String descricao
    String senha
    boolean angular
    boolean java
    boolean groovy
    boolean typescript
    boolean python
    String toString() { "${this.class.name} : $id" }
    static constraints = {
    }
    static mapping = {
        id column: "id", type: "integer", sqlType: "int", generator: 'identity'
        version false
    }
}
