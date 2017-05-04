<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>

<html>
<head>


  
<title>添加学生信息</title>

</head>
<body>
	<h3 align="center">添加学生信息</h3>

	<form action="AddStudent" method="post">
	 <table align="center" border="1" >
        <tr>
            <td >学号：</td>
            <td><input type="text"  id="id" name="id"></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td>	<input type="text" id="name" name="name"></td>
        </tr>
        <tr>
            <td >平均成绩：</td>
            <td><input type="text" id="avgscore" name="avgscore"></td>
        </tr>
        <tr>
            <td >出生日期</td>
            <td><input type="text"  id="birthday"
			placeholder="yyyy-mm-dd" name="birthday"></td>
        </tr>
        <tr>
            <td >备注：</td>
            <td>
            	<textarea  rows="4" id="description"
				name="description"></textarea>
            </td>
        </tr>
        
        <tr>
            <td ></td>
            <td>
              <button type="submit" >提交</button>
		<button type="reset" >重置</button> 
            </td>
        </tr>
    </table>
	

	</form>




</body>
</html>