/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#msg_txt").keyup(function (e) {
        if(e.keyCode == 13){
            var message = $("#msg_txt").val();
            var JsonMessage = {"message": message};
            $("#msg_txt").val('');
            $.ajax({
                url:'ChatServelt',
                dataType: 'json',
                data: JsonMessage,
                success: function (data) {
                     //$('#messages').html(data.name + "<br/>" + data.message);
                }
            });
        }
    });
});


$( document ).ready(function() {
         $.ajax({
            type: 'POST', //servlet request type
            contentType: 'application/json', //For input type //input data
            dataType: 'json',
            url: "UserServlet",
            success: function (data) {
                //var messageArray=JSON.parse(data);
                var div = $("#users");
                var d = "<table class=\"table\"><tr><th scope=\"col\">name</th></tr>";
                for (var i = 0; i < data.length; i++) {
                    if(data[i].status == "online" ){
                         d += "<tr><td scope=\"row\" class=\"table-success\">" + data[i].name + "</td></tr>";
                    }else{
                        d += "<tr><td scope=\"row\" class=\"table-danger\">" + data[i].name + "</td></tr>";
                    }
//                   d += "<tr><td scope=\"row\" class=\"table-danger\">" + data[i].name + "</td><td scope=\"row\" class=\"table-danger\">" + data[i].status + "</td></tr>";
                }
                d += "</table>";
                div.html(d);
            }
        });
    });

function myFunction() {
    setInterval(function () {
        $.ajax({
            type: 'POST', //servlet request type
            contentType: 'application/json', //For input type //input data
            dataType: 'json',
            url: "ChatServelt",
            success: function (data) {
                //var messageArray=JSON.parse(data);
                var div = $("#messages");
                var d = "<table class=\"table\"><tr><th scope=\"col\">name</th><th scope=\"col\">message</th></tr>";
                for (var i = 0; i < data.length; i++) {
                    d += "<tr><td scope=\"row\">" + data[i].name + "</td><td scope=\"row\">" + data[i].message + "</td></tr>";
                }
                d += "</table>";
                div.html(d);
            }
        });
    }, 1000);
    
}

