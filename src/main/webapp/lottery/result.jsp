<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<% request.setAttribute("title", "樂透選號結果"); %>
<jsp:include page="/layout/layout.jsp" />

<body>
<div class="container">
	<h1>生成結果</h1>
	<p class="lead">排除數字 ${ excludeNumber }</p>
	<% ArrayList<Integer>[] lotteryArray = (ArrayList<Integer>[]) request.getAttribute("lotterys"); %>
	<table class="table table-hover">
		<thead>
		<th>組數</th>
		<th>號碼</th>
		</thead>
		<tbody>
		<% for (int i = 0; i < lotteryArray.length; i++) { %>
		<tr>
			<th scope="row">第<%= i + 1 %>組</th>
			<td><% for (Integer number : lotteryArray[i]) { %>
				<%= number + " " %>
				<%}%>
			</td>
		</tr>
		<%}%>
		</tbody>
	</table>
	<a href="<%=request.getContextPath()%>/lottery/main.jsp">
		<button class="btn btn btn-secondary">再生成一次</button>
	</a>
	<a href="<%=request.getContextPath()%>">
		<button class="btn btn-primary">回首頁</button>
	</a>

</div>

</body>
