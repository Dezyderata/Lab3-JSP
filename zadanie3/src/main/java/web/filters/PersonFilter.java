package web.filters;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Address;
import domain.ParamIterator;
import domain.Person;
import domain.mappers.PersonResultMapper;
import validation.PersonValidation;

@WebFilter({"/success.jsp", "/address.jsp"})
public class PersonFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		Person person;
		if((person=(Person)session.getAttribute("person")) == null) {
			if((person = retrievePersonFromRequest(httpRequest)) == null) {
				httpResponse.sendRedirect("index.jsp?error=1");
				return;	
			}
		}
		PersonValidation validation = new PersonValidation(person);
		validation.doPersonValidation();
		if(!validation.getAnswer()) {
			request.setAttribute("Validation", validation.getProblem());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	private Person retrievePersonFromRequest(HttpServletRequest request) {
		ParamIterator paramIterator = new ParamIterator(request);
		if(paramIterator.getAns()) {
			return null;
		}else {
			PersonResultMapper person = new PersonResultMapper();
			return person.map(request);
		}
	}	

}
