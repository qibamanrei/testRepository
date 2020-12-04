<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/registercss.css">
	<script>
		var usernameFlag = false;
		var password = false;
		var confirm = false;
		var email = false;
		var name = false;
		onload = function (){

			//用户名判断
			var username = document.getElementById('name');
			username.onblur = function nameCheck() {
				var uflag = document.getElementById('usernameFlag');
				var reg = /^[a-zA-Z_$]{4,12}$/;
				if (reg.test(username.value)) {
					usernameFlag = true;
					uflag.style.color = "lightgreen";
					uflag.innerHTML = "&nbsp;&nbsp;&nbsp;√";
				}else{
					usernameFlag = false;
					uflag.style.color = "red";
					uflag.innerHTML = "&nbsp;&nbsp;&nbsp;×,合法用户名为4-12位字母、下划线或$";
				}
			}

			//密码判断
			var password = document.getElementById('inputPassword');
			password.onblur = function pwdCheck() {
				var pflag = document.getElementById('passwordFlag');
				var reg = /^[a-zA-Z0-9]{6,12}$/;
				if (reg.test(password.value)) {
					passwordFlag = true;
					pflag.style.color = "lightgreen";
					pflag.innerHTML = "&nbsp;&nbsp;&nbsp;√";
				}else{
					passwordFlag = false;
					pflag.style.color = "red";
					pflag.innerHTML = "&nbsp;&nbsp;&nbsp;×,合法密码为6-12位字母或数字";
				}
			}

			//确认密码判断
			var confirm = document.getElementById('confirmpwd');
			confirm.onblur = function conCheck() {
				var cflag = document.getElementById('confirmFlag');
				if (password.value == confirm.value) {
					confirmFlag = true;
					cflag.style.color = "lightgreen";
					cflag.innerHTML = "&nbsp;&nbsp;&nbsp;√";
				}else{
					confirmFlag = false;
					cflag.style.color = "red";
					cflag.innerHTML = "&nbsp;&nbsp;&nbsp;×,两次输入密码不一致";
				}
			}

			//Email验证
			var email = document.getElementById('inputEmail');
			email.onblur = function emCheck() {
				var eflag = document.getElementById('emailFlag');
				var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				if (reg.test(email.value)) {
					emailFlag = true;
					eflag.style.color = "lightgreen";
					eflag.innerHTML = "&nbsp;&nbsp;&nbsp;√";
				}else{
					emailFlag = false;
					eflag.style.color = "red";
					eflag.innerHTML = "&nbsp;&nbsp;&nbsp;×,请输入合法邮箱";
				}
			}

			//姓名非空检查
			var name = document.getElementById('usercaption');
			name.onblur = function nmCheck() {
				var nflag = document.getElementById('nameFlag');
				var reg = /^.+$/;
				if (reg.test(name.value)){
					nameFlag = true;
					nflag.style.color = "lightgreen";
					nflag.innerHTML = "&nbsp;&nbsp;&nbsp;√";
				}else{
					nameFlag = false;
					nflag.style.color = "red";
					nflag.innerHTML = "&nbsp;&nbsp;&nbsp;×,请输入姓名";
				}
			}

		}
		//提交检查
		function submitCheck() {
			if (usernameFlag && passwordFlag && confirmFlag && emailFlag && nameFlag){
				return true;
			}else{
				alert("注册失败，请正确填写");
				return false;
			}
		}
	</script>
</head>
<body>

<div>
	<!--第一行：存放logo信息   嵌套一个一行三列的表格 -->
			<tr>
				<td>
					<table   width="100%" >
						<tr>
							<td>
								<img src="${pageContext.request.contextPath}/img/logo.jpg" />
							</td>
							<td >
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
										<font color="black">欢迎您，${sessionScope.user.username}</font>
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
			</tr>
		
</div>

<div style="width:100%;background-image:url('${pageContext.request.contextPath}/image/registerBack.jpg'); background-size: cover;">

			
	<form action="/RegisterServlet" method="post" class="bootstrap-frm" onsubmit="return submitCheck()">
	
	<h1>会员注册
	<span>USER REGISTER.</span>
	</h1>

	<label>
	<span>用户名</span>
	<input id="name" type="text" name="username" placeholder="请输入用户名" /><span id="usernameFlag" class="checkspan"></span>
	</label>

	<label>
	<span>密  码</span>
	<input type="password" name="password" id="inputPassword" placeholder="请输入密码"/><span id="passwordFlag" class="checkspan"></span>
	</label>

	<label>
	<span>确认密码</span>
	<input type="password" id="confirmpwd" placeholder="请输入确认密码"/><span id="confirmFlag" class="checkspan"></span>
	</label>

	<label>
	<span>Email</span>
	<input type="email" name="email" id="inputEmail" placeholder="Email"/><span id="emailFlag" class="checkspan"></span>
	</label>

	<label>
	<span>姓  名</span>
	 <input type="text" name="name" id="usercaption" placeholder="请输入姓名"/><span id="nameFlag" class="checkspan"></span>
	</label>

	


	<label>
	<span>性  别</span><select name="sex">
	<option value="男">男</option>
	<option value="女">女</option>
	</select>
	</label>

	<label>
	<span>出生日期</span>
	<input id="birthday" type="text" name="birthday" placeholder="年-月-日" />
	</label>


	<label>
	<span>&nbsp;</span>
	<input type="submit"  width="100" value="注册" name="submit" border="0"
				    style="background: url('${pageContext.request.contextPath}/image/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
	</label>
	</form>

</div>

<div align="center">
	
		<!--第八行：存放友情链接-->
			<tr>
				<td>
					<p align="center">
						<a href=""><font color="#337AB7">关于我们</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">联系我们</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">联系客服</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">合作招商</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">商家帮助</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">营销中心</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">手机帮助</font></a>&nbsp;&nbsp;
						<a href=""><font color="#337AB7">销售联盟</font></a>&nbsp;&nbsp;
					</p>
				</td>
			</tr>
			<!--第九行：存放版权信息-->
			<tr>
				<td align="center">
					© 2005-2020 东易买 版权所有，并保留所有权利
				</td>
			</tr>

</div>

</body>


</html>