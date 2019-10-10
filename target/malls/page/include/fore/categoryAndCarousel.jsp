
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<script>

    $(function(){


        $("div.rightMenu span").mouseleave(function(){
            $("img#catear").hide();
        });

        var left = $("div#carousel-of-product").offset().left;
        $("div.categoryMenu").css("left",left-20);
        $("div.categoryWithCarousel div.head").css("margin-left",left);
        $("div.productsAsideCategorys").css("left",left-20);

    });


    $(function () {
        $("#CategoryButton").click(function () {
            $(".categoryMenu").fadeToggle("");
        })


    })

</script>
<style>
    .head2{
        width: 200px;
        background-color: #610B38;
        height: 36px;
        line-height: 36px;
        font-size: 16px;
        font-weight: bold;
        color: white;
        margin-l: 80px;
        display: inline-block;
    }

    .head3{
        width: 200px;
        background-color: #610B38;
        height: 36px;
        line-height: 36px;
        font-size: 16px;
        font-weight: bold;
        color: white;
        margin-l: 120px;
        display: inline-block;
    }
</style>


<div class="categoryWithCarousel">

    <div class="headbar show1" >
        <div class="head " style="display: inline-block;cursor: pointer">
            <span style="margin-left:50px" id="CategoryButton">商品分类</span>
        </div>

            <div class="head2 " style="display: inline-block;cursor: pointer">
                <span style="margin-left:50px" id="nae">科幻</span>
            </div>
s
        <div class="head3" style="display: inline-block;cursor: pointer">
            <span style="margin-left:50px" id="ds">网络小说</span>
        </div>

        <div class="head3" style="display: inline-block;cursor: pointer">
            <span style="margin-left:50px" id="ds1">文学</span>
        </div>


    </div>

    <div class="categoryMenu" style="margin-top: 37px; display: none;background: black;opacity: 0.5;">
        <c:forEach items="${ForeCategory}" var="category">
            <div  class="eachCategory"  >
              <a  style="color: white;font-weight:bold" href="/fore/categoryGoods?categoryName=${category.name}">${category.name}</a>
            </div>
        </c:forEach>
    </div>







    <div id="carousel-of-product"  class="carousel-of-product carousel slide1" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-of-product" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-of-product" data-slide-to="1"></li>
            <li data-target="#carousel-of-product" data-slide-to="2"></li>
            <li data-target="#carousel-of-product" data-slide-to="3"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img class="carousel carouselImage" src="../../image/fore/fore/5.jpg" >
            </div>
            <div class="item">
                <img  class="carouselImage" src="../../image/fore/fore/6.jpg" >
            </div>
            <div class="item">
                <img  class="carouselImage" src="../../image/fore/fore/7.jpg" >
            </div>

            <div class="item">
                <img  class="carouselImage" src="../../image/fore/fore/8.jpg" >
            </div>
        </div>

    </div>

    <div class="carouselBackgroundDiv">
    </div>




</div>

