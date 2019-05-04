//Fecha os alerts de sucesso e erro 
$(function () {
    $(".close").click(function (e) {
        e.preventDefault();
        el = $('.alert');
        $(el).hide();
    });
});