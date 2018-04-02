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
	</head>
	<body>
		<script type="text/javascript">
			$(function(){
				$("#v_editpwd_panel").panel({
					title:"修改密码",
					width:300,
					height:220,
					buttons:[{
						text:"修改密码"
					}]
				});
				
				initEdit();
			});
			function initEdit(){
				$("#v_oldpwd").validatebox({
					required:true,
					missingMessage:"旧密码不能为空...",
					validType:"length[6,16]",
					invalidMessage:"旧密码长度必须在6-16之间..."					
				});
			}
			function editPwd(){
				
			}
		</script>	
		<center>
			<div style="height: 75px;"></div>
			<div id="v_editpwd_panel">
				<form id="v_editpwd_form">
					<div style="width: 100%;height: 145px;">	
						<div style="height: 30px;">
						</div>
						<table>
							<tr>
								<td>旧密码:</td>
								<td>	
									<input type="password" id="v_oldpwd" />
								</td>
							</tr>
							<tr>
								<td>新密码:</td>
								<td>	
									<input type="password" id="v_newpwd" />
								</td>
							</tr>
							<tr>
								<td>确认密码:</td>
								<td>	
									<input type="password" id="v_repwd" />
								</td>
							</tr>
						</table>
					</div>
					<div align="right" style="padding-right: 10px;background-color: #FEF2E8;padding: 5px;">
						<a class="easyui-linkbutton" onclick="editPwd()">保存修改</a>
					</div>
				</form>	
			</div>
		</center>
	
	
	
	
	
	
	
	
	
	
	
	
	</body>
</html>


