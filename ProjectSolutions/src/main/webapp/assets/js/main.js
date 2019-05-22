// Fecha os alerts de sucesso e erro 
$(function () {
    $(".close").click(function (e) {
        e.preventDefault();
        el = $('.alert');
        $(el).hide();
    });
});

// Mascara para os campos de valor
function valorProduto() {
    var valorUnitario = document.getElementById('valorUnitario').value;
    if (valorUnitario.length === 0) {
        document.getElementById('valorUnitario').value = 'R$';
    } else if (valorUnitario.length === 4) {
        var maskValor = 'R$' + valorUnitario.substring(2, 5) + ',';
        document.getElementById('valorUnitario').value = maskValor;
    } else if (valorUnitario.length === 7) {
        var maskValor = 'R$' + valorUnitario.substring(2, 4) +
                valorUnitario.substring(5, 6) + ',' +
                valorUnitario.substring(6, 7);
        document.getElementById('valorUnitario').value = maskValor;
    } else if (valorUnitario.length === 8) {
        var maskValor = 'R$' + valorUnitario.substring(2, 5) +
                valorUnitario.substring(6, 7) + ',' +
                valorUnitario.substring(7, 8);
        document.getElementById('valorUnitario').value = maskValor;
    }
}

// Adiciona e remove o input de produto
$(function () {
    var container = $('#divProduto');
    $(document).on('click', '#addInput', function () {
        $('<p>' +
                '<label for="codigoProduto">Código do produto:</label>' +
                '<a href="javascript:void(0)" id="removerInput" style="float: right;">' +
                    '<span><i class="far fa-trash-alt"></i> Remover produto </span>' +
                '</a>' +
                '<select class="custom-select inputForm" id="codigoProduto" name="codigoProduto">' +
                    '<option selected ="" disabled="" hidden="">Código do produto</option>' +
                    '<c:forEach var="produto" items="${listaProdutos}">' +
                        '<option value="<c:out value="${produto.codigoProduto}"/>">' +
                            '<c:out value="${produto.nomeProduto}"></c:out>' +
                        '</option>' +
                    '</c:forEach>' +
                '</select>' +
                '<label for="quantidade">Quantidade:</label>' + 
                '<input type="number" class="form-control inputForm col-5" id="quantidade" placeholder="Quantidade" name="quantidade" min="0">' + 
                '<label for="valor">Valor:</label>' + 
                '<input type="number" class="form-control inputForm col-5" id="valor" placeholder="Valor do Produto" name="valor" min="0">' +
        '</p>').appendTo(container);
        return false;
    });
    $(document).on('click', '#removerInput', function () {
        $(this).parents('p').remove();
        return false;
    });
});