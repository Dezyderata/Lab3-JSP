<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="domain.LoanApplication"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="loanService" class="service.LoanService" scope="application"></jsp:useBean>
	<jsp:useBean id="loan" class="domain.LoanApplication" scope="session"></jsp:useBean>
	<jsp:useBean id="parameters" class="domain.LoanParameters" scope="session"></jsp:useBean>
	<jsp:useBean id="person" class="domain.Person" scope="session"></jsp:useBean>
	<jsp:useBean id="address" class="domain.Address" scope="session"></jsp:useBean>
	
	<jsp:setProperty property="*" name="address"/>
	<%
		loan.setParameters(parameters);
		loan.setPerson(person);
		loanService.add(loan);
		loan.setAddress(address);
	%>
	<ul>
		<%
			for(LoanApplication loanApplication: loanService.getAll()){
		%>
		<li>Wniosek: <%=loanApplication.getNumber()
							+" Osoba: " + loanApplication.getPerson().getSurname()
							+" Kwota: " + loanApplication.getParameters().getAmount()
							+" Miasto: " + loanApplication.getAddress().getCity()%></li>
	
		<%
			}
		%>
	</ul>
</body>
</html>