<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="parameters" class="domain.LoanParameters" scope="session"/>
	<jsp:useBean id="loan" class="domain.LoanApplication" scope="session"></jsp:useBean>
	<jsp:useBean id="person" class="domain.Person" scope="session"></jsp:useBean>	
	
	<jsp:setProperty property="*" name="person"/>

	Numer wniosku: ${loan.number }<br/>
	Wnioskowana kwota: ${parameters.amount }<br/>
	Wnioskodawca:<br/>
	Imie: ${person.firstName} 
	Nazmwisko:  ${person.surname}<br/>
	
	<form action="success.jsp">
		<label>Miasto: <input type="text" id="city" name="city"/></label><br/>
		<label>Kod pocztowy: <input type="text" id="zipCode" name="zipCode"/></label><br/>
		<label>Ulica: <input type="text" id="street" name="street"/></label><br/>
		<label>Numer domu: <input type="text" id="houseNumber" name="houseNumber"/></label><br/>
		<label>Numer mieszkania: <input type="text" id="localNumber" name="localNumber"/></label><br/>
		<label>Numer telefonu: <input type="text" id="phoneNumber" name="phoneNumber"/></label><br/>
		<input type="submit" value="następny krok"/>
	</form>
</body>
</html>