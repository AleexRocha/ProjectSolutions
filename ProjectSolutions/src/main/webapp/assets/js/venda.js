$(function () {
    var container = $('#divProduto');
    var i = $('#codigoProduto').size() + 1;

    $(document).on('click', '#addInput', function () {
        $('<p>' +
                '<label for="codigoProduto">Código do produto:</label>' +
                '<a href="javascript:void(0)" id="removerInput" class="ctrl-produto">' +
                '<span><i class="far fa-trash-alt"></i> Remover produto </span>' +
                '</a>' +
                '<input type="number" class="form-control inputForm" id="codigoProduto" placeholder="Código do produto" name="codigoProduto' + i + '">' +
                '</p>').appendTo(container);
        i++;
        return false;
    });

    $(document).on('click', '#removerInput', function () {
        $(this).parents('p').remove();
        i--;
        return false;
    });
});