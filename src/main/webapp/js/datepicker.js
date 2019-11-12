$(document).ready(function () {
    var today = new Date();
    var date = $('#dateDaDisabilitare').val();
    var tempDate = date.substr(1, date.length - 2);
    var splittedDate = tempDate.split(", ");

    console.log(date);

    $("#date1").datepicker({
        format: 'yyyy-mm-dd',
        todayBtn: 1,
        startDate:today,
        datesDisabled: splittedDate,
        autoclose: true,
    }).on('changeDate', function (selected) {
        var minDate = new Date(selected.date.valueOf());
        $('#date2').datepicker('setStartDate', minDate);
    });

    $("#date2").datepicker({
        format: 'yyyy-mm-dd'
    })
        .on('changeDate', function (selected) {
            var maxDate = new Date(selected.date.valueOf());
            $('#date1').datepicker('setEndDate', maxDate);
        });

});
/*$('#date2').datepicker("option", "disabled", true);

$('#date1').datepicker({
    format: 'yyyy-mm-dd',
    startDate: today,
    datesDisabled: splittedDate,
    onSelect: $('#date2').datepicker("option", "disabled", false)
});*/

/*

console.log($('#date1').val());
$('#date2').datepicker({
    format: 'yyyy-mm-dd',
    startDate: $('#date1').val(),
    datesDisabled: splittedDate
});*/



