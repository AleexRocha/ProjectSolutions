// Mascara de CPF
$('#cpfCliente').mask('000.000.000-00');

// Mascara de Valor
$('#valor').mask('R$000,00');
$('#valorTotal').mask('R$000,00');

// Mascara de CEP
$('#cep').mask('00.000-000');

// Mascara de Telefone
$('#telefone').mask('(00) 0000-0000');

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

//Função de alterar a quantidade de produtos
var input = $(".input-quantidade");
input.val(1);
$(".altera").click(function () {
    if (($(this).hasClass('input-number-increment')) && (input.val() < 5)) {
        input.val(parseInt(input.val()) + 1);
    } else if (($(this).hasClass('input-number-decrement')) && (input.val() > 1)) {
        input.val(parseInt(input.val()) - 1);
    }
});

//Funções para calcular o total do carrinho
function moneyTextToFloat(text){
    var cleanText = text.replace("R& ","").replace(",", ".");
    return parseFloat(cleanText);
}

function floatToMoneyText(value){
    var text = (value < 1 ? "0" : "") + Math.floor(value * 100);
    text = "R$ " + text;
    return text.substr(0, text.length - 2) + "," + text.substr(-2);
}

function readTotal(){
    var total = document.getElementById("precoTotal");
    return moneyTextToFloat(total.innerHTML);
}

function writeTotal(value){
    var total = document.getElementById("precoTotal");
    total.innerHTML = floatToMoneyText(value);
}

function calculaTotalProdutos(){
    var produtos = document.getElementsByClassName("produto");
    var totalProdutos = 0;
    
    for (var pos = 0; pos < produtos.length; pos ++){
        var precoElementos = produtos[pos].getElementsByClassName("preco");
        var precoTexto = precoElementos[0].innerHTML;
        var preco = moneyTextToFloat(precoTexto);
        
        var qtdElementos = produtos[pos].getElementsByClassName("input-quantidade");
        var qtdTexto = qtdElementos[0].value;
        var quantidade = moneyTextToFloat(qtdTexto);
        
        var subtotal = quantidade * preco;
        
        totalProdutos += subtotal;
    }
    return totalProdutos;
}

function quantidadeMudou(){
    writeTotal(calculaTotalProdutos());
}

function onDocumentLoad(){
    var textEdit = document.getElementsByClassName("input-quantidade");
    for (var i = 0; i < textEdit.length; i++){
        textEdit[i].onchange = quantidadeMudou();
    };
}