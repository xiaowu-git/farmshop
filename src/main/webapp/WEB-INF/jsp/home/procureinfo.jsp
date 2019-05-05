<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/tag.jsp" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <title>采购页面</title>

    <link href="${pageContext.request.contextPath }/resources/assets/css/admfront.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/resources/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/resources/basic/css/demo.css" rel="stylesheet" type="text/css" />
    <link type="text/css" href="${pageContext.request.contextPath }/resources/css/optstyle.css" rel="stylesheet" />
    <link type="text/css" href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet" />
    <link href="https://cdn.bootcss.com/toastr.js/2.1.4/toastr.min.css" rel="stylesheet">

    <%--<script type="text/javascript" src="${pageContext.request.contextPath }/resources/basic/js/jquery-1.7.min.js"></script>--%>
    <script src="${pageContext.request.contextPath }/resources/assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/basic/js/quick_links.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/assets/js/amazeui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.imagezoom.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.flexslider.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/list.js"></script>
    <script src="https://cdn.bootcss.com/toastr.js/2.1.4/toastr.min.js"></script>

</head>

<body>


<!--顶部导航条 -->

<%@include file="../common/header.jsp" %>

<div class="clear"></div>
<b class="line"></b>
<div class="listMain">

    <!--分类-->
    <%@include file="../common/navtable.jsp" %>
    <ol class="am-breadcrumb am-breadcrumb-slash">
        <li><a href="#">首页</a></li>
        <li><a href="#">分类</a></li>
        <li class="am-active">采购详情</li>
    </ol>
    <script type="text/javascript">
        $(function() {});
        $(window).load(function() {
            $('.flexslider').flexslider({
                animation: "slide",
                start: function(slider) {
                    $('body').removeClass('loading');
                }
            });
        });
    </script>
    <div class="scoll">
        <section class="slider">
            <div class="flexslider">
                <ul class="slides">
                    <li>
                        <img src="${pageContext.request.contextPath }/${fsProcurementProducts.procurementProdPicture }" title="pic" />
                    </li>
                    <%--<li>
                        <img src="${pageContext.request.contextPath }/resources/images/02.jpg" />
                    </li>
                    <li>
                        <img src="${pageContext.request.contextPath }/resources/images/03.jpg" />
                    </li>--%>
                </ul>
            </div>
        </section>
    </div>

    <!--放大镜-->

    <div class="item-inform">
        <div class="clearfixLeft" id="clearcontent">

            <div class="box">
                <script type="text/javascript">
                    $(document).ready(function() {
                        $(".jqzoom").imagezoom();
                        $("#thumblist li a").click(function() {
                            $(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
                            $(".jqzoom").attr('src', $(this).find("img").attr("mid"));
                            $(".jqzoom").attr('rel', $(this).find("img").attr("big"));
                        });
                    });
                </script>

                <div class="tb-booth tb-pic tb-s310">
                    <a href="${pageContext.request.contextPath }/${fsProcurementProducts.procurementProdPicture }"><img src="${pageContext.request.contextPath }/${fsProcurementProducts.procurementProdPicture }" alt="细节展示放大镜特效" rel="${pageContext.request.contextPath }/${fsProcurementProducts.procurementProdPicture }" class="jqzoom" /></a>
                </div>
                <ul class="tb-thumb" id="thumblist">
                    <%--<li class="tb-selected">
                        <div class="tb-pic tb-s40">
                            <a href="#"><img src="${pageContext.request.contextPath }/resources/images/01_small.jpg" mid="${pageContext.request.contextPath }/resources/images/01_mid.jpg" big="${pageContext.request.contextPath }/resources/images/01.jpg"></a>
                        </div>
                    </li>--%>
                </ul>
            </div>

            <div class="clear"></div>
        </div>

        <div class="clearfixRight">

            <!--规格属性-->
            <!--名称-->
            <div class="tb-detail-hd">
                <input name="procurementProdId" value="${fsProcurementProducts.procurementProdId }" type="hidden"/>
                <h1>
                    ${fsProcurementProducts.procurementProdName }
                </h1>
            </div>
            <div class="tb-detail-list">
                <!--价格-->
                <div class="tb-detail-price">
                    <li class="price iteminfo_price">
                        <dt>采购价</dt>
                        <dd><em>¥</em><b class="sys_item_price">${fsProcurementProducts.procurementProdPrice } /斤</b>  </dd>
                    </li>
                    <li class="price iteminfo_mktprice">
                        <dt>需求数量</dt>
                        <dd><b class="sys_item_mktprice"></b><em>${fsProcurementProducts.procurementProdNum }斤</em></dd>
                    </li>
                    <div class="clear"></div>
                </div>

                <!--地址-->
                <dl class="iteminfo_parameter freight">
                    <dt>配送至</dt>
                    <div class="iteminfo_freprice">
                        <div class="am-form-content address">
                            <span>${fsProcurementProducts.procurementProdAddress }</span>
                        </div>
                </dl>
                <div class="clear"></div>

                <!--销量-->
                <ul class="tm-ind-panel">
                    <%--<li class="tm-ind-item tm-ind-sellCount canClick">
                        <div class="tm-indcon"><span class="tm-label">月销量</span><span class="tm-count">1015</span></div>
                    </li>
                    <li class="tm-ind-item tm-ind-sumCount canClick">
                        <div class="tm-indcon"><span class="tm-label">累计销量</span><span class="tm-count">6015</span></div>
                    </li>
                    <li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">
                        <div class="tm-indcon"><span class="tm-label">累计评价</span><span class="tm-count">640</span></div>
                    </li>--%>
                </ul>
                <div class="clear"></div>

                <!--各种规格-->
                <dl class="iteminfo_parameter sys_item_specpara">
                    <dt class="theme-login"><div class="cart-title">可选规格<span class="am-icon-angle-right"></span></div></dt>
                    <dd>
                        <!--操作页面-->

                        <div class="theme-popover-mask"></div>

                        <div class="theme-popover">
                            <div class="theme-span"></div>
                            <div class="theme-poptit">
                                <a href="javascript:;" title="关闭" class="close">×</a>
                            </div>
                            <div class="theme-popbod dform">
                                <form class="theme-signin" name="loginform" action="" method="post">

                                    <div class="theme-signin-left">

                                        <div class="theme-options">
                                            <div class="cart-title">口味</div>
                                            <ul>
                                                <li class="sku-line selected">原味<i></i></li>
                                            </ul>
                                        </div>
                                        <div class="theme-options">
                                            <div class="cart-title">包装</div>
                                            <ul>
                                                <li class="sku-line selected">普通纸盒<i></i></li>
                                                <li class="sku-line">特殊泡沫盒<i></i></li>
                                                <li class="sku-line">恒温泡沫盒<i></i></li>
                                            </ul>
                                        </div>
                                        <%--<div class="theme-options">
                                            <div class="cart-title">需求数量</div>
                                            <ul>
                                                <li class="sku-line selected">斤<i></i></li>
                                            </ul>
                                        </div>--%>
                                        <div class="theme-options">
                                            <div class="cart-title number">提供数量</div>
                                            <dd>
                                                <input id="min" class="am-btn am-btn-default" name="" type="button" value="-" />
                                                <input id="text_box" name="procurementProdAmount" type="text" value="1" style="width:30px;" />
                                                <input id="add" class="am-btn am-btn-default" name="" type="button" value="+" />
                                                <span id="Stock" class="tb-hidden"><span class="stock" id="pc_stock">${fsProcurementProducts.procurementProdNum }</span>斤</span>
                                            </dd>

                    </div>
            <div class="clear"></div>

            <div class="btn-op">
                <div class="btn am-btn am-btn-warning">确认</div>
                <div class="btn close am-btn am-btn-warning">取消</div>
            </div>
        </div>
        <div class="theme-signin-right">
            <div class="img-info">
                <%--<img src="${pageContext.request.contextPath }/resources/images/songzi.jpg" />--%>
            </div>
            <div class="text-info">
                <span class="J_Price price-now">¥${fsProcurementProducts.procurementProdPrice } /斤</span>
                <span id="" class="tb-hidden">提供数量<span class="stock" id="app_stock">总需求${fsProcurementProducts.procurementProdNum }</span>件</span>
            </div>
        </div>

        </form>
    </div>
</div>

</dd>
</dl>
<div class="clear"></div>
<!--活动	-->
<div class="shopPromotion gold">
    <div class="hot">
        <dt class="tb-metatit">优惠活动</dt>
        <div class="gold-list">
            <%--<p>购物满2件打8折，满3件7折<span>点击领券<i class="am-icon-sort-down"></i></span></p>--%>
        </div>
    </div>
    <div class="clear"></div>
    <div class="coupon">
        <%--<dt class="tb-metatit">优惠券</dt>
        <div class="gold-list">
            <ul>
                <li>125减5</li>
                <li>198减10</li>
                <li>298减20</li>
            </ul>
        </div>--%>
    </div>
</div>
</div>

<div class="pay">
    <div class="pay-opt">
        <a href="${pageContext.request.contextPath }/home"><span class="am-icon-home am-icon-fw">首页</span></a>
        <a><span class="am-icon-heart am-icon-fw">收藏</span></a>

    </div>
    <li>
        <div class="clearfix tb-btn tb-btn-buy theme-login">
            <a id="LikBuy" title="点此按钮到下一步确认购买信息">立即发货</a>
        </div>
    </li>
    <li>
        <div class="clearfix tb-btn tb-btn-basket theme-login">
            <%--<a id="LikBasket" title="加入购物车" href="#"><i></i>加入购物车</a>--%>
        </div>
    </li>
</div>

</div>

<div class="clear"></div>

</div>
<div class="clear"></div>


<!-- introduce-->

<div class="introduce">
    <div class="browse">
        <div class="mc">
            <ul>
                <div class="mt">
                    <h2>看了又看</h2>
                </div>

                <li class="first">
                    <div class="p-img">
                        <a  href="#"> <img class="" src="${pageContext.request.contextPath }/resources/images/browse1.jpg"> </a>
                    </div>
                    <div class="p-name"><a href="#">
                        【开口松子】零食坚果特产炒货东北红松子原味
                    </a>
                    </div>
                    <div class="p-price"><strong>￥35.90</strong></div>
                </li>

            </ul>
        </div>
    </div>
    <div class="introduceMain">
        <div class="am-tabs" data-am-tabs>
            <ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
                <li class="am-active">
                    <a href="#">
                        <span class="index-needs-dt-txt">采购详情</span></a>
                </li>

            </ul>

            <div class="am-tabs-bd">

                <div class="am-tab-panel am-fade am-in am-active">
                    <div class="J_Brand">

                        <div class="attr-list-hd tm-clear">
                            <h4>产品参数：</h4></div>
                        <div class="clear"></div>
                        <ul id="J_AttrUL">
                            <li title="">采购产品:&nbsp;${fsProcurementProducts.procurementProdName }</li>
                            <li title="">采购用户:&nbsp;${ProcureFsUser.userName }</li>
                            <li title="">采购地址:&nbsp;${fsProcurementProducts.procurementProdAddress }</li>
                            <li title="">联系方式:&nbsp;${ProcureFsUser.userPhone }</li>
                            <li title="">采购开始:&nbsp;<fmt:formatDate value="${pageprocurementProd.effectiveTime }" type="both"/></li>
                            <li title="">采购结束:&nbsp;<fmt:formatDate value="${pageprocurementProd.expirationTime }" type="both"/></li>
                            <li title="">采购详情：&nbsp;${fsProcurementProducts.procurementProdInfo }</li>
                        </ul>
                        <div class="clear"></div>
                    </div>

                    <div class="details">
                        <div class="attr-list-hd after-market-hd">
                            <h4>商品细节</h4>
                        </div>
                        <div class="twlistNews">
                            <p>
                                ${fsProcurementProducts.procurementProdInfo } <br>
                            </p>
                            <img src="${pageContext.request.contextPath }/${fsProcurementProducts.procurementProdPicture }" />
                        </div>
                    </div>
                    <div class="clear"></div>

                </div>

            </div>

        </div>

        <div class="clear"></div>
        <%@include file="../common/footer.jsp" %>
    </div>

</div>
</div>
<!--菜单 -->

<%--<%@include file="../common/menuright.jsp" %>--%>


<script type="text/javascript">

</script>

</body>

</html>