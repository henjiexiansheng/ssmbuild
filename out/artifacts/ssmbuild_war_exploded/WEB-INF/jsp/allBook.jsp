<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示</title>
    <%--BootStrap 美化界面--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表 ------ 显示所有书籍</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <!--toaddbook-->
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toaddbook">新增书籍</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allbook">显示全部数据</a>
            </div>

            <div class="col-md-4 column"></div>
            <div class="col-md-4 column">
                <!--搜索书籍-->
                <form action="${pageContext.request.contextPath}/book/searchbookname" method="post" class="form-inline">
                    <span style="color: #ff0000;font-weight: bold">${error}</span>
                    <input type="text" name="searchBookName" class="form-control" placeholder="请输入要搜索的书籍名称">
                    <input type="submit" value="搜索" class="btn btn-primary">
                </form>
            </div>
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                    <tr>
                        <th>书籍编号</th>
                        <th>书籍名称</th>
                        <th>书籍数量</th>
                        <th>书籍详情</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <%--书籍从数据库中查询出来的，从msg中遍历出来--%>
                <tbody>
                    <c:forEach var="book" items="${msg}">
                        <tr>
                            <td>${book.bookID}</td>
                            <td>${book.bookName}</td>
                            <td>${book.bookCounts}</td>
                            <td>${book.detail}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/book/toupdatebook?id=${book.bookID}">修改</a>
                                &nbsp;|&nbsp;
                                <a href="${pageContext.request.contextPath}/book/deletebook/${book.bookID}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
