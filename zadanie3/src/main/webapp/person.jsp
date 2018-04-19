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
	
	<jsp:setProperty property="*" name="parameters"/>
	
	Numer wniosku: ${loan.number }<br/>
	Wnioskowana kwota: ${parameters.amount }<br/>
	<form action="address.jsp">
		<label>Imię: <input type="text" id="firstName" name="firstName"/></label><br/>
		<label>Nazwisko: <input type="text" id="surname" name="surname"/></label><br/>
		<label>Nr pesel: <input type="text" id="pesel" name="pesel"/></label><br/>
		<input type="submit" value="następny krok"/>
	</form>
	
</body>
</html>