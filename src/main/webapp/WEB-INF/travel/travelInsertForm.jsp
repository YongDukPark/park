<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>	<!-- jsp 복붙형식 -->

<style>
	.err{
		font-size : 13px;
		color:red;
		font-weight: bold;
	}
</style>


travel\travelInsertForm.jsp<br>    
    
<h2><b>여행 정보 등록 화면</b></h2>
<form:form commandName="travel" action="insert.tv" method="post">	<!-- commandName="travel"여기에는 controll에 bean 이름이 들어가거나 별칭이 들어간다. -->
	이름 <input type="text" name="name">
	<form:errors cssClass="err" path="name"/><br><br>
	나이 <input type="text" name="age">
	<form:errors cssClass="err" path="age"/><br><br>
	
	관심지역
	<input type="checkbox" name="area" value="유럽">유럽
	<input type="checkbox" name="area" value="동남아">동남아
	<input type="checkbox" name="area" value="일본">일본
	<input type="checkbox" name="area" value="중국">중국
	<form:errors cssClass="err" path="area"/>
	<br><br>
	여행타입
	<input type="radio" name="style" value="패키지">패키지
	<input type="radio" name="style" value="크루즈">크루즈
	<input type="radio" name="style" value="자유여행">자유여행
	<input type="radio" name="style" value="골프여행">골프여행
	<form:errors cssClass="err" path="style"/>
	<br><br>
	가격
	<select name="price">
		<option value="선택">선택</option>
		<option value="100~200">100~200</option>
		<option value="200~300">200~300</option>
		<option value="300~400">300~400</option>
		<option value="400~500">400~500</option>
	</select>
	<form:errors cssClass="err" path="price"/>
	<br><br>
	<input type="submit" value = "추가">
</form:form>
