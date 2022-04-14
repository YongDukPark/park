<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
travelUpdateForm.jsp<br>

<%@ include file="../common/common.jsp" %>	<!-- jsp 복붙형식 -->

<style>
	.err{
		font-size : 13px;
		color:red;
		font-weight: bold;
	}
</style>

<%
	String[] areaArr = {"유럽","동남아","일본","중국"};
	String[] styleArr = {"패키지","크루즈","자유여행","골프여행"};
	String[] priceArr = {"선택","100~200","200~300","300~400","400~500"};
						/*선택 이렇게 넣으면 value에더 들어가서 오류 못잡는다 등신아.  */
%>

<style>
	.err{
		font-size : 13px;
		color:red;
		font-weight: bold;
	}
</style>


travel\travelInsertForm.jsp<br>    
    
<h2><b>여행 정보 수정 화면(페이지 : ${pageNumber })</b></h2>
<form:form commandName="travel" action="update.tv" method="post">	<!-- commandName="travel"여기에는 controll에 bean 이름이 들어가거나 별칭이 들어간다. -->
									<!-- 여기서 ?페이지넘=페이지넘el 이런식으로 보내도 된다. -->
	<input type="hidden" name="num" value="${travel.num }">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	이름 <input type="text" name="name" value="${travel.name }">
	<form:errors cssClass="err" path="name"/><br><br>
	나이 <input type="text" name="age" value="${travel.age }">
	<form:errors cssClass="err" path="age"/><br><br>
	
	관심지역
	
	<c:forEach var="area" items="<%=areaArr %>">
		<input type="checkbox" name="area" value=${area } <c:if test="${fn:contains(travel.area, area) }"> checked </c:if>  >${area }
	</c:forEach>																<!-- 이것이     , 여기에 포함되어있냐 이뜻 -->
	
	
	<!-- <input type="checkbox" name="area" value="유럽">유럽
	<input type="checkbox" name="area" value="동남아">동남아
	<input type="checkbox" name="area" value="일본">일본
	<input type="checkbox" name="area" value="중국">중국 -->
	
	<form:errors cssClass="err" path="area"/>
	<br><br>
	여행타입
	
	<c:forEach var="style" items="<%=styleArr %>">
		<input type="radio" name="style" <c:if test="${style eq travel.style }">checked="checked"</c:if> value="${style }" >${style }
	</c:forEach>
	<!-- <input type="radio" name="style" value="패키지">패키지
	<input type="radio" name="style" value="크루즈">크루즈
	<input type="radio" name="style" value="자유여행">자유여행
	<input type="radio" name="style" value="골프여행">골프여행 -->
	
	<form:errors cssClass="err" path="style"/>
	<br><br>
	가격
	<select name="price">
	
	<c:forEach var="price" items="<%=priceArr %>">
		<option value="${price }" <c:if test="${price eq travel.price }"> selected="selected" </c:if> >${price }
	</c:forEach>

	</select>
	<form:errors cssClass="err" path="price"/>
	<br><br>
	<input type="submit" value = "수정">
</form:form>