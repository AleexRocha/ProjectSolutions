// Mascara de CPF
//$('#cpfCliente').mask('000.000.000-00');

// Mascara de Valor
//$('#valor').mask('R$000,00');
//$('#valorTotal').mask('R$000,00');

// Mascara de CEP
//$('#cep').mask('00000-000');

// Mascara de Telefone
//$('#telefone').mask('(00) 0000-0000');

//Tabela responsiva
jQuery(function($){
	$('.table').footable();
});

// Fecha os alerts de sucesso e erro 
$(function () {
    $(".close").click(function (e) {
        e.preventDefault();
        el = $('.alert');
        $(el).hide();
    });
});

// Metodo para corrigir a exclusão de produtos/usuarios
function defineCodigo(valor) {
    let origem = valor;
    let destino = document.getElementById('destino');

    destino.value = origem;
}

//Função de preview ao selecionar um arquivo
function preview() {
    let image = document.getElementById("preview-image");
    let file = document.querySelector("input[type=file]").files[0];

    let reader = new FileReader();
    reader.onloadend = function () {
        image.src = reader.result;
    };
    if (file) {
        reader.readAsDataURL(file);
        image.classList.remove("sr-only");
    } else {
        image.src = "";
    }
}

//AJAX de upload de imagens
function salvarImagem() {
    let xhr = new XMLHttpRequest();
    xhr.open('POST', '/produtos/upload', true);
    xhr.onloadstart = function (e) {
        console.log("start");
    };
    xhr.onprogress = function (e) {
        if (e.lengthComputable) {
            console.log(e.loaded + " / " + e.total);
        }
    };
    xhr.onloadend = function (e) {
        console.log("end");
    };
    xhr.send();
}

//AJAX que busca o CEP
jQuery(function ($) {
    $("#cep").change(function () {
        var cep_code = $(this).val();
        if (cep_code.length <= 0)
            return;
        $.get("http://apps.widenet.com.br/busca-cep/api/cep.json", {code: cep_code},
                function (result) {
                    if (result.status != 1) {
                        alert(result.message || "Houve um erro desconhecido");
                        return;
                    }
                    $("input#estado").val(result.state);
                    $("input#cidade").val(result.city);
                    $("input#bairro").val(result.district);
                    $("input#logradouro").val(result.address);
                });
    });
});