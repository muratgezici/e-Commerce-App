
    <script src="javascripts/jquery-3.6.0.min.js" type="text/javascript"></script>

    <script type="text/javascript">
    function addtocart() {
    var selObject = returnObjById("selectSKU");
    var selIndex = selObject.selectedIndex;
    var selQuantity = returnObjById("quantity");
    if(selObject.value == "") {
    alert("please select a size");
    return false;
    }
    if(selQuantity.value == "") {
    alert("please select a quantity");
    return false;
    }
    updateCartURL = "frags/minicart.jsp?dcs_action=additemtocart&url_catalog_ref_id=" + selObject.options
    [selIndex].value + "&url_product_id=<dsp:valueof param="productId"/>&url_quantity=" + selQuantity.value;
    cartsummaryURL = "frags/cartsummary.jsp";
    $('#minicart').load(updateCartURL,function(){$('#cartsummary').load(cartsummaryURL);});
    $('#minicart').slideDown('slow');
    }
    function returnObjById(id) {
    if (document.getElementById) {
    var returnVar = document.getElementById(id);
    } else {
    if (document.all) {
    var returnVar = document.all[id];
    } else {
    if (document.layers) {
    var returnVar = document.layers[id];
    }
    }
    }
    return returnVar;
    }
    </script>
