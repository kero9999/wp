<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	pageContext.setAttribute("basePath", basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>后台项目</title>
		<style type="text/css">
			@IMPORT url("${basePath}css/easyui.css");
			@IMPORT url("${basePath}css/icon.css");
		</style>
		<script type="text/javascript" src="${basePath }js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${basePath }js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${basePath }js/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript">
			$(function(){
				//隐藏最上面Panel的折叠按钮
				$(".layout-button-up").css("display","none");
				//验证用户是否已经登录
				$.ajax({
					url:"users/isLogin",
					cache:false,
					dataType:"json",
					success:function(obj){
						if(obj==null){
							//未登录,登录窗体初始化
							initLoginDlg();
						}else{
							//已登录,设置用户名
							$("#v_users_name").html(obj.name);
							//初始化菜单
							initMenu();
						}
					}
				});
				
			});
			function initLoginDlg(){
				//初始化账号和密码
				$("#v_account").validatebox({
					required:true,
					missingMessage:"账号不能为空...",
					validType:"length[6,16]",
					invalidMessage:"账号长度必须在6-16之间..."
				});
				$("#v_pwd").validatebox({
					required:true,
					missingMessage:"密码不能为空...",
					validType:"length[6,16]",
					invalidMessage:"密码长度必须在6-16之间..."
				});
				$("#v_login_form").form({
					url:"users/login",
					onSubmit:function(){
						return $("#v_login_form").form("validate");
					},
					success:function(obj){
						if(obj!=""){
							//登录成功
							obj=eval("("+obj+")");
							$.messager.alert("提示","登录成功，欢迎"+obj.name+"使用本系统...","info");
							//设置用户名
							$("#v_users_name").html(obj.name);
							//关闭登录窗体
							$("#v_login_dlg").dialog("close");
							//初始化菜单
							initMenu();
						}else{
							$.messager.alert("提示","登录失败！账号或密码错误...","error");
							$("#v_pwd").val("");
							$("#v_account").val("");
						}
					}
				});
				//登录窗体
				$("#v_login_dlg").dialog({
					title:"登录窗体",
					width:300,
					height:180,
					modal:true,
					closable:false,
					buttons:[{
						text:"登录",
						handler:function(){
							$("#v_login_form").submit();
						}
					}]
				});
			}
			function exit(){
				$.ajax({
					url:"users/exit",
					cache:false,
					success:function(obj){
						location="${basePath}";
					}
				});
			}
			function initMenu(){
				$("#v_menu").tree({
					url:"menu/init",
					onDblClick:function(node){
						var v_url=node.attributes.url;
						var v_title=node.text;
						//判断是否已经存在，如果存在则选中。否则添加
						var temp=$("#v_tabs").tabs("getTab",v_title);
						if(temp==null){
							//不存在
							$("#v_tabs").tabs("add",{
								title:v_title,
								closable:true,
								href:v_url
							});
						}else{
							//已存在
							$("#v_tabs").tabs("select",v_title);
						}
					}
				});
			}
		</script>
	</head>
	<body class="easyui-layout">
		<div region="north" title="<div align='right'>你好,<span id='v_users_name'></span>.<a href='javascript:void(0)' onclick='exit()'>[注销]</a></div>" collapsible="false" style="height:100px;"></div>  
		<div region="west" title="菜单栏" split="true" style="width:150px;">
			<ul id="v_menu"></ul>
		</div>  
		<div region="center" title="功能列表" style="padding:5px;background:#eee;">
			<div id="v_tabs" class="easyui-tabs" fit="true">
			</div>
		</div>  
		
		
		
		<!-- 登录窗体 -->
		<div id="v_login_dlg" align="center" style="padding-top: 30px;">
			<form id="v_login_form" method="post">
				<table>
					<tr>
						<td>账号:</td>
						<td>
							<input type="text" id="v_account" name="account"/>
						</td>
					</tr>
					<tr>
						<td>密码:</td>
						<td>
							<input type="password" id="v_pwd" name="password"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>


