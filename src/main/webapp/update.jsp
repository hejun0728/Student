<%@ page import="com.biz.entity.Student"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>

<html>
<head>


<title>修改学生信息</title>

</head>
<%
	Student student = (Student) request.getAttribute("student");
%>
<body>
	<div align="center">
		<h1>修改信息</h1>

		<form action="UpdateCommit" method="post">
			<table border="1">
				<tr>
					<td>学号:</td>
					<td><input type="hidden" name="id"
						value="<%=student.getId()%>">
						 <input type="text"  id="id" value="<%=student.getId()%>" disabled="true "></td>
				</tr>
				<tr>
					<td>姓名：</td>
					<td><input type="text" id="name" name="name"
						value="<%=student.getName()%>"></td>
				</tr>
				<tr>
					<td>平均成绩：</td>
					<td><input type="text" id="avgscore" name="avgscore"
						value="<%=student.getAvgscore()%>"></td>
				</tr>
				<tr>
					<td>出生日期：</td>
					<td><input type="text" id="birthday" name="birthday"
						value="<%=new SimpleDateFormat("yyyy-MM-dd").format(student.getBirthday())%>" /></td>
				</tr>
				<tr>
					<td>备注</td>
					<td><textarea rows="4" id="description" name="description"><%=student.getDescription()%></textarea></td>
				</tr>

				<tr>
					<td><button type="submit">提交</button></td>
					<td><button type="reset">重置</button></td>
				</tr>

			</table>

		</form>

	</div>


</body>
</html>