package crudgrails

class Vagas {
    Integer id
    String nome
    String descricao
    String estado
    String cidade
    boolean angular
    boolean java
    boolean groovy
    boolean typescript
    boolean python

    static constraints = {
    }
    static mapping = {
        id column: "id", type: "integer", sqlType: "int", generator: 'identity'
        version false
    }
}
