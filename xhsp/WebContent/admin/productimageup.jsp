<%@page import="com.xh.shopping.util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String strId = request.getParameter("id");
	int id = 0;
	if (!StringUtil.isEmpty(strId)) {
		id = Integer.valueOf(strId);
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传图片</title>
</head>
<body>
	<form id="form1" method="post" action="../servlet/FileUpload"
		enctype="multipart/form-data">
		<input type="hidden" name="id" value="<%=id%>">
		<tr>
			<td width="25%" align="right">上传图片：</td>
			<td><input id="file1" type="file" NAME="file1"
				style="width: 300px;"></td>
		</tr>
		<!-- 
		<tr>
			<td width="25%" align="right">上传音频：</td>
			<td><input id="file2" type="file" NAME="file2"
				style="width: 300px;"></td>
		</tr> -->
		<tr align="center" valign="middle">
			<td height="60" colspan="2"><input type="submit" id="BtnOK"
				value="确认上传">
				<button onclick="javascript:window.opener == null;window.close();">取消上传</button>
			</td>
		</tr>
		<tr align="center" valign="middle">
			<td height="60" colspan="2"><input type="text" name="possess"
				value="private"></td>
		</tr>
	</form>

	<form name="uploadform" method="POST" action="../servlet/FileUpload"
		ENCTYPE="multipart/form-data">

		<table border="1" width="450" cellpadding="4" cellspacing="2"
			bordercolor="#9BD7FF">

			<tr>
				<td width="100%" colspan="2">文件1：<input name="x" size="40"
					type="file">

				</td>
			</tr>

			<tr>
				<td width="100%" colspan="2">文件2：<input name="y" size="40"
					type="file">

				</td>
			</tr>

			<tr>
				<td width="100%" colspan="2">文件3：<input name="z" size="40"
					type="file">

				</td>
			</tr>

		</table>

		<br /> <br />

		<table>

			<tr>
				<td align="center"><input name="upload" type="submit"
					value="开始上传" /></td>
			</tr>

		</table>

	</form>


</body>
</html>