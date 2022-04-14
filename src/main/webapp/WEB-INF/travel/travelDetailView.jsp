<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
travelDetailView.jsp<br>

<form align="center">
	<h2> <!-- align="center" -->여행 상세 화면</h2>
	<table border="1" align="center">
		<%-- <%=((TravelBean)request.getAttribute("travel")).getName() %> --%>
		<tr>
			<td>번호</td>
			<td>${requestScope.travel.num }</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${travel.name }</td>
		</tr>
		<tr>
			<td>관심지역</td>
			<td>${travel.getArea() }</td>
		</tr>
		<tr>
			<td>여행타입</td>
			<td>${travel.getStyle() }</td>	<!--  -->
		</tr>
		<tr>
			<td>가격대</td>
			<td>${travel.price }</td>
		</tr>
		<tr>
			<td colspan="2">
				<a href="list.tv?pageNumber=${pageNumber}">여행 리스트 화면으로 돌아감</a>
			</td>
		</tr>
	</table>
</form>