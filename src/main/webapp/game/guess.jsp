<%@ page import="com.systex.hw3.service.GameService" %>
<%@ page import="java.util.LinkedList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<% request.setAttribute("title", "猜數字"); %>

<jsp:include page="/layout/layout.jsp"/>

<body>
<div class="container">
    <% GameService gameService = (GameService) session.getAttribute("gameService"); %>
    <%--沒有經過GameController的連線會強制跳轉到gameController--%>
    <% if (gameService == null) {
        response.sendRedirect("gameController.do");
        return; // 中止頁面的繪製
    } %>
    <h1>猜數字</h1>
    <%-- 此處為錯誤報告 --%>
    <%
        LinkedList<String> errors = (LinkedList<String>) request.getAttribute("errors");
    %>
    <%
        if (errors != null) {
    %>

    <%
        for (String error : errors) {
    %>

    <div class="alert alert-danger" role="alert">
        <%=error%>
    </div>
    <%
        }
    %>
    <%
        }
    %>

    <form action="gameController.do" method="POST">
        <div class="mb-3">
            <label id="RetryCount" name="RetryCount" class="form-label">剩餘次數 <%= gameService.getRemains()%>
            </label>
        </div>
        <div class="mb-3">
            <label id="guessLabel" name="guessLabel" class="form-label">數字</label>
            <input type="number" id="guessNumber" name="guessNumber" class=class="form-control"
                   value="${ param.group }"/>
            <div id="groupHelp" class="form-text">輸入您要猜測的數字，大小由1到10</div>
        </div>

        <input type="reset" class="btn btn-secondary" value="重置"/>
        <input type="submit" class="btn btn-primary" value="猜數字"/>
    </form>
</div>
</body>
