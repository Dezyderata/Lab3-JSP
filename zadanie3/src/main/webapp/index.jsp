<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	${Validation}
	<br/>
	<%if(request.getParameter("error")!=null){
		if(request.getParameter("error").equals("1")){%>
		<h2>Nie wypełniłeś poprzednich danych wniosku!</h2>
	<%}else if(request.getParameter("error").equals("2")){ %>
		<h2>Błędne dane wniosku!</h2>
	<%}else if(request.getParameter("error").equals("3")){%>
		<h2>Błędne dane w wysokości pożyczki lub w ilości rat!</h2>
	<%}}%>
	
Witaj na stronie <strong>Pożyczek u Bronka</strong>-<em>"Komornik to nasz przyjaciel"</em>
</br>
<a href="/loanParameters.jsp"> złóż wniosek online</a>

</body>
</html>