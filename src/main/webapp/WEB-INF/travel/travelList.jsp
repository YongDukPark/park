<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
travel\travelList.jsp<br>

<%@ include file="../common/common.jsp" %>	<!-- jsp 복붙형식 -->

<script type="text/javascript">

	function insert(){
		//alert(1);
		location.href="insert.tv";
	}
	
	function goUpdate(num,pageNumber){
		location.href="update.tv?num="+num+"&pageNumber="+pageNumber;
	}
</script>


<h2 align="center">상품 리스트 화면(레코드 갯수 : ${totalCount })</h2>
<center>	<!-- 이렇게하면 강제로 욱여넣지 않아도 된다.	 -->
<form method="get" action="list.tv" align="center">
	<select name = "whatColumn">	
		<option value="all">전체검색
		<option value="area">나라명
		<option value="style">여행타입
	</select>
	<input type="text" name="keyword" value="유럽">
	<input type="submit" value="검색">
	<!-- whatColumn="asd"&keyword=b -->
</form>
</center>
<table border="1" align="center">
	<tr>
		<td colspan="8" align="right">
			<input type="button" value="추가" onclick="insert()">
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>나이</th>
		<th>관심지역</th>
		<th>여행타입</th>
		<th>예상비용</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
	<c:forEach var = "travel" items="${travelLists }">
	<tr>
		<td>${travel.num }</td>
		<td>
			<a href="detail.tv?num=${travel.num }&pageNumber=${pageInfo.pageNumber}">${travel.name }</a>
		</td>
		<td>${travel.age }</td>
		<td>${travel.area }</td>
		<td>${travel.style }</td>
		<td>${travel.price }</td>
		<td>
			<a href="delete.tv?num=${travel.num }&pageNumber=${pageInfo.pageNumber }">삭제</a>
		</td>
		<td>
			<input type="button" value="수정" onclick="goUpdate('${travel.num}','${pageInfo.pageNumber}')">
		</td>
	</tr>
	</c:forEach>
</table>

<br>

<center>
	${pageInfo.pagingHtml}
</center>


