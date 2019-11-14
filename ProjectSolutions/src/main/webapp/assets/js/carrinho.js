//Função de alterar a quantidade de produtos
function atualizarCarrinho(e) {
    let data = e.getAttribute('data-posicao');
    let input = document.getElementsByClassName('input-quantidade')[data - 1];
    let inputQuantidadeCarrinho = document.getElementById('quantidadeProdCarrinho');

    if ((e.classList.contains('input-number-increment')) && (parseInt(input.value) < 5)) {
        input.value = parseInt(input.value) + 1;
        inputQuantidadeCarrinho.value = input.value;
    } else if ((e.classList.contains('input-number-decrement')) && (parseInt(input.value) > 1)) {
        input.value = parseInt(input.value) - 1;
        inputQuantidadeCarrinho.value = input.value;
    }
}

//Cria ajax que salva os produtos
function salvarProdutos() {
    let tableParser = new TableParser();
    console.log(tableParser.toJSON());
    let xhr = new XMLHttpRequest();
    xhr.open('POST',"../venda/create_venda",true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
    xhr.send(JSON.stringify(tableParser.toJSON()));
    xhr.onreadystatechange = function () {
        if (xhr.status >= 200 && xhr.status < 400) {
            let data = xhr.responseText;
            console.log(data);
        }else{
            console.log("Deu ruim");
        }
    };
//    $.ajax({
//        method: "POST",
//        url: 
//        dataType: "json",
//        data: JSON.stringify(tableParser.toJSON())
//    }).done(function (dataJson) {
//        alert("Deu bom");
//        alert(dataJson);
//    }).fail(function (data) {
//        alert("Deu ruim");
//        alert(data);
//    });
}

let TableParser = function () {
    let trs = document.getElementsByClassName('carrinho');
    let _trsInJSON = [];
    this.toJSON = function () {
        for (let idx in trs) {
            if (trs.hasOwnProperty(idx)) {
                _trsInJSON[idx] = _trToJSON(trs[idx]);
            }
        }
        return _trsInJSON;
    };
    function _trToJSON(tr) {
        let idProduto = getIdProduct(tr.children[0]);
        let valorUnitarioProduto = getUnityValue(tr.children[1]);
        let quantidadeUnitarioProduto = getQuantity(tr.children[2]);
        let valorTotalProduto = valorUnitarioProduto * quantidadeUnitarioProduto;
        return {
            idProduto,
            valorUnitarioProduto,
            quantidadeUnitarioProduto,
            valorTotalProduto
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