${



}
import { * } from './jquery.min.js';

$(document).ready(function() {
    $('#itemidButtonAjaxDec').click(function(event) {
        var proid = $('#itemidButtonAjaxDec').val();
        var opsType = $('#opsTypeDec').val();
        $.get('CartServlet', {
            itemid : proid,
            ops : opsType
        }, function(responseText) {
            $('#ajaxGetResponse').text(responseText);
        });
    });
    $('#itemidButtonAjaxInc').click(function(event) {
        var proid = $('#itemidButtonAjaxInc').val();
        var opsType = $('#opsTypeInc').val();
        $.get('CartServlet', {
            itemid : proid,
            ops : opsType
        }, function(responseText) {
            $('#ajaxGetResponse').text(responseText);
        });
    });
    $('#itemidButtonAjaxDel').click(function(event) {
        var proid = $('#itemidButtonAjaxDel').val();
        var opsType = $('#opsTypeDel').val();
        $.get('CartServlet', {
            itemid : proid,
            ops : opsType
        }, function(responseText) {
            $('#ajaxGetResponse').text(responseText);
        });
    });
});



function updateCart(pid, cnt, ops) {
    let link = "../CartServlet?itemid=" + pid+"&ops="+ops;
    console.log("salamlar sucuklar");
    if(cnt==0){
        $("tr#pid" + pid).remove();
    }
    else{
        cnt = Math.abs(cnt);
        for (let i = 0; i < cnt; i++) {
            $.get(link, function(data) {
                if (data <= "0")
                    $("tr#pid" + pid).remove();
                else
                    $("tr#pid" + pid + " div#cnt").text(data.toString());

            });
        }
    }
}