google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(googleLoaded);

function drawChart(data, title, divId) {

    var chart = new google.visualization.ChartWrapper({
        chartType: 'PieChart',
        containerId: divId,
        dataTable: google.visualization.arrayToDataTable(data),
        options: {
            title: title,
            is3D: true
        }
    });

    chart.draw();
}