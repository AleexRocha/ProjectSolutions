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
                '<input type="number" class="form-control inputForm" id="codigoProduto" placeholder="Código do produto" name="codigoProduto">' +
                '</p>').appendTo(container);
        return false;
    });
    $(document).on('click', '#removerInput', function () {
        $(this).parents('p').remove();
        return false;
    });
});