//Função de alterar a quantidade de produtos
function atualizarCarrinho(e) {
    let data = e.getAttribute('data-posicao');
    let input = document.getElementsByClassName('input-quantidade')[data - 1];
    if ((e.classList.contains('input-number-increment')) && (parseInt(input.value) < 5)) {
        input.value = parseInt(input.value) + 1;
    } else if ((e.classList.contains('input-number-decrement')) && (parseInt(input.value) > 1)) {
        input.value = parseInt(input.value) - 1;
    }

    recalcularValores();
    atualizaValoresSessao();
}

//Funções para recalcular o valor total do carrinho
function recalcularValores() {
    let trs = document.getElementsByClassName("carrinho");
    let html = "<h5 class=\"total\">R$  palavra</h5>";
    let valorsubtotal = 0;
    for (let i = 0; i < trs.length; i++) {
        let unitario = getValorUnitario(trs[i].children[1]);
        let quantidade = getValorQuantidade(trs[i].children[2]);
        let total = unitario * quantidade;
        trs[i].children[3].innerHTML = html.replace("palavra", parseFloat(total.toFixed(2)));
        valorsubtotal += parseFloat(total.toFixed(2));
    }

    let valorEntrega = getValorEntrega();

    valorsubtotal += Number(valorEntrega);

    let tdSubtotal = $(".subtotal");
    tdSubtotal[0].innerHTML = html.replace("palavra", parseFloat(valorsubtotal.toFixed(2)));

    function getValorUnitario(td) {
        let value = td.getElementsByClassName('unitario')[0].innerHTML;
        return Number(value.replace('R$ ', '').replace(',', '.'));
    }

    function getValorQuantidade(td) {
        return Number(td.getElementsByClassName('input-quantidade')[0].value);
    }

    function getValorEntrega() {
        let radios = document.getElementsByName("entrega");

        for (let i = 0; i < radios.length; i++) {
            if (radios[i].checked) {
                return radios[i].value;
            }
        }

        return 0;
    }
}

function atualizaValoresSessao() {
    let dataJson = new DataJson();

    let xhr = new XMLHttpRequest();
    xhr.open('POST', "../produto/atualiza_quantidade", true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
    xhr.send(JSON.stringify(data.toJSON()));
    xhr.onreadystatechange = function () {
        let data = xhr.responseText;
        console.log(data);
    };
}

let DataJson = function () {
    let trs = document.getElementsByClassName("carrinho");
    let dataJson = [];
    this.toJSON = function () {
        for (let i = 0; i < trs.length; i++) {
            let codigo = getIdProduto(trs[i].children[0]);
            let quantidadeEstoque = getValorQuantidade(trs[i].children[2]);

            data[i] = {codigo, quantidadeEstoque};
        }
    }

    function getIdProduto(td) {
        return Number(td.getElementsByClassName('idProduto')[0].innerHTML);
    }

    function getValorQuantidade(td) {
        return Number(td.getElementsByClassName('input-quantidade')[0].value);
    }
}

// Função que altera a quantidade de produtos na descrição do produto
function atualizarQuantidade(e) {
    let data = e.getAttribute('data-posicao');
    let input = document.getElementsByClassName('input-quantidade')[data - 1];
    if ((e.classList.contains('input-number-increment')) && (parseInt(input.value) < 5)) {
        input.value = parseInt(input.value) + 1;
    } else if ((e.classList.contains('input-number-decrement')) && (parseInt(input.value) > 1)) {
        input.value = parseInt(input.value) - 1;
    }

    atualizarInputQuantidade(e);
}

function atualizarInputQuantidade(e) {
    let data = e.getAttribute('data-posicao');
    let input = document.getElementsByClassName('input-quantidade')[data - 1];
    let newQuantidade = document.getElementById('quantidadeProdCarrinho');

    newQuantidade.value = input.value;
}

// Adiciona os inputs de valores de entrega na tela
$('#endereco').change(function () {
    let valores = "<td id=\"valores\">"
            + "<p>Valores:</p>"
            + "<div class=\"form-check\">"
            + "<input class=\"form-check-input input-entrega\" id=\"expressa\" type=\"radio\" name=\"entrega\" value=\"15.00\" checked=\"checked\">"
            + "<label class=\"form-check-label\" for=\"expressa\">"
            + "Expressa: R$ 15,00"
            + "</label>"
            + "</div>"
            + "<div class=\"form-check\">"
            + "<input class=\"form-check-input input-entrega\" id=\"agendada\" type=\"radio\" name=\"entrega\" value=\"15.00\">"
            + "<label class=\"form-check-label\" for=\"agendada\">"
            + "Agendada: R$ 15,00"
            + "</label>"
            + "</div>"
            + "</td>";
    $('#valores').replaceWith(valores);
    recalcularValores();
});