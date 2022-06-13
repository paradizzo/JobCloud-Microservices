
$(document).ready(function() {
    var formVaga = $("#form-register-vaga")
    formVaga.submit(function (e){
        e.preventDefault()
        let nomeVaga = $("#nomeVaga").val()
        let localVaga = $("#localVaga").val()
        let estadoVaga = $("#estadoVaga").val()
        let salarioVaga = $("#salarioVaga").val()
        let nivelVaga = $("#nivelVaga").val()
        let OutsideWork = $("#outsideWorkVaga").val()
        let descricaoVaga = $("#descricaoVaga").val()
        let angularVaga = $("#angular").is(':checked')
        let javaVaga = $("#java").is(':checked')
        let groovyVaga = $("#groovy").is(':checked')
        let pythonVaga = $("#python").is(':checked')
        let typescriptVaga = $("#typescript").is(':checked')
        console.log("ENTREI NO AJAX")
        $.ajax({

            type: 'POST',
            url: 'http://localhost:8080/api/vagas/add',
            dataType: "text",
            data: {
                "nomeVaga": nomeVaga,
                "localVaga": localVaga,
                "estadoVaga": estadoVaga,
                "salarioVaga": salarioVaga,
                "nivelVaga": nivelVaga,
                "outsideWork": OutsideWork,
                "descricaoVaga": descricaoVaga,
                "angular": angularVaga,
                "java": javaVaga,
                "groovy": groovyVaga,
                "python": pythonVaga,
                "typescript": typescriptVaga
            },
            success: function () {
                window.location.href = "../feedEmpresa.html"
            },
            error: function() {
                alert("Alguma coisa deu errado ai maninho")
            }
        });
    })
})