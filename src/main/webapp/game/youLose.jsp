<%@ page import="com.systex.hw3.service.GameService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<% request.setAttribute("title", "你輸了"); %>

<jsp:include page="/layout/layout.jsp"/>

<body>
<% GameService gameService = (GameService) session.getAttribute("gameService"); %>
<%--沒有經過GameController的連線會強制跳轉到gameController--%>
<% if (gameService == null) {
    response.sendRedirect("gameController.do");
    return; // 中止頁面的繪製
} %>
<div class="container">
    <h1>你輸了</h1>
    <p class="lead">終極數字為<%= gameService.getLuckNumber()%>
    </p>
    <a href="<%=request.getContextPath()%>/game/gameController.do">
        <button class="btn btn btn-secondary">再玩一次</button>
    </a>
    <a href="<%=request.getContextPath()%>">
        <button class="btn btn-primary">回首頁</button>
    </a>
</div>

<% session.invalidate(); %>
</body>
