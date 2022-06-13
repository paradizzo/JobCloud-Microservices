$(document).ready(function() {
    $(".container").click(function() {
        $(".stick").toggleClass(function () {
            return $(this).is('.open, .close') ? 'open close' : 'open';
        });
    });
    $(".candidato").click(function (){
        let formacaoCandidato = $(this).children(".formacao-candidato").text()
        let descricaoCandidato = $(this).children(".descricao-candidato").text()
        $('.formacao-candidato-descricao').text(formacaoCandidato)
        $('.descricao-candidato-box').children('p').text(descricaoCandidato)
    })
    $(document).ready(function() {

        let progress = $('.progressbar .progress')
        // Ele checa a totalidade de skills e declaração de variaveis
        let angularCount = 0
        let javaCount = 0
        let groovyCount = 0
        let pythonCount = 0
        let typeScriptCount = 0
        // @ts-ignore
        let arraySkills = Array.from($('.skills'), e => e.innerText)
        let totalSkills = $('.skills').length
        // Ele faz a contagem geral no documento e adiciona ao contador
        arraySkills.forEach(element =>{
            if (element === "Angular" ){
                angularCount += 1
            } else if(element === "Java") {
                javaCount += 1
            } else if (element === "Groovy") {
                groovyCount += 1
            } else if (element === 'Python') {
                pythonCount += 1
            } else if (element === "TypeScript") {
                typeScriptCount += 1
            }
        })
        function counterInit( count, name ) {
            let counter_value = (count/totalSkills)*200;
            $('.bracket-box').append(
                ` <li class="bracket-skills">
                            <p class="count-skills">${name}</p>
                        <div class="progressbar">
                            <span class="progress" id='${name}'></span>
                        </div>
                            <p class="count-skills">Quantidade: ${count}</p>
                    </li>`
            )
            let nomeReal = $('#' + name)
            nomeReal.css({ 'width': counter_value});
        }



        counterInit( angularCount , "Angular");
        counterInit( javaCount, "Java");
        counterInit( groovyCount, "Groovy");
        counterInit( pythonCount, "Python");
        counterInit( typeScriptCount, "Typescript");

    });
    let formVaga = $('#form-register-vaga')
    formVaga.submit(function (e){
        e.preventDefault()
        let nomeVaga = $("#nomeVaga").val()
        let localVaga = $("#localVaga").val()
        let estadoVaga = $("#estadoVaga").val()
        let salarioVaga = $("#salarioVaga").val()
        let nivelVaga = $("#nivelVaga").val()
        let outsideWork = $("#outsideWorkVaga").val()
        let descricaoVaga = $("#descricaoVaga").val()
        let angularVaga = $("#angular").is(':checked')
        let javaVaga = $("#java").is(':checked')
        let groovyVaga = $("#groovy").is(':checked')
        let pythonVaga = $("#python").is(':checked')
        let typescriptVaga = $("#typescript").is(':checked')
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
                "outsideWork": outsideWork,
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
});