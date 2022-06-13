$(document).ready(function () {
    var toggleEmpresa = $(".toggle-empresa");
    var toggleCandidato = $(".toggle-candidato");
    $(function () {
        toggleEmpresa.click(function (e) {
            e.preventDefault();
            toggleEmpresa.removeClass('focus');
            toggleCandidato.addClass('focus');
            $(this).addClass('focus');
            toggleCandidato.removeClass('focus');
            $("#login-button-candidato").hide();
            $("#form-register-candidato").hide();
            $("#form-register-empresa").show();
            $("#login-button-empresa").show();
        });
        toggleCandidato.click(function (e) {
            e.preventDefault();
            toggleCandidato.removeClass('focus');
            toggleEmpresa.addClass('focus');
            $(this).addClass('focus');
            toggleEmpresa.removeClass('focus');
            $("#login-button-candidato").show();
            $("#form-register-candidato").show();
            $("#form-register-empresa").hide();
            $("#login-button-empresa").hide();
        });
    });
    var formCandidato = $("#form-register-candidato");
    formCandidato.submit(function (e) {
        e.preventDefault();
        var emailCandidato = $("#email").val();
        var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        // @ts-ignore
        var valid = regex.test(emailCandidato);
        if (valid == false) {
            $('#error-email').show();
        }
        else {
            $('#error-email').hide();
        }
    });
    $(document).ready(function () {
        validate();
        $('#nomeSobrenome, #dataDeNascimento, #email , #CPF , #pais ,  #formacao, #descricaoCandidato, #cep , #password').change(validate);
    });
    function validate() {
        // @ts-ignore
        if ($('#nomeSobrenome').val().length > 0 &&
            // @ts-ignore
            $('#dataDeNascimento').val().length > 0 &&
            // @ts-ignore
            $('#CPF').val().length > 0 &&
            // @ts-ignore
            $('#pais').val().length > 0 &&
            // @ts-ignore
            $('#formacao').val().length > 0 &&
            // @ts-ignore
            $('#descricaoCandidato').val().length > 0 &&
            // @ts-ignore
            $('#cep').val().length > 0 &&
            // @ts-ignore
            $('#password').val().length > 0 &&
            // @ts-ignore
            $('#email').val().length > 0) {
            $("#login-button-candidato").prop("disabled", false);
        }
        else {
            $("#login-button-candidato").prop("disabled", true);
        }
    }
    formCandidato.submit(function (e) {
        var nomeCandidato = $("#nomeSobrenome").val();
        var nascimentoCandidato = $("#dataDeNascimento").val();
        var emailCandidato = $("#email").val();
        var CPFCandidato = $("#CPF").val();
        var paisCandidato = $("#pais").val();
        var formacaoCandidato = $("#formacao").val();
        var descricaoCandidato = $("#descricaoCandidato").val();
        var CEPCandidato = $("#cep").val();
        var passwordCandidato = $("#password").val();
        var angularCandidato = $("#angular").is(':checked');
        var javaCandidato = $("#java").is(':checked');
        var groovyCandidato = $("#groovy").is(':checked');
        var pythonCandidato = $("#python").is(':checked');
        var typescriptCandidato = $("#typescript").is(':checked');
        var trigger = $(".trigger").val();
        var formCandidato = $("#form-register-candidato");
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/candidatos/add',
            dataType: "text",
            data: {
                "trigger": trigger,
                "nomeSobrenome": nomeCandidato,
                "dataDeNascimento": nascimentoCandidato,
                "email": emailCandidato,
                "CPF": CPFCandidato,
                "pais": paisCandidato,
                "formacao": formacaoCandidato,
                "descricaoCandidato": descricaoCandidato,
                "cep": CEPCandidato,
                "password": passwordCandidato,
                "angular": angularCandidato,
                "java": javaCandidato,
                "groovy": groovyCandidato,
                "python": pythonCandidato,
                "typescript": typescriptCandidato
            },
            success: function () {
                window.location.href = "../../Login/LoginCandidato/loginCandidato.html";
            },
            error: function () {
                alert("Alguma coisa deu errado ai maninho");
            }
        });
    });
    var formEmpresa = $("#form-register-empresa");
    formEmpresa.submit(function (e) {
        e.preventDefault();
        var nomeEmpresa = $("#nomeSobrenome-empresa").val();
        var emailEmpresa = $("#email-empresa").val();
        var CPFEmpresa = $("#CNPJ").val();
        var paisEmpresa = $("#pais-empresa").val();
        var descricaoEmpresa = $("#descricao-empresa").val();
        var passwordEmpresa = $("#password-empresa").val();
        var CEPEmpresa = $("#cep-empresa").val();
        var trigger = $(".trigger-empresa").val();
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/empresas/add',
            dataType: "text",
            data: {
                "trigger": trigger,
                "nomeSobrenomeEmpresa": nomeEmpresa,
                "emailEmpresa": emailEmpresa,
                "CNPJ": CPFEmpresa,
                "paisEmpresa": paisEmpresa,
                "descricaoEmpresa": descricaoEmpresa,
                "CEPempresa": CEPEmpresa,
                "passwordEmpresa": passwordEmpresa
            },
            success: function () {
                window.location.href = "../../Login/LoginCandidato/loginCandidato.html";
            },
            error: function () {
                alert("Alguma coisa deu errado ai maninho");
            }
        });
    });
});
