<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="jakarta.servlet.jsp.jstl.core.*" %>

<% request.setAttribute("title", "HomeWork3"); %>

<jsp:include page="/layout/layout.jsp" />


<div class="text-center ">
    <h1>HomeWork 3</h1>
    <div class="container">
        <ul class="list-group" >
            <li class="list-group-item" >
                <a class="link-offset-2 link-underline link-underline-opacity-0" href="lottery/main.jsp">Lottery Number</a>
            </li>
            <li class="list-group-item" >
                <a class="link-offset-2 link-underline link-underline-opacity-0" href="game/guess.jsp">Guess Number</a>
            </li>
        </ul>
    </div>



</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>