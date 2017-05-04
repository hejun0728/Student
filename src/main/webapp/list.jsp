<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.biz.entity.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
   

    <title>学生列表</title>
      
  
</head>
<body>
<%
    List<Student> studentList = (List<Student>) request.getAttribute("studentList");
    String cur_page = (String) request.getAttribute("cur_page");
    int pagecount = (Integer) request.getAttribute("totalPage");
%>

    <h3 align="center">学生信息表</h3>
    <br>

<div align="center">
    <button type="button" onclick="window.location.href='add.jsp'">添加学生信息
    </button>
    <br><br>
    <table border="1" width="600">
        <tr>
            <td>学号</td>
              <td>姓名</td>
                <td>平均分</td>
                  <td>出生日期</td>
                    <td>备注</td>
                    <td>管理</td>
        
        </tr>
        <c:forEach items="${studentList}" var="bean">
            <tr>
                <td>${bean.id}</td>
                <td>${bean.name}</td>
                <td>${bean.avgscore}</td>
                <td><fmt:formatDate value="${bean.birthday}" pattern="yyyy-MM-dd"/></td>
                <td>${bean.description}</td>
                <td><a href="DelStudent?id=${bean.id}">删除</a>/<a href="UpdateStudent?id=${bean.id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <div class="text-center">
        <button type="button" 
                onclick="last_page()"><
            <上一页>
        </button>
        <span>&nbsp;&nbsp;<%=cur_page%>/<%=pagecount%>&nbsp;&nbsp;</span>
        <button type="button"
                onclick="next_page()">下一页>>
        </button>

    </div>

</div>
<script>
    function next_page() {
        var cur = <%=cur_page%>;
        var count = <%=pagecount%>;
        if (cur < count) {
            window.location.href = "ListStudent?cur_page=" + (cur + 1);
        } else {
            alert("已经是最后一页了！");
        }
    }
    function last_page() {
        var cur = <%=cur_page%>;
        if (cur > 1) {
            window.location.href = "ListStudent?cur_page=" + (cur - 1);
        } else {
            alert("已经是第一页了！");
        }
    }
</script>

</body>
</html>