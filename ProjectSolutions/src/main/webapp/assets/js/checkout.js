//Exibe apenas as informações do pagamento selecionados no select
$('#pagamento').change(function () {
    let id;
    $('#pagamento option').each(function () {
        if ($(this).is(":selected")) {
            id = $(this).val();
        }
    });
    $('.cardPagamento').each(function () {
        if ($(this).is("#pagamento" + id)) {
            $(this).removeClass("cardCheckout");
        } else {
            $(this).addClass("cardCheckout");
        }
    });
});

//Exibe apenas as informações do endereço selecionados no select
$('#endereco').change(function () {
    let id;
    $('#endereco option').each(function () {
        if ($(this).is(":selected")) {
            id = $(this).val();
        }
    });
    $('.cardEndereco').each(function () {
        if ($(this).is("#endereco" + id)) {
            $(this).removeClass("cardCheckout");
        } else {
            $(this).addClass("cardCheckout");
        }
    });
});

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
});

//Ajax que salva os produtos
function salvarProdutos() {
    let jsonInvalido = false;
    let tableParser = new TableParser();
    for (var i = 0; i < tableParser.toJSON().length; i++) {
        if (tableParser.toJSON()[i] == null) {
            jsonInvalido = true;
        }
    }
    if (!jsonInvalido) {
        let xhr = new XMLHttpRequest();
        xhr.open('POST', "../venda/create_venda", true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
        xhr.send(JSON.stringify(tableParser.toJSON()));
        xhr.onreadystatechange = function () {
            if (xhr.status >= 200 && xhr.status < 400) {
                let data = xhr.responseText;
                alert(data);
            } else {
                alert("Erro ao salvar a venda.");
            }
        };
    } else {
        alert("JSON invalido, verifique os campos.");
    }
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
        let idProduto = getIdProduto(tr.children[0]);
        let valorUnitarioProduto = getValorUnitario(tr.children[1]);
        let quantidadeUnitarioProduto = getQuantidade(tr.children[2]);
        let valorTotalProduto = valorUnitarioProduto * quantidadeUnitarioProduto;
        let idEndereco = getIdEndereco();
        let valorFrete = getValorFrete();
        let idPagamento = getIdPagamento();

        if ((isNaN(idEndereco)) || (isNaN(idPagamento))) {
            return null;
        }

        return {
            idProduto,
            valorUnitarioProduto,
            quantidadeUnitarioProduto,
            valorTotalProduto,
            idEndereco,
            valorFrete,
            idPagamento
        };
    }

    function getIdProduto(td) {
        let id = td
                .getElementsByClassName('media-body')[0]
                .getElementsByTagName('p')[0].innerHTML;
        return Number(id);
    }

    function getValorUnitario(td) {
        let value = td.getElementsByClassName('unitario')[0].innerHTML;
        return Number(value.replace('R$', ''));
    }

    function getQuantidade(td) {
        return Number(td.getElementsByClassName('input-quantidade')[0].value);
    }

    function getIdEndereco() {
        let id;
        $("#endereco option:selected").each(function () {
            id = $(this).val();
        });
        if (isNaN(id)) {
            $(".msgEndereco").removeClass("sr-only");
        } else {
            $(".msgEndereco").addClass("sr-only");
        }

        return Number(id);
    }

    function getValorFrete() {
        let radios = document.getElementsByName("entrega");
        let valor = 0;
        for (let i = 0; i < radios.length; i++) {
            if (radios[i].checked) {
                valor = radios[i].value;
            }
        }

        return Number(valor);
    }

    function getIdPagamento() {
        let id;
        $('#pagamento option:selected').each(function () {
            id = $(this).val();
        });

        if (isNaN(id)) {
            $(".msgPagamento").removeClass("sr-only");
        } else {
            $(".msgPagamento").addClass("sr-only");
        }

        return Number(id);
    }

    return this;
};