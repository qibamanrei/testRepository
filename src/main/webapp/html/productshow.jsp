r<%@ page import="java.util.List" %>
<%@ page import="com.shopping.bean.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <style type="text/css">
        /* 超链接去下划线 */
        a {
            text-decoration: none;
            color: black;
        }

        /*头部logo居中*/
        #div1 {
            margin-left: 300px; /*或padding*/
        }
    </style>

    <script>
        //轮播图
        var i = 9;

        function loop() {
            var picsrc = document.getElementById('loopPic');
            picsrc.src = "${pageContext.request.contextPath}/img/img" + i + ".jpg";
            if (i < 9) {
                i++;
            } else {
                i = 8;
            }
        }

        onload = setInterval(loop, 5000);


    </script>
</head>
<body>
    <!--顶端及轮播图-->
    <table width="100%">
        <tr height="50px">
            <td>
                <table width="100%">
                    <tr>
                        <td>
                            <img src="${pageContext.request.contextPath}/img/logo.jpg" alt="">
                        </td>
                        <td>
                            <div id="div1">
                                <img src="${pageContext.request.contextPath}/img/img5.jpg" alt="">&nbsp;&nbsp;&nbsp;
                                <img src="${pageContext.request.contextPath}/img/img6.jpg" alt="">&nbsp;&nbsp;&nbsp;
                                <img src="${pageContext.request.contextPath}/img/img7.jpg" alt="">&nbsp;&nbsp;&nbsp;
                                <img src="${pageContext.request.contextPath}/img/img4.jpg" alt="">&nbsp;
                            </div>
                        </td>
                        <td align="center">
                            <c:choose>
                                <c:when test="${sessionScope.user!=null}">
                                    <font color="black">欢迎您，${sessionScope.user.username}</font>&nbsp;&nbsp;
                                    <a href="${pageContext.request.contextPath}/LoginOutServlet" onclick="return confirm('确定退出吗?')"><font color="#337AB7">退出</font></a>&nbsp;&nbsp;
                                </c:when>
                                <c:otherwise>
                                    <a href="${pageContext.request.contextPath}/html/login.jsp"><font color="#337AB7">登录</font></a>&nbsp;&nbsp;&nbsp;
                                    <a href="${pageContext.request.contextPath}/html/register.jsp"><font color="#337AB7">注册</font></a>&nbsp;&nbsp;
                                </c:otherwise>
                            </c:choose>
                            <a href="${pageContext.request.contextPath}/html/cart.jsp"><font color="#337AB7">购物车</font></a>&nbsp;&nbsp;
                        </td>
                    </tr>
                </table>
            </td>
f
        </tr>

        <tr bgcolor="#808080" height="50px">
            <td>
                <font color="white">首页</font>&nbsp;&nbsp;&nbsp;&nbsp;
                <font color="white">精品手机</font>&nbsp;&nbsp;&nbsp;&nbsp;
                <font color="white">数码时尚</font>&nbsp;&nbsp;&nbsp;&nbsp;
                <font color="white">办公设备</font>&nbsp;&nbsp;&nbsp;&nbsp;
                <font color="white">主板显卡</font>&nbsp;&nbsp;&nbsp;&nbsp;
                <font color="white">智能设备</font>&nbsp;&nbsp;&nbsp;&nbsp;
                <font color="white">Macbook</font>&nbsp;&nbsp;&nbsp;&nbsp;
            </td>
        </tr>
        <tr>
            <td>
                <p></p>
                <!--轮播图-->
                <img id="loopPic" src="${pageContext.request.contextPath}/img/img8.jpg" width="100%" height="300px">
            </td>
        </tr>
    </table>
    <p></p>

    <!--第一块图片展示-->
    <table width="100%">
        <tr>
            <td colspan="5">
                <font size="5px">热门商品</font>
                <img src="${pageContext.request.contextPath}/img/title2.jpg">
            </td>
        </tr>
        <c:forEach items="${requestScope.hotList}" var="product" begin="0" end="${requestScope.hotList.size()}"
                   varStatus="status">
            <c:if test="${(status.index)%5 == 0}">
                <tr align="center">
            </c:if>
            <td>
                <a href="${pageContext.request.contextPath}/ProductInfoServlet?productId=${product.proId}">
                    <img src="${product.proMinImg}" width="70%"><br>
                    <font color="red">${product.shopPrice}</font><br>
                    <sapn>${product.proName}</sapn>
                </a>
            </td>
            <c:if test="${(status.index)%5 == 4}">
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <p></p>

    <!--横幅图片-->
    <img src="${pageContext.request.contextPath}/img/img2.webp" width="100%">
    <p></p>

    <!--第二块图片展示-->
    <table width="100%">
        <tr>
            <td colspan="5">
                <font size="5px">优选商品</font>
                <img src="${pageContext.request.contextPath}/img/title2.jpg">
            </td>
        </tr>
        </tr>
        <c:forEach items="${requestScope.optimizationList}" var="product" begin="0" end="${requestScope.optimizationList.size()}"
                   varStatus="status">
            <c:if test="${(status.index)%5 == 0}">
                <tr align="center">
            </c:if>
            <td>
                <a href="${pageContext.request.contextPath}/ProductInfoServlet?productId=${product.proId}">
                    <img src="${product.proMinImg}" width="70%"><br>
                    <font color="red">${product.shopPrice}</font><br>
                    <sapn>${product.proName}</sapn>
                </a>
            </td>
            <c:if test="${(status.index)%5 == 4}">
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <p></p>

    <!--横幅图片-->
    <img src="${pageContext.request.contextPath}/img/img1.webp" width="100%">
    <p></p>

    <!--底部文字-->
    <table width="100%">
        <tr align="center" height="50px">
            <td>
                <a href="*"><font color="#337ab7">关于我们</font></a>&nbsp;&nbsp;
                <a href="*"><font color="#337ab7">联系我们</font></a>&nbsp;&nbsp;
                <a href="*"><font color="#337ab7">联系客服</font></a>&nbsp;&nbsp;
                <a href="*"><font color="#337ab7">合作招商</font></a>&nbsp;&nbsp;
                <a href="*"><font color="#337ab7">商家帮助</font></a>&nbsp;&nbsp;
                <a href="*"><font color="#337ab7">营销中心</font></a>&nbsp;&nbsp;
                <a href="*"><font color="#337ab7">手机帮助</font></a>&nbsp;&nbsp;
                <a href="*"><font color="#337ab7">销售联盟</font></a>&nbsp;&nbsp;
            </td>
        </tr>
        <tr align="center">
            <td>
                &copy;2005-2020&nbsp;东易买版权所有，并保留所有权利
            </td>
        </tr>
    </table>

</body>
</html>
