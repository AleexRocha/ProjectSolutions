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

// Adiciona e remove o input de produto
$(function () {
    var container = $('#divProduto');
    $(document).on('click', '#addInput', function () {
        $(container).clone().appendTo(container);
        /*$('<p>' +             
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
         });*/
        $(document).on('click', '#removerInput', function () {
            $(this).parents('p').remove();
            return false;
        });
    });
});

//AJAX de upload de imagens
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
function salvarImagem() {
//    let botao = document.querySelector("#upload-button");
//    botao.addEventListener("click", function (ev) {
    let xhr = new XMLHttpRequest();
    xhr.open('POST', '/produtos/upload', true);
    xhr.send();
//    });
}