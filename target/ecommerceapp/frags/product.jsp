<%@ taglib uri="dsp" prefix="dsp"%>
<dsp:page>

    <dsp:droplet name="ProductBrowsed">
        <dsp:param param="product" name="eventobject"/>
    </dsp:droplet>
    <h1><dsp:valueof param="product.displayName" /></h1>
    <!-- display images, related content, etc... -->
    ...
    <dsp:form action="." method="post" id="addtocart">
        <input name="id" type="hidden" value='<dsp:valueof param="product.repositoryId"/>' />
        <select id="selectSKU">
            <dsp:droplet name="ForEach">
                <dsp:param name="array" param="product.childSKUs"/>
                <dsp:oparam name="output">
                    <option value="<dsp:valueof param="element.id" />" ><dsp:valueof param="element.size" /> </option>
                </dsp:oparam>
            </dsp:droplet>
        </select>
        <select id="quantity">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select>
        <a href="#"><img src="images/add2cart.jpg" onclick="addtocart()" alt="Add To Cart" border="0" /></a>
    </dsp:form>