//Função de alterar a quantidade de produtos
var input = $(".input-quantidade");
input.val(1);
$(".altera").click(function (e) {
    var idBotao = $("span.altera[data-id]");
    var id = idBotao.attr("data-id");
    if (($(this).hasClass('input-number-increment')) && (input.val() < 5)) {
        input.val(parseInt(input.val()) + 1);
    } else if (($(this).hasClass('input-number-decrement')) && (input.val() > 1)) {
        input.val(parseInt(input.val()) - 1);
    }
});
//Funções para calcular o total do carrinho
//function moneyTextToFloat(text) {
//    var cleanText = text.replace("R& ", "").replace(",", ".");
//    return parseFloat(cleanText);
//}
//
//function floatToMoneyText(value) {
//    var text = (value < 1 ? "0" : "") + Math.floor(value * 100);
//    text = "R$ " + text;
//    return text.substr(0, text.length - 2) + "," + text.substr(-2);
//}
//
//function readTotal() {
//    var total = document.getElementById("precoTotal");
//    return moneyTextToFloat(total.innerHTML);
//}
//
//function writeTotal(value) {
//    var total = document.getElementById("precoTotal");
//    total.innerHTML = floatToMoneyText(value);
//}
//
//function calculaTotalProdutos() {
//    var produtos = document.getElementsByClassName("produto");
//    var totalProdutos = 0;
//    for (var pos = 0; pos < produtos.length; pos++) {
//        var precoElementos = produtos[pos].getElementsByClassName("preco");
//        var precoTexto = precoElementos[0].innerHTML;
//        var preco = moneyTextToFloat(precoTexto);
//        var qtdElementos = produtos[pos].getElementsByClassName("input-quantidade");
//        var qtdTexto = qtdElementos[0].value;
//        var quantidade = moneyTextToFloat(qtdTexto);
//        var subtotal = quantidade * preco;
//        totalProdutos += subtotal;
//    }
//    return totalProdutos;
//}
//
//function quantidadeMudou() {
//    writeTotal(calculaTotalProdutos());
//}
//
//function onDocumentLoad() {
//    var textEdit = document.getElementsByClassName("input-quantidade");
//    for (var i = 0; i < textEdit.length; i++) {
//        textEdit[i].onchange = quantidadeMudou();
//    }
//}

//Cria ajax que salva os produtos
function salvarProdutos() {
    let tableParser = new TableParser();
    console.log(tableParser.toJSON());
    $.ajax({
        method: "POST",
        url: "../venda/create_venda",
        dataType: "json",
        data: JSON.stringify(tableParser.toJSON())
    });
}

let TableParser = function () {
    let trs = document.getElementsByClassName('carrinho');
    let _trsInJSON = {};

    this.toJSON = function () {
        for (let idx in trs) {
            if (trs.hasOwnProperty(idx)) {
                _trsInJSON[idx] = _trToJSON(trs[idx]);
            }
        }
        return _trsInJSON;
    };

    function _trToJSON(tr) {
        let codigoProduto = getIdProduct(tr.children[0]);
        let nomeProduto = getProductName(tr.children[0]);
        let valorUnitario = getUnityValue(tr.children[1]);
        let quantidadeVendida = getQuantity(tr.children[2]);
        let totalVenda = valorUnitario * quantidadeVendida;
        return {
            codigoProduto,
            nomeProduto,
            valorUnitario,
            quantidadeVendida,
            totalVenda
        }
    }

    function getIdProduct(td) {
        let id = td
                .getElementsByClassName('media-body')[0]
                .getElementsByTagName('p')[0].innerHTML;
        return id;
    }

    function getProductName(td) {
        return td
                .getElementsByClassName('media-body')[0]
                .getElementsByTagName('p')[1].innerHTML;
    }

    function getUnityValue(td) {
        let value = td.getElementsByClassName('unitario')[0].innerHTML;
        return Number(value.replace('R$', ''));
    }

    function getQuantity(td) {
        return Number(td.getElementsByClassName('input-quantidade')[0].value);
    }

    return this;
}