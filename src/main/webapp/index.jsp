<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="jakarta.servlet.jsp.jstl.core.*" %>

<% request.setAttribute("title", "HomeWork3"); %>

<jsp:include page="/layout/layout.jsp" />
<body>
<div class="text-center ">
    <h1>HomeWork 3</h1>
    <div class="container">
        <ul class="list-group" >
            <li class="list-group-item" >
                <a class="link-offset-2 link-underline link-underline-opacity-0" href="lottery/main.jsp">Lottery Number</a>
            </li>
            <li class="list-group-item" >
                <a class="link-offset-2 link-underline link-underline-opacity-0" href="game/gameController.do">Guess
                    Number</a>
            </li>
        </ul>
    </div>
</div>
</body>
